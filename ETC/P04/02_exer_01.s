          .globl __start
          .text 0x00400000
__start:  li $a0, 'M' #Numero a multiplicar
		  jal Input #Salto a Input
		  move $t0, $v0 #Guarda el numero entero almacenado de $v0 en $t0 obtenido de Input
		  li $a0, 'Q' #Cuantas veces se multiplica
		  jal Input #Salto a Input
		  move $a0, $t0 #El valor a multiplicar guardado en $a0
		  move $a1, $v0 #El contador guardado en $a1
		  bgez $a1, If #si $a1 es mayor o igual a 0
		  
		  
If:    	  jal Mult #Salta a Mult para comprobar que el contador sea mayor a cero y de ser asi multiplicar o imprimir directamente 0.
		  li $a0, 'R'
		  move $a1, $v0
		  jal Output #llama a output para imprimir el resultado
		  li $v0, 10 #exit
		  syscall
		 
		  
		  
Mult:     li $v0, 0 #almacena 0 en $v0
          beqz $a1, MultRet #si $a1 es 0 MultRet
		  
MultFor:  add $v0, $v0, $a0 #almacena en $v0 la suma de $v0 y $a0
          addi $a1, $a1, -1 #resta 1 a $a1 porque es el contador
          bne $a1, $zero, MultFor #si $a1 es distinto de 0 vuelve a MultFor
		  
MultRet:  jr $ra #delvuelve el valor en $v0

Input:    li $v0, 11 #Primero imprime M y luego Q
		  syscall
		  li $a0, '=' #Imprime el signo 
		  syscall
		  li $v0, 5 #Lee un entero
		  syscall 
		  jr $ra #Devuelve el valor almacenado en $v0
		  
Output:   li $v0, 11 #imprime la R de If
		  syscall
		  li $a0, '='
		  syscall
		  li $v0, 1 #print del resultado almacenado en $a1
		  syscall
		  jr $ra
		  
		