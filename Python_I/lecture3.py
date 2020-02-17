# Exercise one

'''

def printDecision(person):
	print(f"You are a {person}")
	
age = int(input("Enter a age: "))
printDecision("Adult" if age >= 18 else ("Minor" if age >= 12 else "Child"))

# if age >= 18:
#	person = "Adult"
# else:
#	person = "Minor"

'''

# Exercise two

'''

p1 = (-1.5, 3)

x, y = p1

print(x, y)

x, y = y, x

print(x, y)

'''

# Exercise three (iterating through lists)

'''

months = ["January", "February", "March", "April",
		   "May", "June", "July", "August", "September",
		   "October", "November", "December"]
		   
month = input("Enter month name: ")

i = 0
while i < len(months):
	if month == months[i]:
		break
	i += 1
else:
	print("In the else clause")
	
if i < len(months):
	print(f"The month {month} was found in index {i}")
else:
	print(f"The month {month} was not found at all")
	

months2 = ["January", "February", "March", "April",
		   "May", "June", "July", "August", "September",
		   "October", "November", "December"]
		   
month = input("Enter month name: ")

# Enumerate returns (index, value)
for i, m in enumerate(months2):
	if month == m:
		print(f"The month {month} was found at index {i}")
		break
else:
	print(f"The month {month} was not found at all")
	
'''

# Exercise four (import modules)

'''

# import sys (import all functions from a module)
from sys import argv # (import specific functions from a module)
from common import most_common # (importing function most_common from our own module common.py)

print(argv)
print(most_common(argv))

'''

# Exercise five

from sys import argv
import common

print(__name__)
print(common.most_common(argv))

print(argv)

