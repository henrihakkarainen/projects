# Exercise one (JSON)

'''

import json
from sys import argv
	
with open(argv[1]) as infile: # cmd: python3 lecture11.py persons.json
	data = json.load(infile)

print(data)
print(type(data))

for i in data:
	print(i)
	print(type(i))

'''

# Exercise two

'''

import json
from sys import argv
from random import randint

names = ["Oliver", "Jake", "Noah", "James"]
data = []
for n in names:
	person = {}
	person["name"] = n
	person["weight"] = randint(60, 80)
	person["height"] = randint(160, 190)
	data.append(person)
	
with open(argv[1], "w") as outfile: # cmd: python3 lecture11.py persons2.json
	data = json.dump(data, outfile)

'''

# Exercise three

import json
from sys import argv
from random import randint

names = ["Oliver", "Jake", "Noah", "James"]
data = []
for n in names:
	person = {}
	person["name"] = n
	person["weight"] = randint(60, 80)
	person["height"] = randint(160, 190)
	data.append(person)
	
s = json.dumps(data)
print(s, type(s))

data2 = json.loads(s)
print(data2, type(data2))
