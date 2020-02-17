# 1

'''

from sys import argv

alphabet = "abcdefghijklmnopqrstuvwxyz"

def encrypt(text, cipher):
	res = []
	for c in text:
		pos = alphabet.find(c)
		if pos >= 0:
			res.append(cipher[pos])
		else:
			res.append(c)
	return "".join(res)
	
def decrypt(text, cipher):
	res = []
	for c in text:
		pos = cipher.find(c)
		if pos >= 0:
			res.append(alphabet[pos])
		else:
			res.append(c)
	return "".join(res)

cipher = argv[1]
line = input("Give a command: ")
while line != "quit":
	parts = line.partition(" ")
	if parts[0] == "encrypt":
		print(encrypt(parts[2], cipher))
	elif parts[0] == "decrypt":
		print(decrypt(parts[2], cipher))
	else:
		print("Illegal command!")
	
	line = input("Give a command: ")

'''

# 2

from sys import argv

alphabet = "abcdefghijklmnopqrstuvwxyz"

def encrypt(text, cipher):
	res = []
	for c in text:
		if c.islower():
			pos = alphabet.find(c)
			if pos >= 0:
				res.append(cipher[pos])
		elif c.isupper():
			pos = alphabet.upper().find(c)
			if pos >= 0:
				res.append(cipher[pos].upper())
		else:
			res.append(c)
			
	return "".join(res)
	
def decrypt(text, cipher):
	res = []
	for c in text:
		if c.islower():
			pos = cipher.find(c)
			if pos >= 0:
				res.append(alphabet[pos])
		elif c.isupper():
			pos = cipher.upper().find(c)
			if pos >= 0:
				res.append(alphabet[pos].upper())
		else:
			res.append(c)
			
	return "".join(res)

cipher = argv[1]
line = input("Give a command: ")
while line != "quit":
	parts = line.partition(" ")
	if parts[0] == "encrypt":
		print(encrypt(parts[2], cipher))
		
	elif parts[0] == "decrypt":
		print(decrypt(parts[2], cipher))
	
	else:
		print("Illegal command!")
	
	line = input("Give a command: ")
