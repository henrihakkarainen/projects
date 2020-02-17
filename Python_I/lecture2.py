# First exercise (Lists)

'''

def read_value(msg = "Give a number: "):
  try:
    line1 = input(msg)
    res = float(line1)
  except ValueError:
    print("You gave an illegal number " \
    "using value 1 instead")
    res = 1
  return res

numbers = [1, 2, 3, 4]
print(numbers)

months = ["January", "February", "March", "April",
		   "May", "June", "July", "August", "September",
		   "October", "November", "December"]
  
month = int(read_value("Enter a month number 1..12: "))
i = month

if 1 <= i <= 12:
	print(months[(i-1)])
	
else:
	print("An illegal number")

'''

# Second exercise (Loops)

'''

def read_value(a, b, msg = "Give a number: "):
	number_read = False
	while not number_read:
		try:
			line1 = input(msg)
			i = int(line1)
			if a <= i <= b:
				number_read = True
				
		except ValueError:
			print("You gave an illegal number!",
			"It must be within", a, "..", b)
	return i
	  
  

numbers = [1, 2, 3, 4]

months = ["January", "February", "March", "April",
		   "May", "June", "July", "August", "September",
		   "October", "November", "December"]
  
month = int(read_value(1, 12, "Enter a month number 1..12: "))
i = month

if 1 <= i <= 12:
	print(months[(i-1)])
	
else:
	print("An illegal number")

'''

# Third exercise (Simple while-loop and for-loop)

'''

months = ["January", "February", "March", "April",
		   "May", "June", "July", "August", "September",
		   "October", "November", "December"]

print("")
print("With while-loop")

i = 0
while i < len(months):
	print(months[i])
	i += 1
	
print("")
print("With for-loop")
	
for i in months:
	print(i)
	
print("")
	
# for(int i = 0; i < 12; i++)

print("With for-loop within range() - every other month")
for i in range(0,12, 2):
	print(months[i])
	
print("")

'''

# Fourth exercise (Tuples)

'''

tuple_months = {"January", "February", "March", "April",
		   "May", "June", "July", "August", "September",
		   "October", "November", "December"}
		   
# tuple_months[0] = "january" <--- wouldn't work!

'''

# Fifth exercise

'''

def most_common(vals):
	common = None
	common_count = None
	for val in vals:
		count = 0
		for val2 in vals:
			if val == val2:
				count += 1
		if common_count is None or common_count < count:
			common_count = count
			common = val
	return [common, common_count]
		
		
print(most_common([2, 5, 3, 8, 3, 7, 6]))

'''

# Sixth exercise



s = "python programming"

'''

for c in s:
	print(c)
	
# s[0] = "P" <--- wouldn't work
s = "P" + s[1:]
print(s)

s3 = s.upper()
print(s3)

'''

s2 = list(s)
print(s2, type(s2))

s2[0] = "p"
print(s2)
print(" ".join(s2))
print("".join(s2))

s4 = "".join(s2)
print(s4, type(s4))



# Seventh exercise (Some string formatting)

s = f"python {5-2} programming"
print(s)

pi = 3.1415332343894384
print(f"pi is {pi:.4f}")
print(f"pi is {pi:10.4f}")

