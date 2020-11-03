          .globl __start
          .text 0x00400000

__start:
          li $s0,0
	  li $s1,0
loop: 
          addi $s1, $s1,1
	  li $v0,1
          move $a0, $s1
          syscall #Imprime numero de interación
		  
	  li $v0,11
          li $a0, 62 #Simbolo >
          syscall		
		  
	  li $v0,5
          syscall	#Lee el entreo por consola
		  
	  beqz $v0,salto # Salta si el número leido es 0
		  
          addu $s0,$s0,$v0 
          
		  
		  
          b loop
salto:
          
		  
	  li $v0,11
          li $a0, 61
          syscall#imprime '='
		  
	  li $v0,1
          move $a0, $s0
          syscall# imprime s0
		  
	  li $v0,11
          li $a0, 10
          syscall# imprime '\n'
		  
	  li $v0,11
          li $a0, 110
          syscall #imprime 'n'
		  
	  li $v0,11
          li $a0, 61
          syscall #imprime '='
		  
	  move $a0, $s1
	  addi $a0, $a0 -1
	  li $v0,1 #imprime el numero de interaciones hechas
          syscall
		  
