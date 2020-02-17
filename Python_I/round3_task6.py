def checkSudoku(filename):
	grid = []
	with open(filename) as infile:
		for line in infile:
			parts = line.split()
			if len(parts) == 19:
				row = [int(parts[i]) for i in range(1, len(parts), 2)]
				grid.append(row)
	badrows = []
	for row in range(9):
		if len(set(grid[row])) != 9:
			badrows.append(row + 1)
	badcols = []
	for col in range(9):
		if len({grid[row][col] for row in range(9)}) != 9:
			badrows.append(col + 1)
	badgrids = []
	for gr in range(3):
		for gc in range(3):
			valset = {grid[row][col] for row in range(3*gr, 3*(gr+1))
										for col in range(3*gc, 3*(gc+1))}
			if len(valset) != 9:
				badgrids.append([gr+1, gc+1])
	
	if badrows or badcols or badgrids:
		print("Illegal rows:", " ".join(map(str, badrows)))
		print("Illegal columns:", " ".join(map(str, badcols)))
		print("Illegal subgrids:", " ".join(map(str, badgrids)))

	else:
		print("The sudoku solution is legal")
