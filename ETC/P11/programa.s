                ######################################################
                # Segmento de datos
                ######################################################

                .data 0x10000000
A:              .word 0,1,2,3,4,5,6,7   # Vector A
                .data 0x10001000
B:              .space 32               # Vector B (resultado)
                .data 0x1000A030
k:              .word 7                 # Constante escalar
dim:            .word 8                 # Dimensión de los vectores

                ######################################################
                # Segmento de código
                ######################################################

                .text 0x00400000
                .globl __start
                
__start:        la $a0, A               # $a0 = dirección de A
                la $a1, B               # $a1 = dirección de B
                la $a2, k               # $a1 = dirección de k
                la $a3, dim             # $a2 = dirección dimensión
                jal sax                 # Llamada a subrutina
                
                ######################################################
                # Fin de ejecución mediante llamada al sistema
                ######################################################

                addi $v0, $zero, 10     # Código para exit
                syscall                 # Fin de la ejecución
                
                ######################################################
                # Subrutina que calcula Y <- k*X 
                # $a0 = Dirección inicio vector X
                # $a1 = Dirección inicio vector Y
                # $a2 = Dirección constante escalar k
                # $a3 = Dirección dimensión de los vectores                
                ######################################################

sax:            lw $a2, 0($a2)          # $a3 = constante k
                lw $a3, 0($a3)          # $a3 = dimensión
bucle:          lw $t0, 0($a0)          # Lectura de X[i] en $t0
                mult $a2, $t0           # Efectúa k*X[i]
                mflo $t0                # $t0 <- k*X[i] (HI vale 0)
                sw $t0, 0($a1)          # Escritura de Y[i] 
                addi $a0, $a0, 4        # Dirección de X[i+1]
                addi $a1, $a1, 4        # Dirección de Y[i+1]
                addi $a3, $a3, -1       # Decremento número elementos
                bgtz $a3, bucle         # Salta si quedan elementos
                jr $ra                  # Retorno de subrutina
                
                .end

