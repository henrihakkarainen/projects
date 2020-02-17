# Exercise one (regular expressions)

import re
from sys import argv

with open(argv[1]) as infile:
	text = infile.read()

# Match course code, name of the course
# TIEP1 Introduction to Programming I - 5 ECTS (for example)
res = re.findall(r"[A-Z]{3}[A-Z]*\d+.+ECTS", text)
print(res)

res = re.finditer(r"([A-Z]{3}[A-Z]*\d+)(.+ECTS)", text)
for r in res:
	print(r.groups())
	#r.group(0) = koko lause
	# muuten lasketaan avaavan sulkeen perusteella (r.group(1), r.group(2)...)
	
res = re.sub(r"([A-Z]{3}[A-Z]*\d+)\s+([-\w()]+(\s+[-\w()]+)*)\s+(\d+(-\d+)?\s+ECTS)",
			r"\1, \2, \4", text)
print(res)
# GROUP1, GROUP2 (NAME), GROUP4 (ECTS)

def repfunc(m):
	(m.group(1) + ", " + m.group(2) + ", " + m.group(4)).upper()

res = re.sub(r"([A-Z]{3}[A-Z]*\d+)\s+([-\w()]+(\s+[-\w()]+)*)\s+(\d+(-\d+)?\s+ECTS)",
			repfunc, text)
