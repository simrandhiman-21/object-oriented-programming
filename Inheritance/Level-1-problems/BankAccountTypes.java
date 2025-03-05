
// Base class: BankAccount
class BankAccount {
    protected String accountNumber;
    protected double balance;
    
    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    
    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber + ", Balance: $" + balance);
    }
}

// Subclass: SavingsAccount
class SavingsAccount extends BankAccount {
    private double interestRate;
    
    public SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }
    
    public void displayAccountType() {
        System.out.println("Account Type: Savings Account");
        displayAccountInfo();
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}

// Subclass: CheckingAccount
class CheckingAccount extends BankAccount {
    private double withdrawalLimit;
    
    public CheckingAccount(String accountNumber, double balance, double withdrawalLimit) {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }
    
    public void displayAccountType() {
        System.out.println("Account Type: Checking Account");
        displayAccountInfo();
        System.out.println("Withdrawal Limit: $" + withdrawalLimit);
    }
}

// Subclass: FixedDepositAccount
class FixedDepositAccount extends BankAccount {
    private int maturityPeriod;
    
    public FixedDepositAccount(String accountNumber, double balance, int maturityPeriod) {
        super(accountNumber, balance);
        this.maturityPeriod = maturityPeriod;
    }
    
    public void displayAccountType() {
        System.out.println("Account Type: Fixed Deposit Account");
        displayAccountInfo();
        System.out.println("Maturity Period: " + maturityPeriod + " months");
    }
}

// Main class to test the hierarchy
    public class BankAccountTypes {
    public static void main(String[] args) {
        SavingsAccount savings = new SavingsAccount("SA123", 5000, 2.5);
        CheckingAccount checking = new CheckingAccount("CA456", 3000, 1000);
        FixedDepositAccount fixedDeposit = new FixedDepositAccount("FD789", 10000, 12);
        
        savings.displayAccountType();
        System.out.println();
        checking.displayAccountType();
        System.out.println();
        fixedDeposit.displayAccountType();
    }
}

