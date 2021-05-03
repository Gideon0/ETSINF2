### ESTRUCTURA DE COMPUTADORES (ETS Eng. Inf.)
###
### marzo de 2014
###
### PRÁCTICA 13: SINCRONIZACIÓN POR INTERRUPCIONES
###
### nada.asm (material de partida para la práctica)

###################################################################
##                  DATOS DEL PROGRAMA USUARIO                   ##
###################################################################
	.data		
var2:	.word 0x77777777

###################################################################
##                  CÓDIGO DEL PROGRAMA USUARIO                  ##
###################################################################
	.text

main:	jr $ra	# Sólo una instrucción

	.end