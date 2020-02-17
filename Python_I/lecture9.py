# Exercise one (classes)

'''

class Person:
	def __init__(self, name, height, weight):
		self.name = name.title()
		self.height = int(height)
		self.weight = int(weight)
		
	def __str__(self):
		return f"Name: {self.name}\nHeight: {self.height}\nWeight: {self.weight}\n"

tc = Person(name="Tom Cruise", height=175, weight=75)
print(tc)

tc.name = "tom cruise"
print(tc)

'''

# Exercise two

'''

class Person:
	def __init__(self, name, height, weight):
		self.__name = name.title() # Sanojen ekat kirjaimet isolla
		self.__height = int(height)
		self.__weight = int(weight)
		
	def __str__(self):
		return f"Name: {self.__name}\nHeight: {self.__height}\nWeight: {self.__weight}\n"
		
	def getName(self):
		return self.__name
		
	def setName(self, name):
		self.__name = name.title()

tc = Person(name="Tom Cruise", height=175, weight=75)
print(tc)

# tc.name = "tom cruise"
tc.setName("tom cruise")
print(tc)

tc.__name = "tom cruise"
print(tc)

tc._Person__name = "tom cruise"
print(tc)

'''

# Exercise three (__slots__)

'''

class Person:
	__slots__ = ("__name", "__height", "__weight")
	
	def __init__(self, name, height, weight):
		self.__name = name.title() # Sanojen ekat kirjaimet isolla
		self.__height = int(height)
		self.__weight = int(weight)
		
	def __str__(self):
		return f"Name: {self.__name}\nHeight: {self.__height}\nWeight: {self.__weight}\n"
		
	def getName(self):
		return self.__name
		
	def setName(self, name):
		self.__name = name.title()

tc = Person(name="Tom Cruise", height=175, weight=75)
print(tc)

tc.setName("tom cruise")
print(tc)

# tc.__name = "tom cruise"
# print(tc)

tc._Person__name = "tom cruise"
print(tc)

'''

# Exercise four (property in class)

'''

class Person:
	__slots__ = ("__name", "__height", "__weight")
	
	def __init__(self, name, height, weight):
		self.__name = name.title() # Sanojen ekat kirjaimet isolla
		self.__height = int(height)
		self.__weight = int(weight)
		
	def __str__(self):
		return f"Name: {self.__name}\nHeight: {self.__height}\nWeight: {self.__weight}\n"
		
	def getName(self):
		print("Getting name")
		return self.__name
		
	def setName(self, name):
		print("Setting name")
		self.__name = name.title()
	
	name = property(getName, setName)

tc = Person(name="Tom Cruise", height=175, weight=75)
print(tc)

tc.setName("tom cruise")
print(tc)

tc.name = "cruise, tom"
print(tc, tc.name)

'''

# Exercise five (decorator - @ ja luokkien vertailua)

class Person:
	__slots__ = ("__name", "__height", "__weight")
	
	def __init__(self, name, height, weight):
		self.__name = name.title() # Sanojen ekat kirjaimet isolla
		self.__height = int(height)
		self.__weight = int(weight)
		
	def __str__(self):
		return f"Name: {self.__name}\nHeight: {self.__height}\nWeight: {self.__weight}\n"
		
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

tc = Person(name="Tom Cruise", height=175, weight=75)
print(tc)

tc.name = "cruise, tom"
print(tc, tc.name)

tc.weight = "100"
tc.height = 177
print(tc)

jb = Person(name="James Bond", height=180, weight=80)

if jb < tc: # jb.__lt__(tc) or tc.__gt__(jb)
	print(f"{jb.name} is smaller than {tc.name}")
else:
	print(f"{jb.name} is not smaller than {tc.name}")
	
if jb > tc: # jb.__gt__(tc) or tc.__lt__(jb)
	print(f"{jb.name} is larger than {tc.name}")
else:
	print(f"{jb.name} is not larger than {tc.name}")
