def multiplicationTable(a, b, c, d):
	
	reset = a
	width = len(str(d))
	
	print ("{:>{}}".format("", width), end="")
	for i in range(a, b+1):
		width = len(str(i*d))
		print(" {:>{}}".format(i, width), end="")
	print()
	for c in range(c, d+1):
		width = len(str(d))
		print("{:>{}}".format(c, width), end="")
		while a <= b:
			width = len(str(a*d))
			print(" {:>{}}".format(a * c, width), end="")
			a+=1
		print()
		a = reset

print()
print("---- Kertolaskutaulun luonti ----")
print()
x1 = int(input("Anna X-akselin ensimmäinen arvo: "))
x2 = int(input("Anna X-akselin toinen arvo: "))
y1 = int(input("Anna Y-akselin ensimmäinen arvo: "))
y2 = int(input("Anna Y-akselin toinen arvo: "))
print()
print(f"X-akselin arvot väliltä: {x1}-{x2}")
print(f"Y-akselin arvot väliltä: {y1}-{y2}")
print()

multiplicationTable(x1, x2, y1, y2)
print()

'''

def multiplicationTable(a, b, c, d):
	
	pisin = str(b * d)
	width = len(pisin) + 1
	
	reset = a
	
	print ('{:>{}}'.format(" ", width), end = "")
	for i in range(a, b+1):
		print("{:>{}}".format(i, width), end="")
	print()
	for c in range(c, d+1):
		print("{:>{}}".format(c, width), end="")
		while a <= b:
			print("{:>{}}".format(a * c, width), end="")
			a+=1
		print()
		a = reset

multiplicationTable(1, 10, 11, 20)

'''

'''

X = 1
Y = 1
print ('{:>4}'.format(' '), end = "")
for X in range(1, 11):
	print('{:>4}'.format(X), end="")
print()
for X in range(1,11):
	print('{:>4}'.format(X), end="")
	while Y <= 10:
		print('{:>4}'.format(X * Y), end="")
		Y+=1
	print()
	Y=1

'''
