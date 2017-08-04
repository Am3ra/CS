##Source of problem: https://ocw.mit.edu/courses/electrical-engineering-and-computer-science/6-00sc-introduction-to-computer-science-and-programming-spring-2011/unit-1/lecture-4-machine-interpretation-of-a-program/MIT6_00SCS11_ps1.pdf



# bal       = float(raw_input('Outstanding balance: '))
# intrate   = float(raw_input('Annual interest rate: '))
# minrate   = float(raw_input('Minimum monthly payment: '))
# intpaid   = 0
# prinpaid  = 0
# month     = 1
# minmon    = 0
# totalpaid = 0
# while month <= 12:
	# minmon = minrate * bal
	# intpaid = intrate / 12.0 * bal
	# prinpaid = minmon - intpaid
	# bal -= prinpaid
	# totalpaid += minmon
	# print("Month: " + str(month))
	# print('Minimum monthly payment: ' + str(round(minmon,2)))
	# print('Principle paid: ' + str(round(prinpaid,2)))
	# print('Remaining Balance: ' + str(round(bal,2)))
	# month += 1
# print('RESULT:')
# print('Total paid: '+str(round(totalpaid,2)))
# print('Remaining Balance: '+str(round(bal,2)))


#
#Exhaustive search method

# inibal  = float(raw_input('Outstanding balance: '))
# intrate = float(raw_input('Annual interest rate: '))
# monrate = intrate / 12.0
# minmon  = inibal / 12.0
# maxmon  = (inibal * (1.0 + (intrate / 12.0)) ** 12.0 ) / 12.0
# monpay  = 0.0
# intpay  = intrate / 12.0
# month   = 1
# updtbal = inibal
# tri     = 0
#
# while monpay <= maxmon :
	# updtbal = inibal
	# while month <= 12:
		# updtbal = updtbal*(1+monrate)-monpay
		# if updtbal <= 0:
			# break
		# month += 1
	# if updtbal <= 0.0:
		# break
	# else:
		# month = 1
		# monpay += 0.01
		# tri += 1
	# print(tri)
#
# print('RESULT')
# print('Monthly payments to pay debts in 1 year: ' + str(round(monpay,2)))
# print("Months taken to pay: " + str(month))
# print('Remaining balance: '+ str(round(updtbal,2)))


inibal  = float(raw_input('Outstanding balance: '))
intrate = float(raw_input('Annual interest rate: '))
monrate = intrate / 12.0
minmon  = inibal / 12.0
maxmon  = (inibal * (1.0 + (intrate / 12.0)) ** 12.0 ) / 12.0
monpay  = (minmon+maxmon)/2.0
intpay  = intrate / 12.0
month   = 1
updtbal = inibal
tri     = 0


while monpay <= maxmon :
	updtbal = inibal
	monpay  = (minmon + maxmon) / 2.0

	while month <= 12:
		updtbal = updtbal*(1+monrate)-monpay
		if updtbal <= 0:
			break
		month += 1

	if updtbal > 0.0:
		minmon  = monpay
		month   = 1
		tri    += 1


	elif updtbal <= -0.005 :
		maxmon = monpay
		month   = 1
		tri    += 1

	else:
		break

	print "tri: " , tri
#
print('RESULT')
print('Monthly payments to pay debts in 1 year: ' + str(round(monpay,2)))
print("Months taken to pay: " + str(month))
print('Remaining balance: '+ str(round(updtbal,2)))
#
