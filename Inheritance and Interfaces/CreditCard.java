import java.util.Scanner;

// Interface
interface CreditCardInterface {
    void viewCreditAmount();
    void useCard(double amount);
    void payCredit(double amount);
    void increaseLimit(double amount);
}

// Silver Card Customer
class SilverCardCustomer implements CreditCardInterface {

    String name;
    String cardNumber;
    double creditAmount;
    double creditLimit;

    SilverCardCustomer(String name, String cardNumber) {
        this.name = name;
        this.cardNumber = cardNumber;
        this.creditAmount = 0;
        this.creditLimit = 50000;
    }

    public void viewCreditAmount() {
        System.out.println("Credit Amount: Rs." + creditAmount);
        System.out.println("Credit Limit : Rs." + creditLimit);
    }

    public void useCard(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid amount.");
        }
        else if (creditAmount + amount <= creditLimit) {
            creditAmount = creditAmount + amount;
            System.out.println("Transaction successful.");
            System.out.println("Amount used: Rs." + amount);
        }
        else {
            System.out.println("Transaction failed!");
            System.out.println("Credit limit exceeded.");
        }
    }

    public void payCredit(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid amount.");
        }
        else if (amount <= creditAmount) {
            creditAmount = creditAmount - amount;
            System.out.println("Payment successful.");
            System.out.println("Amount paid: Rs." + amount);
        }
        else {
            System.out.println("Payment failed!");
            System.out.println("Amount is greater than credit amount.");
        }
    }

    public void increaseLimit(double amount) {
        System.out.println("Limit increase is available only for Gold Card customers.");
    }
}

// Gold Card Customer
class GoldCardCustomer extends SilverCardCustomer {

    int increaseCount;

    GoldCardCustomer(String name, String cardNumber) {
        super(name, cardNumber);
        creditLimit = 100000;
        increaseCount = 0;
    }

    // Method overriding
    @Override
    public void increaseLimit(double amount) {

        if (increaseCount >= 3) {
            System.out.println("Limit cannot be increased more than 3 times.");
        }
        else if (amount <= 0 || amount > 5000) {
            System.out.println(
                "Limit can be increased by maximum Rs.5000 at a time."
            );
        }
        else {
            creditLimit = creditLimit + amount;
            increaseCount++;

            System.out.println("Credit limit increased successfully.");
            System.out.println("New Credit Limit: Rs." + creditLimit);
            System.out.println("Increase count: " + increaseCount + "/3");
        }
    }
}

// Main class
public class CreditCard {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Creating Silver Card object
        System.out.println("===== SILVER CARD CUSTOMER =====");

        System.out.print("Enter name: ");
        String silverName = sc.nextLine();

        System.out.print("Enter 16 digit card number: ");
        String silverCard = sc.nextLine();

        SilverCardCustomer silver =
            new SilverCardCustomer(silverName, silverCard);

        silver.viewCreditAmount();

        System.out.print("\nEnter amount to use: ");
        double amount = sc.nextDouble();
        silver.useCard(amount);

        System.out.print("Enter amount to pay: ");
        amount = sc.nextDouble();
        silver.payCredit(amount);

        silver.viewCreditAmount();

        // Creating Gold Card object
        System.out.println("\n===== GOLD CARD CUSTOMER =====");

        sc.nextLine();

        System.out.print("Enter name: ");
        String goldName = sc.nextLine();

        System.out.print("Enter 16 digit card number: ");
        String goldCard = sc.nextLine();

        GoldCardCustomer gold =
            new GoldCardCustomer(goldName, goldCard);

        gold.viewCreditAmount();

        System.out.print("\nEnter amount to use: ");
        amount = sc.nextDouble();
        gold.useCard(amount);

        System.out.print("Enter amount to pay: ");
        amount = sc.nextDouble();
        gold.payCredit(amount);

        // Increase limit
        System.out.println("\nIncreasing Gold Card limit:");

        for (int i = 1; i <= 4; i++) {

            System.out.print(
                "Enter amount for limit increase " + i + ": "
            );

            amount = sc.nextDouble();
            gold.increaseLimit(amount);
        }

        System.out.println("\nFinal Gold Card Details:");
        gold.viewCreditAmount();

        sc.close();
    }
}
