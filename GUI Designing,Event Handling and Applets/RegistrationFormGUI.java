import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class RegistrationFormGUI extends JFrame
        implements ActionListener {

    JTextField nameField;
    JTextField loginField;

    JPasswordField passwordField;
    JPasswordField confirmPasswordField;

    JTextField captchaAnswer;

    JLabel captchaLabel;
    JButton submitButton;

    int num1, num2;

    RegistrationFormGUI() {

        setTitle("Registration Form");
        setSize(450, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new GridLayout(7, 2, 5, 10));

        // Title
        JLabel title = new JLabel(
                "Registration Form",
                SwingConstants.CENTER
        );

        add(title);
        add(new JLabel(""));

        // Name
        add(new JLabel("Name:", SwingConstants.RIGHT));

        nameField = new JTextField();
        add(nameField);

        // Login name
        add(new JLabel("Login Name:", SwingConstants.RIGHT));

        loginField = new JTextField();
        add(loginField);

        // Password
        add(new JLabel("Password:", SwingConstants.RIGHT));

        passwordField = new JPasswordField();
        add(passwordField);

        // Confirm Password
        add(new JLabel("Confirm Password:", SwingConstants.RIGHT));

        confirmPasswordField = new JPasswordField();
        add(confirmPasswordField);

        // CAPTCHA
        add(new JLabel("Captcha:", SwingConstants.RIGHT));

        JPanel captchaPanel = new JPanel(
                new FlowLayout(FlowLayout.LEFT)
        );

        captchaLabel = new JLabel();

        captchaAnswer = new JTextField(8);

        captchaPanel.add(captchaLabel);
        captchaPanel.add(captchaAnswer);

        add(captchaPanel);

        // Generate CAPTCHA
        generateCaptcha();

        // Submit button
        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);

        add(new JLabel(""));
        add(submitButton);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Generate two 2-digit numbers
    void generateCaptcha() {

        Random random = new Random();

        num1 = 10 + random.nextInt(90);
        num2 = 10 + random.nextInt(90);

        captchaLabel.setText(
                num1 + " + " + num2 + " ="
        );
    }

    // Submit button
    public void actionPerformed(ActionEvent e) {

        String name = nameField.getText();
        String login = loginField.getText();

        String password =
                new String(passwordField.getPassword());

        String confirmPassword =
                new String(confirmPasswordField.getPassword());

        String captchaText =
                captchaAnswer.getText();

        // Password validation
        boolean hasUppercase =
                password.matches(".*[A-Z].*");

        boolean hasDigit =
                password.matches(".*[0-9].*");

        boolean hasSymbol =
                password.matches(".*[^a-zA-Z0-9].*");

        // Check password
        if (password.length() < 6 ||
            !hasUppercase ||
            !hasDigit ||
            !hasSymbol) {

            JOptionPane.showMessageDialog(
                    this,
                    "Password must contain at least 6 characters,\n"
                    + "one uppercase letter, one digit and one symbol."
            );

            return;
        }

        // Confirm password
        if (!password.equals(confirmPassword)) {

            JOptionPane.showMessageDialog(
                    this,
                    "Password and Confirm Password do not match."
            );

            return;
        }

        // CAPTCHA validation
        try {

            int answer = Integer.parseInt(captchaText);

            if (answer != num1 + num2) {

                JOptionPane.showMessageDialog(
                        this,
                        "Wrong CAPTCHA."
                );

                return;
            }

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Enter a valid CAPTCHA answer."
            );

            return;
        }

        // Check other fields
        if (name.trim().equals("") ||
            login.trim().equals("")) {

            JOptionPane.showMessageDialog(
                    this,
                    "Name and Login Name cannot be empty."
            );

            return;
        }

        // All validations successful
        JOptionPane.showMessageDialog(
                this,
                "Registration Successful"
        );
    }

    public static void main(String[] args) {

        new RegistrationFormGUI();
    }
}
