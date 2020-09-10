.text
	li $t0, 0
	li $t1, 0
	
	For: 	
		add  $t0, $t0, $t1
		addi $t1, $t1, 1
		ble  $t1, 100, For
	
	la $a0, ($t0)
	li $v0, 1
	syscall 
	li $v0, 10
	syscall 
