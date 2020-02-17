# Exercise one

'''

import sys

counts = {}
with open(sys.argv[1]) as infile:
	for word in infile.read().split():
		if word not in counts:
			counts[word] = 1
		else:
			counts[word] += 1

for word in sorted(counts):
	print(word, counts[word])

'''

# Exercise two (lambda)

'''

def find_best(vals, comp):
	
	best = None
	for v in vals:
		if best is None or comp(v, best):
			best = v
	return best
	
def larger(a, b):
	return a > b
		
print(find_best((9, 3, 4, -2, 55, -8, 7), larger)) # Tekee saman asian kuin
print(find_best((9, 3, 4, -2, 55, -8, 7), lambda a, b: a > b)) # tämä
print(find_best((0, 2, -15, 1, -6, 3, 1),
				lambda a, b: abs(a) > abs (b)))

f = lambda a, b, c: a*b*c
print(f(1, 2, 3))


vals = [("joe", 47), ("mary", 23), ("ann", 18), ("joe", 25),
        ("annabelle", 50)]
print(sorted(vals))

print(sorted(vals, key=lambda v: v[1]))

print(sorted(vals, key=lambda v: (len(v[0]), v[0], v[1])))

print()
vals.sort(key=lambda v: v[1])
print(vals)
vals.sort(key=lambda v: v[0])
print(vals)
vals.sort(key=lambda v: len(v[0]))
print(vals)

'''

# Exercise three (write to a file)

'''

import sys

counts = {}
with open(sys.argv[1]) as infile:
	for word in infile.read().split():
		if word not in counts:
			counts[word] = 1
		else:
			counts[word] += 1

with open(sys.argv[2], "w") as outfile: # Overwrite with "w"
	for word in sorted(counts):
		print(word, counts[word], file=outfile)

with open(sys.argv[2], "a") as outfile: # Append with "a"
	for word in sorted(counts):
		print(word, counts[word], file=outfile)
		
'''

# Exercise four (problem reading a file because of encoding error)

'''

import sys

counts = {}
with open(sys.argv[1], encoding="iso-8859-1") as infile:
	for word in infile.read().split():
		if word not in counts:
			counts[word] = 1
		else:
			counts[word] += 1

	print(counts)

'''

# Exercise five

'''

vals1 = [i*5 for i in range(10)]

#for i in range(10):
#	vals.append(i*5)

vals2 = [(i, j) for i in range(5) for j in range(5)]

#for i in range(10):
#	for j in range(10):
#		vals.append((i, j))
		
vals3 = [(i, j) for i in range(10)
				if i != 7
				for j in range(10)
				if i != 6 and j != 6]
		
#for i in range(10):
#	if i != 7:
#		for j in range(10):
#			if i != 6 and j!= 6:
#				vals.append((i, j))

print(vals1)
print()
print(vals2)
print()
print(vals3)

'''

# Exercise six

import sys

vals = [i for i in range(int(sys.argv[1]))]

valdict = {i : True for i in vals}

valset = set(vals)
count = 0
count1 = 0

for j in range(int(sys.argv[1])//2, int(sys.argv[1])):
	count += j in valset # counts much faster than (count += j in vals)

print(count)
	
for j in range(int(sys.argv[1])//2, int(sys.argv[1])):
	count1 += j in valdict

print(count1)






