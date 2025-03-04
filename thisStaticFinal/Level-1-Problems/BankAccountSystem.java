
class BankAccount {
    // Static variable shared by all instances
    private static String bankName = "Global Bank";
    private static int totalAccounts = 0;
    
    // Final variable to ensure accountNumber is not changed
    private final int accountNumber;
    private String accountHolderName;
    private double balance;
    
    // Constructor using 'this' to resolve ambiguity
    public BankAccount(int accountNumber, String accountHolderName, double initialDeposit) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialDeposit;
        totalAccounts++; // Increment total accounts
    }
    
    // Static method to get total accounts
    public static int getTotalAccounts() {
        return totalAccounts;
    }
    
    // Method to display account details
    public void displayAccountDetails() {
        if (this instanceof BankAccount) { // Using instanceof
            System.out.println("Bank Name: " + bankName);
            System.out.println("Account Holder: " + accountHolderName);
            System.out.println("Account Number: " + accountNumber);
            System.out.println("Balance: $" + balance);
        } else {
            System.out.println("Invalid Account.");
        }
    }
    
    public class BankAccountSystem {
        public static void main(String[] args) {
        // Creating bank account objects
            BankAccount acc1 = new BankAccount(101, "Alice Smith", 1000.0);
            BankAccount acc2 = new BankAccount(102, "Bob Johnson", 1500.0);
    
            // Displaying account details
            acc1.displayAccountDetails();
            System.out.println();
            acc2.displayAccountDetails();
    
            // Displaying total accounts
            System.out.println("\nTotal Accounts: " + BankAccount.getTotalAccounts());
        }
    }
    
}
