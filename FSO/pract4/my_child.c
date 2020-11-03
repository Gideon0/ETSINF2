#include <stdio.h>
#include <stdlib.h>
int main(int argc, char *argv[])
{ printf("Process %ld \n", (long)getpid());
fork();
printf("Process %ld,my parent %ld\n" ,(long)getpid(),(long)getppid());
sleep(15);
return 0;
}
