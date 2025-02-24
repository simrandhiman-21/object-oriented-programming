import java.util.Scanner;

class BankAccount{
    String accountHolder;
    int accountNumber;
    double balance;

    BankAccount(String accountHolder,int accountNumber,double balance){
        this.accountHolder=accountHolder;
        this.accountNumber=accountNumber;
        this.balance=balance;
    }


    public void DepositMoney(double amount){
        if(amount>0){
            balance+=amount;
            System.out.println("Deposited: " + amount);
        }
        else{
            System.out.println("Invalid Amount");
        }
    }

    public void WithdrawMoney(double amount){
        if(amount>0 && balance>0 && amount<=10000){
            balance-=amount;
            System.out.println("withdrawel: " + amount);
        }
        else{
            System.out.println("Invalid Amount ");
        }
    }

    public void dispplay(){
        System.out.println("AccountHodler :"+accountHolder+" AccountNumber "+accountNumber + " balance "+balance);
    }   
}

public class AtmBank {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        
        System.out.println("Enter AccountHolder ");
        String accountHolder=sc.nextLine();
        
        System.out.println("Enter AccountNumber ");
        int accountNumber=sc.nextInt();
        
        System.out.println("Enter initail balance ");
        double initialBalance=sc.nextDouble();

        // Create a new BankAccount object
        BankAccount account = new BankAccount(accountHolder, accountNumber, initialBalance);


        while(true){

            System.out.println("\nATM Menu:");
            System.out.println("1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Display Balance");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter Amount to deposit: ");
                    double depositMoney=sc.nextDouble();
                    account.DepositMoney(depositMoney);
                    break;

                 case 2:
                    System.out.println("Enter Amount to deposit: ");
                    double withdrawMoney=sc.nextDouble();
                    account.WithdrawMoney(withdrawMoney);
                    break;

                 case 3:
                    account.dispplay();
                    break; 
                    
                case 4:
                    System.out.println("Existing ...");
                    break;

                default:
                System.out.println("Invalid option. Please try again.");
            }        
        }        
    }
}
