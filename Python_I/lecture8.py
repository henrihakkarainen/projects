# Exercise one (classes)

'''

from sys import argv

class Town:
	pass
	
# Use file population.csv as first parameter
with open(argv[1], encoding="latin") as infile:
	towns = []
	for line in infile:
		parts = line.split(";")
		c = Town()
		c.name = parts[0].strip('"')
		c.pop = int(parts[2])
		c.men = int(parts[3])
		c.women = int(parts[4])
		towns.append(c)

data = filter(lambda x: sum((x.pop, x.men, x.women)),towns)
for town in sorted(data, key=lambda x: x.men/x.women):
	print(town.name, town.men, town.women)

'''

# Exercise two (classes)

'''

from sys import argv

class Town:
	def sexProportion(self):
		return self.men / self.women
	
# Use file population.csv as first parameter
with open(argv[1], encoding="latin") as infile:
	towns = []
	for line in infile:
		parts = line.split(";")
		c = Town()
		c.name = parts[0].strip('"')
		c.pop = int(parts[2])
		c.men = int(parts[3])
		c.women = int(parts[4])
		towns.append(c)

data = filter(lambda x: sum((x.pop, x.men, x.women)),towns)
for town in sorted(data, key=lambda x: x.sexProportion()):
	print(town.name, town.men, town.women)

'''

# Exercise three (classes)

'''

from sys import argv

class Town:
	def __init__(self, name="", pop=0, men=0, women=0):
		self.name = name
		self.pop = pop
		self.men = men
		self.women = women
	
	def sexProportion(self):
		return self.men / self.women
	
# Use file population.csv as first parameter
with open(argv[1], encoding="latin") as infile:
	towns = []
	for line in infile:
		parts = line.split(";")
		c = Town(name = parts[0].strip('"'),
				pop = int(parts[2]),
				men = int(parts[3]),
				women = int(parts[4]))
		towns.append(c)

data = filter(lambda x: sum((x.pop, x.men, x.women)),towns)
for town in sorted(data, key=lambda x: x.sexProportion()):
	print(town.name, town.men, town.women)

'''

# Exercise four (classes)

from sys import argv

class Town:
	def __init__(self, name="", pop=0, men=0, women=0):
		self.name = name
		self.pop = pop
		self.men = men
		self.women = women
		
	def __str__(self):
		return  " ".join(map(str, (self.name, self.pop,
									self.men, self.women)))
	
	def sexProportion(self):
		return self.men / self.women
	
# Use file population.csv as first parameter
with open(argv[1], encoding="latin") as infile:
	towns = []
	for line in infile:
		parts = line.split(";")
		c = Town(name = parts[0].strip('"'),
				pop = int(parts[2]),
				men = int(parts[3]),
				women = int(parts[4]))
		towns.append(c)

data = filter(lambda x: sum((x.pop, x.men, x.women)),towns)
for town in sorted(data, key=lambda x: x.sexProportion()):
	print(town)








