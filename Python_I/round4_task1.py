# 2

from sys import argv

fromenc = argv[1]
toenc = argv[2]
filename = argv[3]
data = None

try:
	with open(filename, encoding = fromenc) as infile:
		data = infile.read()
except OSError:
	print(f"Error opening {filename}")
except UnicodeDecodeError:
	print(f"Error reading {filename} with {fromenc}")

if data is not None:
	try:
		with open(filename, "w", encoding = toenc) as outfile:
			print(data, file=outfile)
			# outfile.write(data)
	except UnicodeDecodeError:
		print(f"Error writing {filename} with {toenc}")
		with open(filename, "w", encoding = fromenc) as outfile:
			print(data, file=outfile)
			# outfile.write(data)
