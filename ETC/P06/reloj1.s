                ##########################################################
                # Segmento de datos
                ##########################################################

                .data 0x10000000
reloj:          .word 0                # HH:MM:SS (3 bytes de menor peso)

cad_asteriscos: .asciiz "\n  **************************************"
cad_horas:      .asciiz "\n   Horas: "
cad_minutos:    .asciiz " Minutos: "
cad_segundos:   .asciiz " Segundos: "
cad_reloj_en_s: .asciiz "\n   Reloj en segundos: "

                ##########################################################
                # Segmento de código
                ##########################################################

                .globl __start
                .text 0x00400000

__start:        la $a0, reloj
                jal imprime_reloj
				
				la $a0, reloj
				li $a1, 0x82
				li $a2, 59
				li $a3, 59
				jal inicaliza_reloj_alt
				
				la $a0, reloj
                jal imprime_reloj
				
				
				
salir:          li $v0, 10              # Código de exit (10)
                syscall                 # Última instrucción ejecutada
                .end

pasa_segundo:	lbu $t0, 0($a0)
				addiu $t0, $t0, 1
				li $t1, 60
				beq $t0, $t1, S60
				sb $t0, 0($a0)
				j fin_pasa_segundo
				
S60:			sb $zero, 0($a0)
				lbu $t0, 1($a0)
				addiu $t0, $t0, 1
				beq $t0, $t1, M60
				sb $t0, 0($a0)
				j fin_pasa_segundo
				
M60:			sb $zero, 1($a0)
				lbu $t0, 2($a0)         # $t0 = HH
                addiu $t0, $t0, 1       # $t0 = HH++
                li $t1, 24
                beq $t0, $t1, H24_2       # Si HH==24 se pone HH a cero
                sb $t0, 2($a0)          # Escribe HH++
                j fin_pasa_segundo
H24_2:           sb $zero, 2($a0)  
				
fin_pasa_segundo:	
				jr $ra 				
				


devuelve_reloj_en_s_sd:
				lbu $a1, 2($a0)
				lbu $a2, 1($a0)
				lbu $a3, 0($a0)
				
				sll $v0, $a1, 11
				sll $t1, $a1, 10
				sll $t2, $a1, 9
				sll $t3, $a1, 4
				addu $t2, $t2, $t3
				addu $t1, $t1, $t2
				addu $v0, $v0, $t1
				
				sll $t1, $a2, 5
				sll $t2, $a2, 4
				sll $t3, $a2, 3
				sll $t4, $a2, 2
				addu $v0, $v0, $t1
				addu $v0, $v0, $t2
				addu $v0, $v0, $t3
				addu $v0, $v0, $t4
				
				addu $v0, $v0, $a3
				jr $ra
inicializa_reloj_en_s:
				li $t0, 60
				divu $a1, $t0
				mflo $a2
				mfhi $a3
				divu $a2, $t0
				mflo $a1
				mfhi $a2
				sb $a1, 2($a0)
				sb $a2, 1($a0)
				sb $a3, 0($a0)
				jr $ra

devuelve_reloj_en_s:
				lbu $a1, 2($a0)
				lbu $a2, 1($a0)
				lbu $a3, 0($a0)
				li $t0, 3600
				li $t1, 60
				mult $a1, $t0
				mflo $t0
				mult $a2, $t1
				mflo $t1
				li $v0, 0
				addu $v0, $t0, $t1
				addu $v0, $v0, $a3
				jr $ra
                ########################################################## 
                # Subrutina que asigna un valor del reloj
                # Entrada: $a0 con la dirección de la variable reloj
				#		   $a1 con el contenido de la variable
                ##########################################################
inicializa_reloj: 
				sw $a1, 0($a0)
				jr $ra
                ########################################################## 
                # Subrutina que asigna un valor del reloj
                # Entrada: $a0 con la dirección de la variable reloj
				#		   $a1 con las horas
				#		   $a2 con los minutos
				#		   $a3 con los segundos
				#			
                ##########################################################
inicaliza_reloj_alt: 
				sb $a1, 2($a0)
				sb $a2, 1($a0)
				sb $a3, 0($a0)
				jr $ra	

                ########################################################## 
                # Subrutina que asigna un valor del reloj
                # Entrada: $a0 con la dirección de la variable reloj
				#		   $a1 con los minutos
				#			
                ##########################################################
inicaliza_reloj_mm: 
				sb $a1, 1($a0)
				jr $ra	
                ########################################################## 
                # Subrutina que asigna un valor del reloj
                # Entrada: $a0 con la dirección de la variable reloj
				#		   $a1 con los segundos
                ##########################################################
inicaliza_reloj_ss: 
				sb $a1, 0($a0)
				jr $ra	
				
				
                ########################################################## 
                # Subrutina que asigna un valor del reloj
                # Entrada: $a0 con la dirección de la variable reloj
				#		   $a1 con los horas	
                ##########################################################
inicaliza_reloj_hh: 
				sb $a1, 3($a0)
				jr $ra					
				########################################################## 
                # Subrutina que imprime el valor del reloj
                # Entrada: $a0 con la dirección de la variable reloj
                ##########################################################
imprime_reloj:  move $t0, $a0
                la $a0, cad_asteriscos  # Dirección de la cadena
                li $v0, 4               # Código de print_string
                syscall

                la $a0, cad_horas       # Dirección de la cadena
                li $v0, 4               # Código de print_string
                syscall

                lbu $a0, 2($t0)         # Lee el campo HH
                li $v0, 1               # Código de print_int
                syscall

                la $a0, cad_minutos     # Dirección de la cadena
                li $v0, 4               # Código de print_string
                syscall

                lbu $a0, 1($t0)         # Lee el campo MM
                li $v0, 1               # Código de print_int
                syscall

                la $a0, cad_segundos    # Dirección de la cadena
                li $v0, 4               # Código de print_string
                syscall

                lbu $a0, 0($t0)         # Lee el campo SS
                li $v0, 1               # Código de print_int
                syscall

                la $a0, cad_asteriscos  # Dirección de la cadena
                li $v0, 4               # Código de print_string
                syscall
                jr $ra

                ########################################################## 
                # Subrutina que imprime los segundos calculados
                # Entrada: $a0 con los segundos a imprimir
                ########################################################## 

imprime_s:      move $t0, $a0
                la $a0, cad_asteriscos  # Dirección de la cadena
                li $v0, 4               # Código de print_string
                syscall


                la $a0, cad_reloj_en_s  # Dirección de la cadena
                li $v0, 4               # Código de print_string
                syscall

                move $a0, $t0           # Valor entero a imprimir
                li $v0, 1               # Código de print_int
                syscall

                la $a0, cad_asteriscos  # Dirección de la cadena
                li $v0, 4               # Código de print_string
                syscall
                jr $ra
                
                ########################################################## 
                # Subrutina que incrementa el reloj en una hora
                # Entrada: $a0 con la dirección del reloj
                # Salida: reloj incrementado en memoria
                # Nota: 23:MM:SS -> 00:MM:SS
                ########################################################## 
                
pasa_hora:      lbu $t0, 2($a0)         # $t0 = HH
                addiu $t0, $t0, 1       # $t0 = HH++
                li $t1, 24
                beq $t0, $t1, H24       # Si HH==24 se pone HH a cero
                sb $t0, 2($a0)          # Escribe HH++
                j fin_pasa_hora
H24:            sb $zero, 2($a0)        # Escribe HH a 0
fin_pasa_hora:  jr $ra
