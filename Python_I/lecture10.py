# Exercise one (continue with classes)

'''

class Person:
#	__slots__ = ("__name", "__height", "__weight", "__id")
	
	__pid = 0
	
	def __init__(self, name, height, weight):
		self.__name = name.title() # Sanojen ekat kirjaimet isolla
		self.__height = int(height)
		self.__weight = int(weight)
		self.__id = Person.__pid
		Person.__pid += 1
		
	def __str__(self):
		return (f"Name: {self.__name}\nHeight: {self.__height}\nWeight: {self.__weight}\n"
				 + f"id: {self.__id}\n")
	
	@classmethod
	def id(cls):
		return cls.__pid
	
	@staticmethod
	def bmi(weight, height):
		return weight / (height ** 2)
	
	@property
	def name(self):
		print("Getting name")
		return self.__name
		
	@name.setter
	def name(self, name):
		print("Setting name")
		self.__name = name.title()
		
	@property
	def height(self):
		return self.__height
		
	@height.setter
	def height(self, height):
		self.__height = int(height)
		
	@property
	def weight(self):
		return self.__weight
		
	@weight.setter
	def weight(self, weight):
		self.__weight = int(weight)
		
	def __lt__(self, other):
		print("<")
		return self.__height < other.__height
		
	def __gt__(self, other):
		print(">")
		return self.__height > other.__height

print(Person.id())

tc = Person(name="Tom Cruise", height=175, weight=75)
print(tc, tc.id())
jb = Person(name="james bond", height=185, weight=80)
print(jb, jb.id())
print(tc, tc.id())

'''

# Exercise two (inheritance)

'''

class OwnStr(str):
	def __str__(self):
		return '"' + str.__str__(self) + '"'
		
# x.something() -->
# classOfX.something(x)

	
os = OwnStr("abcde")
print(os, type(os))
print(len(os), os*5)

'''

# Exercise three

'''

import collections

class UpperStr(collections.UserString):
	def __init__(self, s):
		super().__init__(s.upper())
		s.upper()
	
s = UpperStr("abcde")
print(s, type(s))

'''

# Exercise four (own exceptions)

from sys import argv

class InvalidRatio(Exception):
	def __init__(self, msg):
		super().__init__(msg)
	
class Town:  
	def sexRatio(self):
		if self.women <= 0:
			raise InvalidRatio(f"Illegal ratio of women: {self.women}")
		return self.men / self.women


with open(argv[1], encoding = "latin") as infile:
	towns = []
	for line in infile:
		parts = line.split(";")
		c = Town()
		c.name = parts[0].strip('"')
		c.pop = int(parts[2])
		c.men = int(parts[3])
		c.women = int(parts[4])
		towns.append(c)

def ratioKey(town):
	try:
		return town.sexRatio()
	except InvalidRatio as ir:
		print(town.name, ir)
		return 0

# data = filter(lambda x: sum((x.pop, x.men, x.women)),towns)
data = towns

for town in sorted(data, key=ratioKey):
	print(town.name, town.men, town.women)








