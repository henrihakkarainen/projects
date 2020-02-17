# 2

from sys import argv

populations = {}
areas = {}

with open(argv[1]) as firstfile:
	for line in firstfile:
		parts = line.split("\t")
		name = parts[0]
		population = int(parts[1].replace(",", ""))
		populations[name] = population
		
with open(argv[2[) as secondfile:
	for line in secondline:
		parts = line.split("\t")
		name = parts[0]
		area = float(parts[1].replace(",", ""))
		areas[name] = area
		
for country in sorted(populations,
	key=lambda country: populations[country]/areas[country]):
		
	print(f"{country}\t{populations[country]}\t{areas[country]}"
	f"\t{populations[country] / areas[country]}")
