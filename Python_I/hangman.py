'''
Hangman Game
Lesson 2
'''
from random import randint

words = ["hangman", "chairs", "backpack", "bodywash", "clothing",
         "computer", "python", "program", "glasses", "sweatshirt",
         "sweatpants", "mattress", "friends", "clocks", "biology",
         "algebra", "suitcase", "knives", "ninjas", "shampoo"]
         
k = randint(0,len(words))
tries = int(input("Give a number of tries: "))
word = words[k % len(words)]
guessed = list("." * len(word))
print(guessed)

while True:
	print("Current word: {}".format("".join(guessed)))
	c = input("Guess a character: ")
	tries -= 1
	if c in word:
		pos = word.find(c)
		while pos != -1:
			if guessed[pos] == ".":
				guessed[pos] = c
			pos = word.find(c, pos+1)
	if "." not in guessed or tries < 1:
		break
if "." not in guessed:
	print(f"Ok, you won: {word}")

else:
	print(f"You lost! The word was {word}")
		
