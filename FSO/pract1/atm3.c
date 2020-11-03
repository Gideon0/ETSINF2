
#include <stdio.h>

#define InitBalance 1000
float Balance;

int main()
{ int operation;
  float income, withdraw;
  operation = 0;
  
  while(operation <= 5){
  
  printf("\nWelcome to the FSO ATM\n");
  Balance=InitBalance;
  operation=0;
  printf("\nIndicate operation to do:\n");
  printf(" 1.Cash Income\n 2.Cash Withdrawal\n 3.Balance Enquiry\n");
  printf(" 4.Account Activity\n 5.Change PIN\n 6.Exit\n\n");
  printf(" Operation:");
  scanf("%d",&operation); 


  switch(operation){
 
    case 1:
    printf(" Cash Income\n");
    printf("\n Enter the amount to deposit:");   
     scanf("%f",&income);
     Balance=Balance+income;  
    printf(" Successful income\n");
    break;
   
    case 2:
    printf(" Cash Withdrawal\n");
    printf("\n Enter the amount to withdraw:");
    scanf("%f",&income);
    
     if(Balance>income){
       Balance=Balance-income;
     }else{
       printf(" Operation does not allowed\n");
       printf("   Not enough cash\n");
     }
     break;

   case 3: 
   printf(" Balance Enquiry\n");
   break;
  
   case 4:
   case 5:
   printf(" This operation is not implemented");
   break;
  
   case 6:
   printf(" EXIT\n"); 
   break;
  
   default:
   printf(" ERROR: This opertaion does not applied\n");
   break;
  
  
  printf("\n\n Current Balance: %.2f Euros", Balance);
  printf("\n\n Thanks \n\n");
   return(0);
  }
}

printf("\n\n Current Balance: %.2f Euros", Balance);
  printf("\n\n Thanks \n\n");
   return(0);

}
