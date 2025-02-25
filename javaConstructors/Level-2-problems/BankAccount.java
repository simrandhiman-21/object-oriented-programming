class BankAccount {
    public String accountNumber;
    protected String accountHolder;
    private double balance;

    
    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    
    public double getBalance() {
        return balance;
    }

    
    public void setBalance(double balance) {
        if (balance >= 0) {
            this.balance = balance;
        } else {
            System.out.println("Invalid balance amount.");
        }
    }

    
    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: $" + balance);
    }
}

class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, String accountHolder, double balance, double interestRate) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
    }

    public void displaySavingsAccountDetails() {
        System.out.println("Savings Account Details:");
        System.out.println("Account Number: " + accountNumber); // Accessing public member from parent class
        System.out.println("Account Holder: " + accountHolder); // Accessing protected member from parent class
        System.out.println("Interest Rate: " + interestRate + "%");
    }

    public static void main(String[] args) {
        
        BankAccount account1 = new BankAccount("123456", "Alice Johnson", 5000.0);
        account1.displayAccountDetails();
        System.out.println();

        
        account1.setBalance(6000.0);
        System.out.println("Updated Balance: $" + account1.getBalance());
        System.out.println();

        
        SavingsAccount savings1 = new SavingsAccount("789012", "Bob Smith", 8000.0, 2.5);
        savings1.displaySavingsAccountDetails();
    }
}

