
import java.util.ArrayList;
import java.util.List;

// Bank class
class Bank { 
    String name;
    List<Customer> customers;

    public Bank(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public void openAccount(Customer customer, BankAccount account) {
        customer.addAccount(account);
        if (!customers.contains(customer)) {
            customers.add(customer);
        }
        System.out.println("Account opened for " + customer.getName() + " at " + name);
    }
}

// Customer class
class Customer {
    String name;
    List<BankAccount> accounts;

    public Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public void addAccount(BankAccount account) {
        accounts.add(account);
    }

    public String getName() {
        return name;
    }

    public void viewBalance() {
        System.out.println("Customer: " + name);
        for (BankAccount account : accounts) {
            System.out.println("Account ID: " + account.getAccountId() + ", Balance: " + account.getBalance());
        }
    }
}

// BankAccount class
class BankAccount {
    private static int idCounter = 1000;
    private int accountId;
    private double balance;
    private Bank bank;

    public BankAccount(Bank bank, double balance) {
        this.accountId = idCounter++;
        this.bank = bank;
        this.balance = balance;
    }

    public int getAccountId() {
        return accountId;
    }

    public double getBalance() {
        return balance;
    }
}

public class BankandAccountHolders {
    public static void main(String[] args) {
        Bank bank1 = new Bank("National Bank");
        Customer customer1 = new Customer("Alice");
        Customer customer2 = new Customer("Bob");

        BankAccount account1 = new BankAccount(bank1, 5000);
        BankAccount account2 = new BankAccount(bank1, 7000);

        bank1.openAccount(customer1, account1);
        bank1.openAccount(customer2, account2);

        customer1.viewBalance();
        customer2.viewBalance();
    }
}

