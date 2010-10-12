#!/usr/bin/python
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
from __future__ import print_function
import sys
import os
import re

def checkfile(patterns,file):
	for pattern in patterns:
		line = file.readline()
		if not pattern.match(line):
			print("line",patterns.index(pattern)+1,"does not match:",repr(line))
			return False
	return True

templatePath = os.path.join(os.path.dirname(__file__),'copyrightTemplates')

print("Template Path:",templatePath) 

templates = {}

for root,dirs,files in os.walk(templatePath):
	for file in files:
		filename,extension = os.path.splitext(file)
		if extension[1:] == "tpl":
			h = open(os.path.join(root,file))
			templates[filename] = [re.compile(line) for line in h.readlines()]
			h.close()

print("File types checked:",",".join(templates.keys()))

searchPaths  = [os.path.join(os.path.dirname(__file__),'..','src')]
searchPaths += [os.path.join(os.path.dirname(__file__),'..','server')]
searchPaths = map(os.path.realpath,searchPaths)
print("Searching paths:",",".join(searchPaths))

for searchPath in searchPaths:
	for root,dirs,files in os.walk(searchPath):
		for file in files:
			filename,extension = os.path.splitext(file)
			if extension[1:] in templates:
				fullfilename = os.path.join(root,file)
				h = open(fullfilename)
				if not checkfile(templates[extension[1:]], h):
					print("Checking:",fullfilename,"[FAIL]")
				h.close()