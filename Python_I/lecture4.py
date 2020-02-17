# Exercise one

'''

i = 0

def do_something():
	global i
	i = 99
	print("do_something", i)
	
def do_something2():
	i = 100
	
	def inner():
		nonlocal i
		i = i + 15
		print("inner", i)
		
	inner()
	print("do_something2", i)
	
do_something()
do_something2()

print("gloal", i)

'''

# Exercise two (using function as a parameter)

'''

def find_smallest(vals):
	
	res = None
	for v in vals:
		if res is None or res > v:
			res = v
	return res
		
print(find_smallest((9, 3, 4, -2, 55, -8, 7)))

def find_best(vals, comp):
	
	best = None
	for v in vals:
		if best is None or comp(v, best):
			best = v
	return best
	
def larger(a, b):
	return a > b
	
def smaller(a, b):
	return a < b
	
def magnitude(a, b):
	return abs(a) > abs(b)
		
print(find_best((9, 3, 4, -2, 55, -8, 7), larger))

'''

# Exercise three

'''

t = (1, 2, 3, 4)

vals = [1, 2, 3, 4, 5, 6]
value = "x"
# Muutetaan lista (vals) tupleksi
t2 = tuple(vals)
t3 = tuple((vals, value))

print(t)
print(t2)
print(t3)
print()

# Luodaan lista "kopioimalla" sama arvo moneen indeksiin näin
vals = []
for i in range(10):
	vals.append([0])

print(vals)
vals[0].append(5)
print(vals)

# Ei näin (lopputulos näyttää samalta, mutta ongelmia tulee
# kun listaan aletaan lisäämään lukuja
vals2 = [[0]] * 10
print(vals2)
vals2[0].append(5)
print(vals2)

'''

# Exercise four (for round 2 programs)

'''

import sys

for p in sorted(sys.argv):
	print("", p, end="")
print()

pars = sys.argv[1:]

for p in sorted(pars):
	print("", p, end="")
print()

for p in reversed(sorted(sys.argv)):
	print("", p, end="")
print()

for p in reversed(sorted(pars)):
	print("", p, end="")
print()

'''

# Exercise five

vals = []
prec = 6
cmd = input("Enter a command: ")
while cmd != "quit":
	# "add 3.14"
	parts = cmd.split()
	if parts[0] == "add":
		val = float(parts[1])
		vals.append(val)
	elif cmd == "print":
		for v in vals:
			 #Many styles of String-formatting here
			
			# print((" {:." + str(prec) + "f}").format(v), end="")
			# print((" {:.{}f}").format(v, prec), end="")
			print(f" {v:.{prec}f}", end="")
		print()
	elif parts[0] == "precision":
		# precision int
		prec = int(parts[1])
	
	cmd = input("Enter a command: ")





