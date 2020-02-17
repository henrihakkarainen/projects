# First subtask

'''

line = input("Enter the number of values: ")
n = int(line)
if n <= 0:
  print()
  print("You gave zero numbers.")
else:
  list_of_numbers = []
  for i in range(0, n):
    line2 = float(input("Enter a value: "))
    list_of_numbers.append(line2)
  print()
  read_min = min(list_of_numbers)
  read_max = max(list_of_numbers)
  read_sum = sum(list_of_numbers)
  read_mean = read_sum / n
  print("Minimum " + str(read_min) + ", maximum " + str(read_max) +
    ", sum " + str(read_sum) + " and mean " + str(read_mean))
    
'''

#Second subtask

'''

def get_ordinal(number):
    if 4 <= number <= 20:
      suffix = 'th'
    elif number == 1 or (number % 10) == 1:
      suffix = 'st'
    elif number == 2 or (number % 10) == 2:
      suffix = 'nd'
    elif number == 3 or (number % 10) == 3:
      suffix = 'rd'
    elif number < 100:
      suffix = 'th'
    num_ord = str(number) + suffix
    return num_ord

line = input("Enter the number of values: ")
n = int(line)
if n <= 0:
  print()
  print("You gave zero numbers.")
else:
  list_of_numbers = []
  for i in range(0, n):
    line2 = float(input("Enter the " + get_ordinal(i+1) + " value: "))
    list_of_numbers.append(line2)
  print()
  read_min = min(list_of_numbers)
  read_max = max(list_of_numbers)
  read_sum = sum(list_of_numbers)
  read_mean = read_sum / n
  print("Minimum " + str(read_min) + ", maximum " + str(read_max) +
    ", sum " + str(read_sum) + " and mean " + str(read_mean))

'''

# Third subtask

def get_ordinal(number):
    if 4 <= number <= 20:
      suffix = 'th'
    elif number == 1 or (number % 10) == 1:
      suffix = 'st'
    elif number == 2 or (number % 10) == 2:
      suffix = 'nd'
    elif number == 3 or (number % 10) == 3:
      suffix = 'rd'
    elif number < 100:
      suffix = 'th'
    num_ord = str(number) + suffix
    return num_ord

n = 0
list_of_numbers = []
i = 1

while True:
	line = input('Enter the ' + get_ordinal(i) + ' value (or give "end" to stop): ')
	if line == "end":
		if n <= 0:
			print()
			print("You gave zero numbers.")
		else:
			print()
			read_min = min(list_of_numbers)
			read_max = max(list_of_numbers)
			read_sum = sum(list_of_numbers)
			read_mean = read_sum / n
			print("Total amount of numbers: " + str(n) + ", minimum: " + str(read_min) + ", maximum: " + str(read_max) +
			", sum: " + str(read_sum) + " and mean: " + str(read_mean))
		break
	else:
		try:
			value = float(line)
			list_of_numbers.append(value)
			n += 1
			i += 1
		except ValueError:
			print('Enter a float or "end"!')
