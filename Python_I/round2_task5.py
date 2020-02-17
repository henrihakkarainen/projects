# 1

'''

def checkTickets(correct, tickets):
	print("Correct numbers:", " ".join(map(str, correct)))
	for ticket in tickets:
		matches = []
		for number in ticket:
			if number in correct:
				matches.append(number)
		if matches:
			print("Ticket:", " ".join(map(str, ticket)), "({} correct: {})".format(len(matches), " ".join(map(str, matches))))
		else:
			print("Ticket:", " ".join(map(str, ticket)), "(0 correct)")
				
checkTickets([2, 30, 17, 8, 6, 19, 24], [[7, 6, 1, 2, 3, 5, 4],
[19, 3, 27, 13, 14, 17, 25],[5, 27, 6, 19, 7, 21, 14],[5, 10, 15, 20, 25, 28, 29]])

'''

# 2

def checkTickets(correct, tickets):
	print("Correct numbers:", " ".join(map(str, sorted(correct))))
	for ticket in tickets:
		matches = []
		for number in ticket:
			if number in correct:
				matches.append(number)
		if matches:
			print("Ticket:", " ".join(map(str, sorted(ticket))), "({} correct: {})".format(len(matches), " ".join(map(str, sorted(matches)))))
		else:
			print("Ticket:", " ".join(map(str, sorted(ticket))), "(0 correct)")

checkTickets([2, 30, 17, 8, 6, 19, 24], [[7, 6, 1, 2, 3, 5, 4],
[19, 3, 27, 13, 14, 17, 25],[5, 27, 6, 19, 7, 21, 14],[5, 10, 15, 20, 25, 28, 29]])
