          .globl __start
          .data 0x10000000
pedir:   .asciiz "Escribe alguna cosa: "
cadena:   .space 80         
escrito:  .asciiz "Has escrito: "    

          .text 0x00400000
__start:  la $a0, pedir        
          la $a1, cadena        
          li $a2, 80            
          jal InputS
          la $a0, escrito
          la $a1, cadena  
          jal OutputS          
          li $v0,10
          syscall

InputS:   li $v0, 4
          syscall
          li $v0, 8
          move $a0, $a1
          move $a1, $a2
          syscall
          jr $ra
OutputS:
          li $v0, 4
          syscall
          li $v0, 4
          move $a0, $a1
          syscall
          jr $ra
         
