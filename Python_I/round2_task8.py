def stringSearch(string, text, caseSensitive):
	result = []
	if caseSensitive == False:
		string = string.upper()
	for i, line in enumerate(text.split("\n"), start=1):
		if caseSensitive == False:
			line = line.upper()
		pos = line.find(string)
		while pos >= 0:
			result.append((i, pos + 1))
			pos = line.find(string, pos + len(string))
	return result
	
print(stringSearch("smith", "Mr Smith is a blacksmith.\nThe Smithsonian " +
"Institution is in Washington D.C.", True))
