import java.util.Scanner;

// User-defined exception
class InvalidDateException extends Exception {
    InvalidDateException(String message) {
        super(message);
    }
}

// MyDate class
class MyDate {
    int day;
    int month;
    int year;

    // Accept date
    void accept(int day, int month, int year)
            throws InvalidDateException {

        if (month < 1 || month > 12) {
            throw new InvalidDateException("Invalid month.");
        }

        if (day < 1 || day > 31) {
            throw new InvalidDateException("Invalid day.");
        }

        // Check number of days in each month
        if (month == 4 || month == 6 ||
            month == 9 || month == 11) {

            if (day > 30) {
                throw new InvalidDateException("Invalid date.");
            }
        }

        // Check February
        if (month == 2) {

            boolean leapYear = (year % 400 == 0) ||
                               (year % 4 == 0 && year % 100 != 0);

            if (leapYear && day > 29) {
                throw new InvalidDateException("Invalid date.");
            }

            if (!leapYear && day > 28) {
                throw new InvalidDateException("Invalid date.");
            }
        }

        this.day = day;
        this.month = month;
        this.year = year;
    }

    // Display date
    void display() {
        System.out.printf(
            "Date: %02d/%02d/%04d%n",
            day, month, year
        );
    }
}

// Main class
public class InvalidDateException1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter date (dd mm yyyy): ");

        int day = sc.nextInt();
        int month = sc.nextInt();
        int year = sc.nextInt();

        MyDate date = new MyDate();

        try {
            date.accept(day, month, year);
            System.out.println("Valid date.");
            date.display();
        }
        catch (InvalidDateException e) {
            System.out.println("InvalidDateException: "
                               + e.getMessage());
        }

        sc.close();
    }
}

