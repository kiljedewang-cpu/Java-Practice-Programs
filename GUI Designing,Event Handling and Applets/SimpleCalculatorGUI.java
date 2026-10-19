import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleCalculatorGUI extends JFrame
        implements ActionListener {

    JTextField display;

    double num1 = 0;
    double num2 = 0;
    char operator = ' ';

    String[] buttons = {
        "1", "2", "3", "+",
        "4", "5", "6", "-",
        "7", "8", "9", "*",
        "0", ".", "=", "/"
    };

    SimpleCalculatorGUI() {

        setTitle("Simple Calculator");
        setSize(350, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout(10, 10));

        // Display
        display = new JTextField();
        display.setFont(new Font("Arial", Font.BOLD, 25));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);

        add(display, BorderLayout.NORTH);

        // Button panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 8, 8));

        for (String text : buttons) {

            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.BOLD, 20));

            button.addActionListener(this);

            panel.add(button);
        }

        add(panel, BorderLayout.CENTER);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String value = e.getActionCommand();

        // Number or decimal point
        if (value.matches("[0-9]") || value.equals(".")) {

            // Don't allow more than one decimal point
            if (value.equals(".") &&
                display.getText().contains(".")) {
                return;
            }

            display.setText(display.getText() + value);
        }

        // Operators
        else if (value.equals("+") ||
                 value.equals("-") ||
                 value.equals("*") ||
                 value.equals("/")) {

            if (display.getText().isEmpty()) {
                display.setText("Enter number");
                return;
            }

            try {
                num1 = Double.parseDouble(display.getText());
                operator = value.charAt(0);

                display.setText("");
            }
            catch (NumberFormatException ex) {
                display.setText("Invalid number");
            }
        }

        // Equal
        else if (value.equals("=")) {

            if (display.getText().isEmpty() || operator == ' ') {
                display.setText("Invalid operation");
                return;
            }

            try {

                num2 = Double.parseDouble(display.getText());

                double result = 0;

                switch (operator) {

                    case '+':
                        result = num1 + num2;
                        break;

                    case '-':
                        result = num1 - num2;
                        break;

                    case '*':
                        result = num1 * num2;
                        break;

                    case '/':

                        // Validation for division by zero
                        if (num2 == 0) {
                            display.setText("Cannot divide by zero");
                            return;
                        }

                        result = num1 / num2;
                        break;
                }

                // Display result
                display.setText(String.valueOf(result));

                operator = ' ';

            }
            catch (NumberFormatException ex) {

                display.setText("Invalid number");
            }
        }
    }

    public static void main(String[] args) {

        new SimpleCalculatorGUI();
    }
}
