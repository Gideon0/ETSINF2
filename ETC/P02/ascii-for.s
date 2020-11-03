        .globl __start
        .text 0x00400000
__start:
        li $s0,'a'
        li $s1,10
loop:
        li $v0,11
        move $a0,$s0
        syscall

        addi $s0,$s0,1
        addi $s1,$s1,-1
        bgtz $s1,loop

        li $v0,10
        syscall
