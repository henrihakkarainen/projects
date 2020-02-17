usd_rate = None
eur_rate = None
line = input("Give a command: ")
if line.upper() == "QUIT":
	line = "quit"
while line != "quit":
	cmd_ok = False
	parts = line.upper().split()
	if len(parts) == 3:
		try:
			x = float(parts[1])
			if parts[0] == "USD" and parts[2] == "EUR":
				usd_rate = x
				cmd_ok = True
			elif parts[0] == "EUR" and parts[2] == "USD":
				eur_rate = x
				cmd_ok = True
		except:
			pass
			
	elif len(parts) == 2:
		try:
			x = float(parts[0])
			if parts[1] == "USD":
				cmd_ok = True
				if usd_rate is not None:
					print(f"{x:.6f} USD = {x * usd_rate:.6f} EUR")
				else:
					print("No USD-EUR rate defined yet!")
			elif parts[1] == "EUR":
				cmd_ok = True
				if eur_rate is not None:
					print(f"{x:.6f} EUR = {x * eur_rate:.6f} USD")
				else:
					print("No EUR-USD rate defined yet!")
		except:
			pass
			
	if cmd_ok == False:
		print("Illegal command!")
				
	line = input("Give a command: ")
	if line.upper() == "QUIT":
		line = "quit"
