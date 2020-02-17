# Exercise one (filter, map, zip - functions)

'''

from sys import argv

vals = [i for i in range(1, 11)]
# Filter out items that are not equally divisibe by two
vals = list(filter(lambda x: x % 2 == 0, vals))
print(vals)

# Filter out everything else, that is not an integer
# Convert items into integers and add them to a list (vals)
vals = list(map(lambda x: int(x) , filter(lambda x: x.isdecimal(), argv[1:])))
print(vals)

vals1 = [3*i for i in range(10)]
vals2 = [7*i for i in range(10)]
# Creates a tuple of the items at the same index from two (or more) lists
print(list(zip(vals1, vals2)))
print()
print(list(zip(vals1, vals2, vals1, vals2)))

'''

# Exercise two (use vaaliliitot.csv as a first parameter)

from sys import argv

def filterCond(line):
	parts = line.split(";")
	return len(parts) == 2 and parts[1].isdecimal()

with open(argv[1], encoding="latin") as infile:
	lines = infile.readlines()

data = map(lambda x: x.rstrip("\n"), lines)
data = filter(filterCond, data)	
data = map(lambda x: x.split(';'), data)
data = map(lambda x: (x[0].strip('""'), x[1]), data)
data = filter(lambda x: len(x[0].split("/")) == 2, data)
data = map(lambda x: (x[0].split("/"), int(x[1])), data)
data = map(lambda x: (x[0][0].strip(), x[0][1].strip(), x[1]), data)
# print(list(data))

counts = {}
for party, district, votes in data:
	counts[party] = votes if party not in counts else counts[party] + votes
	
for party, votes in sorted(counts.items(), key=lambda x: x[1], reverse=True):
	print(f"Puolue: {party}, äänet: {votes}")







