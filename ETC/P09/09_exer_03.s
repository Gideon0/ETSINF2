          .globl __start
          .data 0x10000000
pedir:   .asciiz "Escribe alguna cosa: "
cadena:   .space 80         
escrito:  .asciiz "Has escrito: " 
longitudES:  .asciiz "La logitud es: "   

          .text 0x00400000
__start:  la $a0, pedir        
          la $a1, cadena        
          li $a2, 80            
          jal InputS
          la $a0, escrito
          la $a1, cadena  
          jal OutputS
          jal Length
          la $a0, longitudES
          jal Longitud          
          li $v0,10
          syscall

InputS:   li $v0, 4
          syscall
          li $v0, 8
          move $a0, $a1
          move $a1, $a2
          syscall
          jr $ra

# Calcula la longitutud de un String
# $a0 -> Puntero de Str |  $a1 -> Resultado
Length:
          li $t1, -1

bucle:    add $t1, $t1, 1
          add $t2, $t1, $a0
          lb $t0, 0($t2)
          bnez $t0, bucle

          sub $t1, $t1, 1
          move $a1, $t1
          jr $ra
# Imprime el String -> $a0 y el Int -> $a1
Longitud:
          li $v0, 4
          syscall
          li $v0, 1
          move $a0, $a1
          syscall
          li $v0, 11        # print_char
          li $a0, 10        # Carácter ASCII ‘\n’ en $a0
          syscall  
          jr $ra

OutputS:
          li $v0, 4
          syscall
          li $v0, 4
          move $a0, $a1
          syscall
          jr $ra