# 2

from sys import argv

s = argv[1]
n = int(argv[2])
subs = [s[i:j] for i in range(len(s)) for j in range(i+1, len(s)+1)]
subs = sorted(subs, key=lambda s: (-len(s), s))
for i in range(0, len(subs), n):
	print(" ".join(subs[i:i+n]))
