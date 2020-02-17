# Ristinolla-Peli

def tictactoe():
   def print_grid(g):
      for i in range(0, 3):
         for j in range(3):
            print(" {}".format(" " if g[i][j] is None else g[i][j], end=""))
         print()
			
	def won(g):
		for i in range(0, 3):
			if g[i][0] == g[i][1] == g[i][2] and g[i][0] is not None:
				return True
		for j in range(0, 3):
			if g[0][j] == g[1][j] == g[2][j] and g[0][j] is not None:
				return True
		if g[0][0] == g[1][1] == g[2][2] and g[0][0] is not None:
			return True
		if g[0][2] == g[1][1] == g[2][0] and g[0][2] is not None:
			return True
		return False
		
	def full(g):
		for i in range(3):
			for j in range(3):
				if g[i][j] is None:
					return False
		return True
		
	grid = [[None, None, None],
			[None, None, None],
			[None, None, None]]
	player = "X"
	print_grid(grid)
	while True:
		line = input(f"Enter a move for {player} (two integers between 1 and 3): ")
		# input("Enter a move for {}".format(player)) <- would do the same
		parts = line.split()
		i, j = int(parts[0]), int(parts[1])
		if 1 <= i <= 3 and 1 <= j <= 3:
			if grid[i-1][j-1] is None:
				grid[i-1][j-1] = player
				print_grid(grid)
				if won(grid):
					print(f"Player {player} won!")
					break
				elif full(grid):
					print("A draw")
					break
				player = "X" if player != "X" else "O"
			else:
				print(f"The place {i} {j} is already taken!")
		else:
			print("Both numbers ust be within 1 and 3")
	
if __name__ == '__main__':
	tictactoe()
