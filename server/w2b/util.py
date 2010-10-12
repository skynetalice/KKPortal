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
import sys
def prn(*argv, **kwargs):
    sep = kwargs.get("sep", " ")
    end = kwargs.get("end", "\n")
    file = kwargs.get("file", sys.stdout)
    file.write(sep.join(map(str, argv)) + end)
class test():
    def __init__(self):
        from w2b.settings import settings
        print settings