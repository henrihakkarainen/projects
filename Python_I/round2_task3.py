from sys import argv

def s_row(index):
	s_row = ["#", "", "|", "" , "|", "" , "#" , "" , "|" , "" 
			, "|", "" , "#" , "" , "|" , "" , "|" , "" , "#"]
	
	for i in range(1, len(s_row), 2):
		s_row[i] = sudoku_list[(index)]
		index += 1
	
	print(" ".join(s_row))
	return index
	
s = "".join(argv[1:])
sudoku_list = []
index = 0

for i in range(0, len(s)):
	sudoku_list.append(s[i])

print("#####################################")
index = s_row(index)
print("#---+---+---#---+---+---#---+---+---#")
index = s_row(index)
print("#---+---+---#---+---+---#---+---+---#")
index = s_row(index)
print("#####################################")
index = s_row(index)
print("#---+---+---#---+---+---#---+---+---#")
index = s_row(index)
print("#---+---+---#---+---+---#---+---+---#")
index = s_row(index)
print("#####################################")
index = s_row(index)
print("#---+---+---#---+---+---#---+---+---#")
index = s_row(index)
print("#---+---+---#---+---+---#---+---+---#")
index = s_row(index)
print("#####################################")
