'''
Yksinkertainen peli keskiarvon laskemiseen
'''

lkm = int(input("Anna lukujen lukumäärä: "))
summa = 0
i = 1

while i <= lkm:
   luku = int(input("Anna luku: "))
   summa += luku
   i += 1
	
keskiarvo = float(summa / lkm)

print("Lukujen keskiarvo on: " + str(keskiarvo))
