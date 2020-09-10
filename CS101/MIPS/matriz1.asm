.data 
	mat1: .space 9
	mat2: .space 9
	mat3: .space 9
	message1: .asciiz "Ingrese # positivo, mat A: "
	message2: .asciiz "Ingrese # positivo, mat B: "
	wrong:	.asciiz "El numero deberia ser positivo porfavor: "
	newline: .asciiz "\n"
	dim: .byte 03
	space: .asciiz "   "
.text 
	_main:
	
	la $s0, mat1			#s0 will be mat 1 pointer
	la $s1, mat2			#s1 will be mat 2 pointer
	la $s2, mat3			#s2 will be mat 3 pointer
	lb $s3, dim			#s3 will be DIM
	mul $s4, $s3, $s3		#s4 will be DIM*DIM
	
	
	
	#prepare arguments for Read Matrix A
	la $a0, message1		#prepare message to be sent
	la $a1, ($s0)			#t1 will be temporary pointer
	la $a2, ($s4)			#maximum size of array elements 
	jal readMatrix
	
	#prepare arguments for Read Matrix B
	la $a0, message2		#prepare message to be sent
	la $a1, ($s1)			#a1 will be temporary pointer
	la $a2, ($s4)			#maximum size of array elements 
	jal readMatrix
	
	#prepere arguments for Matrix Mult
	jal multiplyMatrix
	
	
	#prepare Arguments for printing matrix C
	la $a1, ($s2)			#temporary pointer for array to be printed
	la $a2, ($s4)			#maximum index of array elements
	la $a3, ($s3)			#Dimension
	jal printMatrix
	
	 
	li $v0, 10			#end program
	syscall 
	
	
	readMatrix:
		li $t0, 0		#t0 will be loop counter for reading input
		la $t2, ($a0)
		
		loop1:
		li $v0, 4		#print string asking for number
		syscall 
		
		input:
		li $v0, 5
		syscall 		#read input of 1 byte
		
		bgez $v0, good_job		#validate number is equal to or greater than zero.
		nop
		la $a0, wrong		#print error requesting correct number
		li $v0, 4
		syscall 
		b input
		good_job:
		la $a0, ($t2)
		
		sb $v0, ($a1)		#store byte at pointer
		
		addi $a1, $a1, 1	#move pointer by 4 bytes
		
		addi $t0, $t0, 1	#add 1 to counter
		
		bne  $t0, $a2, loop1
		nop
		jr  $ra
		nop
		
		
	printMatrix:
		
		li $t0, 1		#row counter
		li $t1, 0		#total counter
		
		
		s:
		lbu  $a0, ($a1)
		li $v0, 1		#print loaded byte
		syscall 
		
		la $a0, space
		li $v0, 4		#print space
		syscall 
		
		bne $t0, $a3, end
		la $a0, newline		#if row end then print newline
		li $v0, 4
		li $t0, 0
		syscall 
		
		end:
		addi $a1, $a1, 1	#move pointer by 1 bytes
		
		addi $t0, $t0, 1
		addi $t1, $t1, 1
		
		bne $t1, $a2, s		#return to beginning of loop
		nop
		
		jr $ra			#return to main program
		nop
			
	multiplyMatrix:
		li $t0, 0		#matrix 1 row counter
		li $t1, 0		#matrix 2 column counter
		li $t2, 0		#matrix 1 and 2 element counter
		
		la $t3, ($s0)		#temporary pointer A
		la $t4, ($s1)		#temporary pointer B
		la $s7, ($s2)		#temporary pointer C
		
		la $t5, ($s3)		#row/column max
		
		li $t6, 0		#counter for sum
		li $t7, 0		#intermediate arithmetic results
		

		
	
		inner:
		
		lbu  $t8, ($t3)		#load Values A, B
		lbu  $t9, ($t4)
			
		mul $t7, $t8, $t9
		add $t6, $t6, $t7	#add to sum A X B
 
		addi $t3, $t3, 1	#move A pinter 1 column right
		add  $t4, $t4, $t5	#move B pointer 1 row down
		
		addi $t2, $t2, 1	#add to iteratot/counter
		bne $t2, $t5, inner	#check inner element/ number of columnsA | number of rowsB
		li $t2, 0		#reset t2
		
		sb  $t6, ($s7)		#store result into C
		addi $s7, $s7, 1	#move C pointer
		li $t6, 0
		
		addi $t1, $t1, 1	#move counter
		
		subu $t3, $t3, $t5	#move pointer A to beginning of row
		add  $t4, $t1, $s1	#move pointer B to top of column t1
		
		 	
		
		
		bne $t1, $t5, inner	#check m2 column
		li $t1, 0		#reset t1
		add $t3, $t3, $t5	#move pointer A to beginning of next row
		la $t4, ($s1)		#reset M2 pointer
		addi $t0, $t0, 1
		
		bne $t0, $t5, inner	#check m1 row
		jr $ra			#back to main