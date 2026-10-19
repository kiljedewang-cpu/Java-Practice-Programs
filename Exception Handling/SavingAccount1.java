import java.util.Scanner;

// User-defined exception
class InsufficientFundsException extends Exception {
    InsufficientFundsException(String message) {
        super(message);
    }
}

// SavingAccount class
class SavingAccount {
    int acNo;
    String name;
    double balance;

    // Parameterized constructor
    SavingAccount(int acNo, String name, double balance) {
        this.acNo = acNo;
        this.name = name;

        if (balance >= 500) {
            this.balance = balance;
        } else {
            this.balance = 500;
            System.out.println("Minimum balance is Rs.500.");
        }
    }

    // Deposit operation
    void deposit(double amount) {
        balance = balance + amount;
        System.out.println("Amount deposited: Rs." + amount);
    }

    // Withdraw operation
    void withdraw(double amount) throws InsufficientFundsException {

        if (balance - amount < 500) {
            throw new InsufficientFundsException(
                "Insufficient funds! Minimum balance of Rs.500 must be maintained."
            );
        }

        balance = balance - amount;
        System.out.println("Amount withdrawn: Rs." + amount);
    }

    // View balance
    void viewBalance() {
        System.out.println("Account Number: " + acNo);
        System.out.println("Name: " + name);
        System.out.println("Balance: Rs." + balance);
    }
}

// Main class
public class SavingAccount1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter account number: ");
        int acNo = sc.nextInt();

        System.out.print("Enter name: ");
        String name = sc.next();

        System.out.print("Enter initial balance: ");
        double balance = sc.nextDouble();

        SavingAccount account = new SavingAccount(acNo, name, balance);

        System.out.println("\nInitial Account Details:");
        account.viewBalance();

        System.out.print("\nEnter amount to deposit: ");
        double depositAmount = sc.nextDouble();
        account.deposit(depositAmount);

        account.viewBalance();

        System.out.print("\nEnter amount to withdraw: ");
        double withdrawAmount = sc.nextDouble();

        try {
            account.withdraw(withdrawAmount);
        }
        catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nFinal Account Details:");
        account.viewBalance();

        sc.close();
    }
}
