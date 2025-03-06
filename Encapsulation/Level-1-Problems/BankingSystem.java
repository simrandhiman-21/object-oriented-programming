import java.util.*;
// Abstract class BankAccount
abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;
    
    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }
    
    public String getAccountNumber() {
        return accountNumber;
    }
    
    public String getHolderName() {
        return holderName;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }
    
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Invalid or insufficient funds");
        }
    }
    
    public abstract double calculateInterest();
    
    public void displayDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + holderName);
        System.out.println("Balance: " + balance);
    }
}

// Interface Loanable
interface Loanable {
    void applyForLoan(double amount);
    double calculateLoanEligibility();
}

// SavingsAccount class
class SavingsAccount extends BankAccount {
    private static final double INTEREST_RATE = 0.04;
    
    public SavingsAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }
    
    @Override
    public double calculateInterest() {
        return getBalance() * INTEREST_RATE;
    }
}

// CurrentAccount class
class CurrentAccount extends BankAccount implements Loanable {
    private static final double INTEREST_RATE = 0.02;
    private static final double LOAN_MULTIPLIER = 2.5;
    
    public CurrentAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }
    
    @Override
    public double calculateInterest() {
        return getBalance() * INTEREST_RATE;
    }
    
    @Override
    public void applyForLoan(double amount) {
        System.out.println("Loan application submitted for: " + amount);
    }
    
    @Override
    public double calculateLoanEligibility() {
        return getBalance() * LOAN_MULTIPLIER;
    }
}

// Main class to demonstrate polymorphism
public class BankingSystem {
    public static void main(String[] args) {
        List<BankAccount> accounts = new ArrayList<>();
        
        SavingsAccount acc1 = new SavingsAccount("SA123", "John Doe", 5000);
        CurrentAccount acc2 = new CurrentAccount("CA456", "Jane Smith", 10000);
        
        accounts.add(acc1);
        accounts.add(acc2);
        
        for (BankAccount account : accounts) {
            account.displayDetails();
            System.out.println("Interest Earned: " + account.calculateInterest());
            
            if (account instanceof Loanable) {
                System.out.println("Loan Eligibility: " + ((Loanable) account).calculateLoanEligibility());
            }
            System.out.println("--------------------------");
        }
    }
}
