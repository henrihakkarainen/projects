# Exercise one

'''

vals = [("joe", 47), ("mary", 23), ("ann", 18), ("joe", 25),
        ("annabelle", 50)]
print(sorted(vals))

def comp(v): # returns a representation of v for comparison
  return v[1]

print(sorted(vals, key=comp))


def comp2(v):
  return (len(v[0]), v[0], v[1])

print(sorted(vals, key=comp2))


def namelen(v):
  return len(v[0])

def name(v):
  return v[0]

def age(v):
  return v[1]

print()
vals.sort(key=age)
print(vals)
vals.sort(key=name)
print(vals)
vals.sort(key=namelen)
print(vals)

'''

# Exercise two

'''

from sys import argv

infile = open(argv[1])
s = infile.read()
infile.close()
print(type(s), s)
print()
print(s.split("\n"))
print()
print(s.split())

'''

# Exercise three

'''

from sys import argv

with open(argv[1]) as infile:
  s = infile.readlines()

for line in s:
  print(line.strip())

'''

# Exercise four (important)

'''

from sys import argv

with open(argv[1]) as infile:
  for line in infile:
    print(line.rstrip("\n"))

with open(argv[1]) as infile:
  for line in infile:
    for word in line.rstrip("\n").split():
      print(word)

with open(argv[1]) as infile:
  for line in infile:
    for char in line.rstrip("\n"):
      print(char, end=" ")

'''

# Exercise five (dictionaries)

import sys

pops = {}
areas = {}
names = {}
with open(sys.argv[1]) as infile:
  for line in infile:
    name, pop, area = line.rstrip("\n").split("\t")
    namekey = name.lower()
    pop = int(pop.replace(",", ""))
    area = float(area.replace(",", ""))
    pops[namekey] = pop
    areas[namekey] = area
    names[namekey] = name

name = input("Give a country: ").lower()
if name in pops:
  print("The country", names[name], "has population", pops[name])
else:
  print("No data for", name)
