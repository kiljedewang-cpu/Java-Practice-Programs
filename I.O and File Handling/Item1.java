import java.io.*;
import java.util.Scanner;

class Item {
    int id;
    String name;
    double price;
    int qty;

    Item(int id, String name, double price, int qty) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.qty = qty;
    }

    void display() {
        System.out.println(
            id + "\t" + name + "\t" + price + "\t" + qty
        );
    }
}

public class Item1 {

    static final String FILE = "item.dat";

    // Write items into file
    static void createFile() {

        Scanner sc = new Scanner(System.in);

        try {
            RandomAccessFile raf =
                new RandomAccessFile(FILE, "rw");

            System.out.print("Enter number of items: ");
            int n = sc.nextInt();
            sc.nextLine();

            for (int i = 0; i < n; i++) {

                System.out.println("\nEnter Item " + (i + 1));

                System.out.print("ID: ");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.print("Name: ");
                String name = sc.nextLine();

                System.out.print("Price: ");
                double price = sc.nextDouble();

                System.out.print("Quantity: ");
                int qty = sc.nextInt();
                sc.nextLine();

                raf.writeInt(id);
                raf.writeUTF(name);
                raf.writeDouble(price);
                raf.writeInt(qty);
            }

            raf.close();

        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
        sc.close();
    }

    // Search item by name
    static void searchItem(String searchName) {

        try {
            RandomAccessFile raf =
                new RandomAccessFile(FILE, "r");

            boolean found = false;

            while (raf.getFilePointer() < raf.length()) {

                int id = raf.readInt();
                String name = raf.readUTF();
                double price = raf.readDouble();
                int qty = raf.readInt();

                if (name.equalsIgnoreCase(searchName)) {

                    System.out.println("\nItem Found:");
                    System.out.println("ID       : " + id);
                    System.out.println("Name     : " + name);
                    System.out.println("Price    : " + price);
                    System.out.println("Quantity : " + qty);

                    found = true;
                    break;
                }
            }

            raf.close();

            if (!found) {
                System.out.println("Item not found.");
            }

        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }

    // Find costliest item
    static void costliestItem() {

        try {
            RandomAccessFile raf =
                new RandomAccessFile(FILE, "r");

            double maxPrice = -1;
            Item costly = null;

            while (raf.getFilePointer() < raf.length()) {

                int id = raf.readInt();
                String name = raf.readUTF();
                double price = raf.readDouble();
                int qty = raf.readInt();

                if (price > maxPrice) {
                    maxPrice = price;
                    costly = new Item(id, name, price, qty);
                }
            }

            raf.close();

            if (costly != null) {
                System.out.println("\nCostliest Item:");
                costly.display();
            }

        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }

    // Display all items and total cost
    static void displayAll() {

        try {
            RandomAccessFile raf =
                new RandomAccessFile(FILE, "r");

            double totalCost = 0;

            System.out.println("\nID\tName\tPrice\tQuantity");

            while (raf.getFilePointer() < raf.length()) {

                int id = raf.readInt();
                String name = raf.readUTF();
                double price = raf.readDouble();
                int qty = raf.readInt();

                System.out.println(
                    id + "\t" + name + "\t" +
                    price + "\t" + qty
                );

                totalCost = totalCost + (price * qty);
            }

            raf.close();

            System.out.println("\nTotal Cost = Rs." + totalCost);

        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Create item.dat
        createFile();

        while (true) {

            System.out.println("\n===== ITEM MENU =====");
            System.out.println("1. Search item by name");
            System.out.println("2. Find costliest item");
            System.out.println("3. Display all items and total cost");
            System.out.println("4. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter item name: ");
                    String name = sc.nextLine();
                    searchItem(name);
                    break;

                case 2:
                    costliestItem();
                    break;

                case 3:
                    displayAll();
                    break;

                case 4:
                    System.out.println("Program ended.");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
