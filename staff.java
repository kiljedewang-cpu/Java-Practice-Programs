import java.util.Scanner;

// Abstract class
abstract class Staff {
    String name;
    String address;

    Staff(String name, String address) {
        this.name = name;
        this.address = address;
    }

    abstract void display();
}

// Full-time staff
class FullTimeStaff extends Staff {
    String department;
    double salary;

    FullTimeStaff(String name, String address,
                  String department, double salary) {

        super(name, address);
        this.department = department;
        this.salary = salary;
    }

    void display() {
        System.out.println("Name       : " + name);
        System.out.println("Address    : " + address);
        System.out.println("Department : " + department);
        System.out.println("Salary     : " + salary);
        System.out.println();
    }
}

// Part-time staff
class PartTimeStaff extends Staff {
    int numberOfHours;
    double ratePerHour;

    PartTimeStaff(String name, String address,
                  int numberOfHours, double ratePerHour) {

        super(name, address);
        this.numberOfHours = numberOfHours;
        this.ratePerHour = ratePerHour;
    }

    void display() {
        System.out.println("Name          : " + name);
        System.out.println("Address       : " + address);
        System.out.println("Number Hours  : " + numberOfHours);
        System.out.println("Rate Per Hour : " + ratePerHour);
        System.out.println();
    }
}

// Main class
public class staff {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of staff: ");
        int n = sc.nextInt();
        sc.nextLine();

        Staff[] staff = new Staff[n];

        // Create objects
        for (int i = 0; i < n; i++) {

            System.out.println("\nStaff " + (i + 1));
            System.out.println("1. Full-Time Staff");
            System.out.println("2. Part-Time Staff");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter name: ");
            String name = sc.nextLine();

            System.out.print("Enter address: ");
            String address = sc.nextLine();

            if (choice == 1) {

                System.out.print("Enter department: ");
                String department = sc.nextLine();

                System.out.print("Enter salary: ");
                double salary = sc.nextDouble();
                sc.nextLine();

                staff[i] = new FullTimeStaff(
                    name, address, department, salary
                );

            }
            else if (choice == 2) {

                System.out.print("Enter number of hours: ");
                int hours = sc.nextInt();

                System.out.print("Enter rate per hour: ");
                double rate = sc.nextDouble();
                sc.nextLine();

                staff[i] = new PartTimeStaff(
                    name, address, hours, rate
                );

            }
            else {
                System.out.println("Invalid choice.");
                i--;
            }
        }

        // Display Full-Time Staff
        System.out.println("\n===== FULL-TIME STAFF =====");

        for (int i = 0; i < n; i++) {

            if (staff[i] instanceof FullTimeStaff) {
                staff[i].display();
            }
        }

        // Display Part-Time Staff
        System.out.println("===== PART-TIME STAFF =====");

        for (int i = 0; i < n; i++) {

            if (staff[i] instanceof PartTimeStaff) {
                staff[i].display();
            }
        }

        sc.close();
    }
}
