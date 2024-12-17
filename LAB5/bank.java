import java.util.Scanner;

abstract class Account {
    String customerName;
    String accountType;
    String accountNumber;
    double balance;

    public Account(String customerName, String accountType, String accountNumber) {
        this.customerName = customerName;
        this.accountType = accountType;
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited amount is: " + amount);
        displayBalance();
    }

    public void displayBalance() {
        System.out.println("Current balance is: " + balance);
    }

    public abstract void withdraw(double amount);
}

class SavAcct extends Account {
    double interestRate;

    public SavAcct(String customerName, String accountNumber, double interestRate) {
        super(customerName, "savings", accountNumber);
        this.interestRate = interestRate;
    }

    public void compoundDeposit() {
        double interest = balance * (interestRate / 100);
        deposit(interest);
        System.out.println("Interest of " + interest + " deposited");
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn amount is: " + amount);
        } else {
            System.out.println("Insufficient amount for withdrawal.");
            return;
        }
        displayBalance();
    }
}

class CurAcct extends Account {
    private static final double minBalance = 1000.0;
    private static final double serviceCharge = 50.0;

    public CurAcct(String customerName, String accountNumber) {
        super(customerName, "current", accountNumber);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn amount is: " + amount);

            // Apply service charge if balance falls below minimum
            if (balance < minBalance) {
                balance -= serviceCharge;
                System.out.println("Minimum balance not maintained. Service charge of: " + serviceCharge + " applied.");
            }
        } else {
            System.out.println("Insufficient amount for withdrawal.");
        }
        displayBalance();
    }
}

public class Bank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your account type (savings/current):");
        String accountType = scanner.nextLine().trim();
        System.out.println("Enter account number:");
        String accountNumber = scanner.nextLine().trim();
        System.out.println("Enter your name:");
        String customerName = scanner.nextLine().trim();

        Account account;
        if (accountType.equalsIgnoreCase("savings")) {
            System.out.println("Enter the interest rate:");
            double interestRate = scanner.nextDouble();
            account = new SavAcct(customerName, accountNumber, interestRate);
        } else if (accountType.equalsIgnoreCase("current")) {
            account = new CurAcct(customerName, accountNumber);
        } else {
            System.out.println("Invalid account type. Exiting.");
            scanner.close();
            return;
        }

        while (true) {
            System.out.println("1. Deposit\n2. Withdraw\n3. Display Balance\n4. Exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter amount to deposit:");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.println("Enter amount to withdraw:");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    account.displayBalance();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
