rates = {}
line = input("Give a command: ").lower()
while line != "quit":
	parts = line.split()
	if len(parts) == 4 and len(parts[1]) == len(parts[3]) == 3:
		a = parts[1]
		b = parts[3]	
		x = float(parts[0])
		y = float(parts[2])
		rates[(a, b)] = (x, y)
		
	elif len(parts) == 2:
		if parts[0] == "read":
			with open(parts[1]) as infile:
				for line in infile:
					parts = line.split("\t")
					a = parts[1]
					b = parts[3]	
					x = float(parts[0])
					y = float(parts[2])
					rates[(a, b)] = (x, y)
					
		elif parts[0] == "write":
			with open(parts[1], "w") as outfile:
				for codes in sorted(rates):
					x, y = rates[codes]
					print(f"{x}\t{codes[0]}\t{y}\t{codes[1]}", file=outfile)
		else:
			print("Illegal command!")
					
	elif line.strip() == "rates":
		if (not None in rates):
			print("No rates defined yet!")
		else:
			for codes in sorted(rates):
					x, y = rates[codes]
					print(f"{x}\t{codes[0]}\t{y}\t{codes[1]}")
	
	elif len(parts) == 3 and len(parts[1]) == len(parts[2]) == 3:
		x = float(parts[0])
		a = parts[1]
		b = parts[2]
		if (a, b) in rates:
			rate = rates[(a, b)]
			y = x * rate[1] / rate[0]
		elif (a, "eur") in rates and ("eur", b) in rates:
			rate1 = rates[(a, "eur")]
			rate2 = rates[("eur", b)]
			y = x * rate1[1] / rate1[0]
			y = y * rate2[1] / rate2[0]
			
	else:
		print("Illegal command!")

	line = input("Give a command: ").lower()

