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

import sys
import os
import re

if len(sys.argv) < 2:
	print(' '.join(("usage:",sys.argv[0],"pattern")))
	sys.exit(2)

e = sys.argv[1].split('/')

e = [re.escape(x).replace('\\*\\*','.*').replace('\\*','[^/]*').replace('\\?','.') for x in e]

dirpattern = '^./'+e[0]+''.join(['(' + os.sep + x + '|$)' for x in e[1:-1]])
filepattern = '^./'+(os.sep + '?').join(e) + '$'

#print(dirpattern)
#print(filepattern)

regex = re.compile(dirpattern)
regex2 = re.compile(filepattern)

result = []

for root,dirs,files in os.walk('.'):
	#note the [:] is for changing the reference instead of creating a new list
	dirs[:] = [dir for dir in dirs if regex.match(root+os.sep+dir)]
	result += [root + os.sep + file for file in files if regex2.match(root+os.sep+file)]

print(':'.join(result))

#for l in result:
#	print l
