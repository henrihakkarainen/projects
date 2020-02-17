def print_bins(items, cap):
	total = 0
	container = []
	container_count = 0
	for i in range(0, len(items)):
		if total + items[i] >= cap:
			container_count += 1
			print("Container " + str(container_count) + ": " + " ".join(container)
			+ " (total: " + str(total) + ")")
			container = []
			total = 0
			container.append(str(items[i]))
			total += items[i]
		else:
			container.append(str(items[i]))
			total += items[i]
	container_count += 1
	print("Container " + str(container_count) + ": " + " ".join(container)
			+ " (total: " + str(total) + ")")


def list_bins(items, cap):
	total = 0
	bin_list = []
	container = []
	container_count = 0
	for i in range(0, len(items)):
		if total + items[i] >= cap:
			container_count += 1
			bin_list.append(tuple((container, total)))
			container = []
			total = 0
			container.append(items[i])
			total += items[i]
		else:
			container.append(items[i])
			total += items[i]
	container_count += 1
	bin_list.append(tuple((container, total)))
	return bin_list
			
print()
print_bins([36, 57, 49, 63, 30, 26, 65, 58, 50, 67, 39, 32], 100)
print()
print(list_bins([36, 57, 49, 63, 30, 26, 65, 58, 50, 67, 39, 32], 100))
