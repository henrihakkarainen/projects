from random import randint

def random_number():
	numb = randint(0,5)
	return numb

def guess_number():
	guess = int(input("Arvaa luku väliltä 1-5: "))
	return guess
	
vaara_arvaus = False

while not vaara_arvaus:
	arvattava = random_number()
	arvaus = guess_number()
	print("Arvasit luvun:", arvaus)

	if arvaus != arvattava:
		if arvaus < arvattava:
			print("Arvaus oli liian pieni, oikea vastaus olisi ollut:", arvattava)
		
		elif arvaus > arvattava:
			print("Arvaus oli liian suuri, oikea vastaus olisi ollut:", arvattava)
		vaara_arvaus = True
		
	else:
		print("Oikea vastaus:", arvattava)
		print("OIKEIN! Jatketaan arvailua..")
