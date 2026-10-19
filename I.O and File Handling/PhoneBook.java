import java.io.*;
import java.util.Scanner;

public class PhoneBook {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n--- PHONE BOOK ---");
            System.out.println("1. Search name");
            System.out.println("2. Add new name and phone number");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // clear newline

            try {

                // Search name
                if (choice == 1) {

                    System.out.print("Enter name to search: ");
                    String searchName = sc.nextLine();

                    File file = new File("phone.txt");

                    if (!file.exists()) {
                        System.out.println("phone.txt does not exist.");
                        continue;
                    }

                    BufferedReader br = new BufferedReader(
                        new FileReader(file)
                    );

                    String line;
                    boolean found = false;

                    while ((line = br.readLine()) != null) {

                        String[] data = line.split(",");

                        if (data.length == 2 &&
                            data[0].equalsIgnoreCase(searchName)) {

                            System.out.println(
                                "Phone Number: " + data[1]
                            );

                            found = true;
                            break;
                        }
                    }

                    br.close();

                    if (!found) {
                        System.out.println("Name not found.");
                    }
                }

                // Add new name and phone number
                else if (choice == 2) {

                    System.out.print("Enter name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter phone number: ");
                    String phone = sc.nextLine();

                    FileWriter fw = new FileWriter("phone.txt", true);
                    BufferedWriter bw = new BufferedWriter(fw);

                    bw.write(name + "," + phone);
                    bw.newLine();

                    bw.close();

                    System.out.println("Name and phone number added.");
                }

                // Exit
                else if (choice == 3) {

                    System.out.println("Program ended.");
                    break;
                }

                else {
                    System.out.println("Invalid choice.");
                }

            }
            catch (IOException e) {
                System.out.println("File error: " + e.getMessage());
            }
        }

        sc.close();
    }
}
