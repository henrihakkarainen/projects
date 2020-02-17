a = int(input())
b = int(input())
k = int(input())
				
def is_prime(y):
	x = True
	if y < 2:
		x = False
	elif y == 2:
		x = True
	else:
		for i in range(2, y):
			if y%i == 0:
				x = False
				break
	if x:
		return True
	else:
		return False
		
prime_list = []
        
for i in range(a, b+1):
	if is_prime(i) == True:
		prime_list.append(i)
		
prime_list_mod = []
prime = None

for i in range(0, len(prime_list), k):
	prime = prime_list[i]
	prime_list_mod.append(prime)
		
print(*prime_list_mod, sep = " ")
