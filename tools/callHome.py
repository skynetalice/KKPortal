#!/usr/bin/python
from os import path

import urllib2

def userWillPaticipate():
	print("""Usage Statistics Program

Since we would like to know how many people actually use our source code we
ask you to participate in our usage statictics.

What is sent:
If you choose to paticipate a random number is generated and stored in the
./tools/statid file. the only information sent is this random number.

When is it sent:
Every time you start the kkportalserver in debug mode.

Can I change my decision later:
Anytime just delete the ./tools/statid file and run kkportalserver and you 
will be asked again.
""")
	tries = 5
	while tries > 0:
		answer = raw_input("Will you help? [Y/n] ")
		if answer[:1] == 'y' or answer == '':
			return True
		if answer[:1] == 'n':
			return False
		print("Sorry I did not understand your answer please try again")
		tries -= 1
def sendIdToServer(id):
	import urllib2
	print("""Calling home with no private information
delete the ./tools/statid file if you do not want to participate""")
	try:
		urllib2.urlopen("http://stats.windpowerhub.com/ping/" + str(id))
	except:
		pass

def createNewId(filepath):
	from random import randint
	id = randint(0,2**31)
	file = open(filepath,'w')
	file.write(str(id))
	file.close()
	return id

def createEmptyId(filepath):
	file = open(filepath,'w')
	file.write('')
	file.close()

filepath = path.join(path.dirname(__file__),'statid')

id = None
if path.exists(filepath):
	file = open(filepath)
	id = file.read()
	file.close()

if id == None:
	if userWillPaticipate():
		id = createNewId(filepath)
	else:
		createEmptyId(filepath)

if id:
	sendIdToServer(id)
