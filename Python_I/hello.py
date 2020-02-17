# FIRST LESSON PRACTICING

# line = input()
# print(line)

'''
Multi-line comment

# <- Single line comment

Still commented
'''
print("foo " \
"bar")
  
def read_value(msg = "give a number: "):
  try:
    line1 = input(msg)
    res = float(line1)
  except ValueError:
    print("You gave an illegal number " \
    "using value 1 instead")
    res = 1
  return res
  
val1 = read_value()
val2 = read_value("Enter another number: ")
print(val1, ",", val2)
print(str(val1) + ' * ' + str(val2) + ' = ' + str(int(val1*val2)))
