from sys import argv

'''

# Osa yksi
for i in range(len(argv)-1):
	
	print(str(argv.index(argv[i+1])) + ": " + argv[i+1] + " (length: " + str(len(argv[i+1])) + ")")


# Osa kaksi
arg_list = argv
argv.sort()

for i in range(len(argv)-1):
	
	print(str(argv[i+1]))

print()

argv.reverse()

for i in range(len(argv)-1):
	
	print(str(argv[i]))

'''

arg_list = argv
del arg_list[0]

for i in sorted(arg_list):
	print(f"{i} (index: {arg_list.index(i)+1})")
