import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;

public class NumberOperationsGUI extends JFrame {

    ArrayList<Integer> numbers = new ArrayList<>();
    JTextArea textArea;

    NumberOperationsGUI() {

        setTitle("Number Operations");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Text area for displaying numbers
        textArea = new JTextArea();
        textArea.setFont(new Font("Arial", Font.PLAIN, 16));
        textArea.setEditable(false);

        add(new JScrollPane(textArea), BorderLayout.CENTER);

        createMenuBar();

        setVisible(true);
    }

    // Create menu bar
    void createMenuBar() {

        JMenuBar menuBar = new JMenuBar();

        // ---------------- File Menu ----------------
        JMenu fileMenu = new JMenu("File");

        JMenuItem load = new JMenuItem("Load");
        JMenuItem save = new JMenuItem("Save");
        JMenuItem exit = new JMenuItem("Exit");

        fileMenu.add(load);
        fileMenu.add(save);
        fileMenu.addSeparator();
        fileMenu.add(exit);

        // ---------------- Compute Menu ----------------
        JMenu computeMenu = new JMenu("Compute");

        JMenuItem sum = new JMenuItem("Sum");
        JMenuItem average = new JMenuItem("Average");
        JMenuItem maximum = new JMenuItem("Maximum");
        JMenuItem minimum = new JMenuItem("Minimum");
        JMenuItem median = new JMenuItem("Median");

        computeMenu.add(sum);
        computeMenu.add(average);
        computeMenu.add(maximum);
        computeMenu.add(minimum);
        computeMenu.add(median);

        // ---------------- Operations Menu ----------------
        JMenu operationsMenu = new JMenu("Operations");

        JMenuItem search = new JMenuItem("Search");

        JMenu sortMenu = new JMenu("Sort");

        JMenuItem ascending = new JMenuItem("Ascending");
        JMenuItem descending = new JMenuItem("Descending");

        sortMenu.add(ascending);
        sortMenu.add(descending);

        operationsMenu.add(search);
        operationsMenu.add(sortMenu);

        // Add menus
        menuBar.add(fileMenu);
        menuBar.add(computeMenu);
        menuBar.add(operationsMenu);

        setJMenuBar(menuBar);

        // Action listeners

        load.addActionListener(e -> loadNumbers());

        save.addActionListener(e -> saveNumbers());

        exit.addActionListener(e -> System.exit(0));

        sum.addActionListener(e -> calculateSum());

        average.addActionListener(e -> calculateAverage());

        maximum.addActionListener(e -> calculateMaximum());

        minimum.addActionListener(e -> calculateMinimum());

        median.addActionListener(e -> calculateMedian());

        search.addActionListener(e -> searchNumber());

        ascending.addActionListener(e -> sortAscending());

        descending.addActionListener(e -> sortDescending());
    }

    // Generate 50 random two-digit numbers
    void loadNumbers() {

        numbers.clear();

        Random random = new Random();

        for (int i = 0; i < 50; i++) {

            int number = 10 + random.nextInt(90);

            numbers.add(number);
        }

        displayNumbers();

        JOptionPane.showMessageDialog(
            this,
            "50 random numbers generated."
        );
    }

    // Display numbers
    void displayNumbers() {

        textArea.setText("");

        for (int number : numbers) {
            textArea.append(number + "  ");
        }
    }

    // Save numbers to file
    void saveNumbers() {

        if (numbers.isEmpty()) {

            JOptionPane.showMessageDialog(
                this,
                "Please Load numbers first."
            );

            return;
        }

        try {

            FileWriter writer =
                new FileWriter("numbers.txt");

            for (int number : numbers) {
                writer.write(number + " ");
            }

            writer.close();

            JOptionPane.showMessageDialog(
                this,
                "Numbers saved to numbers.txt"
            );

        }
        catch (IOException e) {

            JOptionPane.showMessageDialog(
                this,
                "Error while saving file."
            );
        }
    }

    // Calculate sum
    void calculateSum() {

        if (numbers.isEmpty()) {
            showNoNumbers();
            return;
        }

        int sum = 0;

        for (int number : numbers) {
            sum += number;
        }

        JOptionPane.showMessageDialog(
            this,
            "Sum = " + sum
        );
    }

    // Calculate average
    void calculateAverage() {

        if (numbers.isEmpty()) {
            showNoNumbers();
            return;
        }

        int sum = 0;

        for (int number : numbers) {
            sum += number;
        }

        double average =
            (double) sum / numbers.size();

        JOptionPane.showMessageDialog(
            this,
            "Average = " + average
        );
    }

    // Find maximum
    void calculateMaximum() {

        if (numbers.isEmpty()) {
            showNoNumbers();
            return;
        }

        int max = Collections.max(numbers);

        JOptionPane.showMessageDialog(
            this,
            "Maximum = " + max
        );
    }

    // Find minimum
    void calculateMinimum() {

        if (numbers.isEmpty()) {
            showNoNumbers();
            return;
        }

        int min = Collections.min(numbers);

        JOptionPane.showMessageDialog(
            this,
            "Minimum = " + min
        );
    }

    // Calculate median
    void calculateMedian() {

        if (numbers.isEmpty()) {
            showNoNumbers();
            return;
        }

        ArrayList<Integer> temp =
            new ArrayList<>(numbers);

        Collections.sort(temp);

        double median;

        int n = temp.size();

        if (n % 2 == 0) {

            median =
                (temp.get(n / 2 - 1)
                + temp.get(n / 2)) / 2.0;

        }
        else {

            median = temp.get(n / 2);
        }

        JOptionPane.showMessageDialog(
            this,
            "Median = " + median
        );
    }

    // Search number
    void searchNumber() {

        if (numbers.isEmpty()) {
            showNoNumbers();
            return;
        }

        String input = JOptionPane.showInputDialog(
            this,
            "Enter number to search:"
        );

        if (input == null) {
            return;
        }

        try {

            int search = Integer.parseInt(input);

            if (numbers.contains(search)) {

                JOptionPane.showMessageDialog(
                    this,
                    search + " is found."
                );

            }
            else {

                JOptionPane.showMessageDialog(
                    this,
                    search + " is not found."
                );
            }

        }
        catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                this,
                "Please enter a valid number."
            );
        }
    }

    // Sort ascending
    void sortAscending() {

        if (numbers.isEmpty()) {
            showNoNumbers();
            return;
        }

        Collections.sort(numbers);

        displayNumbers();
    }

    // Sort descending
    void sortDescending() {

        if (numbers.isEmpty()) {
            showNoNumbers();
            return;
        }

        Collections.sort(numbers, Collections.reverseOrder());

        displayNumbers();
    }

    // No numbers message
    void showNoNumbers() {

        JOptionPane.showMessageDialog(
            this,
            "Please select File → Load first."
        );
    }

    public static void main(String[] args) {

        new NumberOperationsGUI();
    }
}
