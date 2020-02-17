# 1

'''

def indexDict(vals):
	keylist = {}
	for v in vals:
		last_index = (len(vals) - 1) - list(reversed(vals)).index(v)
		keylist[v] = last_index
	return keylist
	
print(indexDict([1, "seven", 5, 9, "seven", 5, 9, 1]))

'''

# 2

'''

def indexDict(vals):
	keylist = {}
	for v in vals:
		index = vals.index(v)
		keylist[v] = index
	return keylist
	
print(indexDict([1, "seven", 5, 9, "seven", 5, 9, 1]))

'''

# 3

def indexDict(vals):
	keylist = {}
	for v in vals:
		indices = []
		for i, x in enumerate(vals):
			if x == v:
				indices.append(i)
		keylist[v] = indices
	return keylist

print(indexDict([1, "seven", 5, 9, "seven", 5, 9, 1]))


