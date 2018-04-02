.data
	message1: .asciiz "How many numbers do you want printed? (integer): "
	return: .asciiz ", "
.text 
	li $t0,1	#initializing Variables
	li $t1,1	
	li $t2,0	#counter
	li $t4,0	#temporary
	
	la $a0, message1
	li $v0, 4	#print messge
	syscall 
	
	li $v0, 5	#recieve number
	syscall
	
	la $t3, ($v0)
	
	for:	la $a0, ($t0)		#print numb
		li $v0, 1	
		syscall 
		la $a0, return
		li $v0, 4		#print space
		syscall 
	
		add $t4, $t1,$t0	#t4 = t0 +t1
		la $t0, ($t1)		#t0 = t1
		la $t1,($t4)		#t1 = t4	
	
		addi $t2,$t2,1
		blt  $t2,$t3,for	#loop counter
	 
	   
	li $v0, 10
	syscall 
