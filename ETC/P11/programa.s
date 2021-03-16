                ######################################################
                # Segmento de datos
                ######################################################

                .data 0x10000000
A:              .word 0,1,2,3,4,5,6,7   # Vector A
                .data 0x10001000
B:              .space 32               # Vector B (resultado)
                .data 0x1000A030
k:              .word 7                 # Constante escalar
dim:            .word 8                 # Dimensi�n de los vectores

                ######################################################
                # Segmento de c�digo
                ######################################################

                .text 0x00400000
                .globl __start
                
__start:        la $a0, A               # $a0 = direcci�n de A
                la $a1, B               # $a1 = direcci�n de B
                la $a2, k               # $a1 = direcci�n de k
                la $a3, dim             # $a2 = direcci�n dimensi�n
                jal sax                 # Llamada a subrutina
                
                ######################################################
                # Fin de ejecuci�n mediante llamada al sistema
                ######################################################

                addi $v0, $zero, 10     # C�digo para exit
                syscall                 # Fin de la ejecuci�n
                
                ######################################################
                # Subrutina que calcula Y <- k*X 
                # $a0 = Direcci�n inicio vector X
                # $a1 = Direcci�n inicio vector Y
                # $a2 = Direcci�n constante escalar k
                # $a3 = Direcci�n dimensi�n de los vectores                
                ######################################################

sax:            lw $a2, 0($a2)          # $a3 = constante k
                lw $a3, 0($a3)          # $a3 = dimensi�n
bucle:          lw $t0, 0($a0)          # Lectura de X[i] en $t0
                mult $a2, $t0           # Efect�a k*X[i]
                mflo $t0                # $t0 <- k*X[i] (HI vale 0)
                sw $t0, 0($a1)          # Escritura de Y[i] 
                addi $a0, $a0, 4        # Direcci�n de X[i+1]
                addi $a1, $a1, 4        # Direcci�n de Y[i+1]
                addi $a3, $a3, -1       # Decremento n�mero elementos
                bgtz $a3, bucle         # Salta si quedan elementos
                jr $ra                  # Retorno de subrutina
                
                .end

