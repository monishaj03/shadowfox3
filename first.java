import java.util.*;


public class first {
  public static void main(String[] args) {
    Account a = new Account(5050);
    Customer cust1 = new Customer(a,"amit");
    Customer cust2 = new Customer(a,"sumit");
    cust1.start();
    cust2.start();
  }

}
class Account{
  int bal;

  Account(int bal){
     this.bal = bal;
     
  }
 boolean isSufficient(int amount){
        return bal>amount;    
  }
  void withdraw(int amt){
    bal-=amt;
    System.out.println("transaction successfully completed");
    System.out.println(" bro ...... your current balance is "+ bal  );
  }
}

class Customer extends Thread{
  Account a;
  String s ;
  Customer(Account acc,String s  ){
    a = acc;
    this.s = s;
  }
  @Override
  public void run(){
    synchronized(a)
    {
    System.out.println("Enter the amount to withdraw");
  
     Scanner scanner = new Scanner(System.in);
    int x =  scanner.nextInt();
    if(a.isSufficient(x)){
      System.out.println(s + " BROOOOOOO.......22");
      a.withdraw(x);
    }
    else{
      System.out.println("Not enough balance");
    }
  }

  } 

}