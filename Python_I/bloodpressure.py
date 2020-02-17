def systolic_pressure():
	while True:
		spres = input('Enter systolic pressure (or "quit" to stop): ')
		pres = None
		if spres == "quit":
			break
		else:
			try:
				pres = int(spres)
				if int(pres) <= 0:
					print("Enter a positive integer!")
				elif int(pres) > 0:
					spres = pres
					break
			except ValueError:
				print("Enter a positive integer!")
			
	return spres
  
def diastolic_pressure():
  while True:
    dpres = input('Enter diastolic pressure (or "quit" to stop): ')
    pres = None
    if dpres == "quit":
      break
    else:
      try:
        pres = int(dpres)
        if int(pres) <= 0:
          print("Enter a positive integer!")
        elif int(pres) > 0:
          dpres = pres
          break
      except ValueError:
        print("Enter a positive integer!")
			
  return dpres
  
while True:
  systolic = systolic_pressure()
  if systolic == "quit":
    print("Quit-command received. Stopping the program.")
    break
  else:
    diastolic = diastolic_pressure()
    if diastolic == "quit":
      print("Quit-command received. Stopping the program.")
      break
    else:
      if systolic < 90 or diastolic < 60:
        print("Low")
      elif systolic  < 120 and diastolic < 80:
        print("Normal")
      elif 120 <= systolic <= 129 and diastolic < 80:
        print("Elevated")
      elif systolic > 180 or diastolic > 120:
        print("Hypertensive crisis (consult your doctor immediately)")
      elif systolic >= 140 or diastolic >= 90:
        print("High (hypertension) stage 2")
      elif 130 <= systolic <= 139 or 80 <= diastolic <= 89:
        print("High (hypertension) stage 1")
