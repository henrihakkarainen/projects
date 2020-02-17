from sys import argv

'''

c_list = argv
vika = 0

for i in range(0, len(c_list[1:])):
	vika += 1

vika = str(vika)
width = len(vika)

for n, i in enumerate(c_list[1:], 1):
	
	print(f"{n:>{width}}: {i} (count: {c_list.count(i)})")

'''

'''

c_list = argv
vika = 0

for n, i in enumerate(c_list[1:], 1):
	if i not in c_list[1:n]:
		vika = n
		
vika = str(vika)
width = len(vika)

for n, i in enumerate(c_list[1:], 1):
	if i not in c_list[1:n]:
		print(f"{n:>{width}}: {i} (count: {c_list.count(i)})")
		
'''

c_list = argv
vika = 0

for n, i in enumerate(c_list[1:], 1):
	if i not in c_list[1:n]:
		vika = n
		
vika = str(vika)
width = len(vika)
new_list = []

for n, i in enumerate(c_list[1:], 1):
	if i not in c_list[1:n]:
		new_list.append([n, i, c_list.count(i)])

new_list = sorted(new_list, key=lambda x: x[1])

for i in new_list:
	print(f"{i[0]:>{width}}: {i[1]} (count: {i[2]})")
