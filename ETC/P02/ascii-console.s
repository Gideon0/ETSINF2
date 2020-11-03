        .globl __start
        .text 0x00400000

__start:
        li $s0,32
        li $s1,127
loop:
        li $v0,1
        move $a0,$s0
        syscall
        li $v0,11
        li $a0,9
        syscall
        li $v0,11
        move $a0,$s0
        syscall
        li $v0,11
        li $a0,10
        syscall

        addi $s0,$s0,1
        blt $s0,$s1,loop

        li $v0,10
        syscall
