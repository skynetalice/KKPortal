#
# Copyright 2010 kk-electronic a/s. 
# 
# This file is part of KKPortal.
#
# KKPortal is free software: you can redistribute it and/or modify it
# under the terms of the GNU Lesser General Public License as published
# by the Free Software Foundation, either version 3 of the License, or
# (at your option) any later version.
#
# KKPortal is distributed in the hope that it will be useful,
# but WITHOUT ANY WARRANTY; without even the implied warranty of
# MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
# GNU Lesser General Public License for more details.
#
# You should have received a copy of the GNU Lesser General Public License
# along with KKPortal.  If not, see <http://www.gnu.org/licenses/>.
#
import os

from w2b import settings
from twisted.python import log
import w2b.rpc

_instance = None
def getInstance():
    global _instance
    if not _instance:
        _instance = Features()
    return _instance

def loadSecurityModule(name):
    return getattr(__import__("w2b.security." + name).security,name,None)

def seachFeatures(path):
    unfiltered = []
    for e in path:
        unfiltered += os.listdir(e)
    filtered = [x[:-3] for x in unfiltered if x.endswith('.py') and not x.startswith('_')]
    return set(filtered)

class Features():
    def __init__(self):
        features = settings.getGlobalSetting('features', [])
        if not isinstance(features,list):
            features=[features]
        features = set(features)
        features.add("RemoteServer")
        if 'ALL' in features:
            features = features.union(seachFeatures(w2b.rpc.__path__))
            features.remove('ALL')
        modules = __import__("w2b.rpc",fromlist=list(features))
        self.features = {}
        for featureName in features:
            securityName = settings.getGlobalSetting('security',domain=featureName)
            module = getattr(modules, featureName,None)
            if featureName == 'RemoteServer' and securityName is not None:
                log.msg("Security on RemoteServer feature is not supported")
                securityName = "None"
            if module is None:
                log.msg("Not enabling featureName: %s due to missing code for feature" % featureName )
                continue
            if securityName == "None":
                log.msg("Enabling feature: %s without security" % featureName )
                self.features[featureName]=(module,None,None)
            else:
                securityModule = loadSecurityModule(securityName)
                if securityModule:
                    log.msg("Enabling feature: %s with %s security" % (featureName,securityName) )
                    self.features[featureName]=(module,securityName,securityModule)
                else:
                    log.msg("Not enabling featureName: %s due to missing security model: %s" % (featureName,securityName) )
    def getFeatureNames(self):
        return self.features.keys()
    def getSecurityMap(self):
        return dict([(k,v[1]) for k,v in self.features.iteritems()])
    def getFunctions(self,featureName,methodname):
        featureModule,securityName,securityModule = self.features.get(featureName,None)
        securityFnc = getattr(securityModule, 'process',None)
        featureFnc = getattr(featureModule, methodname,None)
        if securityModule and not securityFnc:
            log.msg("Security Module %s not working for feature %s" % (securityName, featureName))
            return (None,None)
        return (securityFnc,featureFnc)