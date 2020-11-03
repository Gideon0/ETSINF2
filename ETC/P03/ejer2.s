         .globl __start
         .text 0x00400000
__start:  #leer los dos enteros
          li $a0,'M'
          jal Input 
          move $t0,$v0 #t0 1º entero leido
          li $a0,'Q'
          jal Input
          move $a1,$v0 #a0 2º entero leido(Q)
          move $a0,$t0 #a1 1º entero leido(M)
          
          #Llamar a Mult
          jal Mult #Multiplica a0*a1 = v0
          
          #Imtprime resultado
          li $a0,'R'
          move $a1,$v0
          jal Output
          #exit
          li $v0,10 #10 -> exit
          syscall 

Mult:     li $v0, 0 #set $v0 to 0
          beqz $a1,MultRet #if $a1 == 0 -> MultRet
MultFor:  add $v0, $v0, $a0 #$v0 = $v0 + $a0
          addi $a1, $a1, -1 #$a1 -= 1
          bne $a1, $zero,MultFor #if $a1 != 0 -> MultFor
MultRet:  jr $ra 

Input:    li $v0,11 #Print char
          syscall
          li $a0,'='
          syscall
          li $v0,5#Scan int 
          syscall
          jr $ra

Output:   li $v0,11 #Print char
          syscall
          li $a0,'='
          syscall
          move $a0,$a1
          li $v0,1 #Print int
          syscall
          jr $ra