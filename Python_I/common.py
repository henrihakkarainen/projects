def most_common(vals):
	common = None
	common_count = None
	for val in vals:
		count = 0
		for val2 in vals:
			if val == val2:
				count += 1
		if common_count is None or common_count < count:
			common_count = count
			common = val
	return [common, common_count]

print("In the common module")
print(__name__)
