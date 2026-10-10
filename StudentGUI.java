import javax.swing.*;
import java.awt.*;

public class StudentGUI extends JFrame {

    JTextField nameField;
    JRadioButton fy, sy, ty;
    JCheckBox music, dance, sports;
    JTextField resultField;

    StudentGUI() {

        setTitle("Student Information");
        setSize(450, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10));

        // Name panel
        JPanel namePanel = new JPanel(new FlowLayout());

        JLabel nameLabel = new JLabel("Your Name :");
        nameField = new JTextField(15);

        namePanel.add(nameLabel);
        namePanel.add(nameField);

        mainPanel.add(namePanel, BorderLayout.NORTH);

        // Center panel
        JPanel centerPanel = new JPanel(new GridLayout(1, 2));

        // Class panel
        JPanel classPanel = new JPanel();
        classPanel.setLayout(new BoxLayout(classPanel, BoxLayout.Y_AXIS));

        classPanel.setBorder(
            BorderFactory.createTitledBorder("Your Class")
        );

        fy = new JRadioButton("FY");
        sy = new JRadioButton("SY");
        ty = new JRadioButton("TY");

        // ButtonGroup allows only one class
        ButtonGroup classGroup = new ButtonGroup();

        classGroup.add(fy);
        classGroup.add(sy);
        classGroup.add(ty);

        classPanel.add(fy);
        classPanel.add(sy);
        classPanel.add(ty);

        // Hobbies panel
        JPanel hobbyPanel = new JPanel();
        hobbyPanel.setLayout(new BoxLayout(hobbyPanel, BoxLayout.Y_AXIS));

        hobbyPanel.setBorder(
            BorderFactory.createTitledBorder("Your Hobbies")
        );

        music = new JCheckBox("Music");
        dance = new JCheckBox("Dance");
        sports = new JCheckBox("Sports");

        hobbyPanel.add(music);
        hobbyPanel.add(dance);
        hobbyPanel.add(sports);

        centerPanel.add(classPanel);
        centerPanel.add(hobbyPanel);

        mainPanel.add(centerPanel, BorderLayout.CENTER);

        // Result field
        resultField = new JTextField();
        resultField.setEditable(false);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBorder(
            BorderFactory.createTitledBorder("Selected Information")
        );

        bottomPanel.add(resultField, BorderLayout.CENTER);

        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        // Add listeners
        nameField.addActionListener(e -> displayData());

        fy.addActionListener(e -> displayData());
        sy.addActionListener(e -> displayData());
        ty.addActionListener(e -> displayData());

        music.addActionListener(e -> displayData());
        dance.addActionListener(e -> displayData());
        sports.addActionListener(e -> displayData());

        add(mainPanel);

        setVisible(true);
    }

    // Display selected options
    void displayData() {

        String name = nameField.getText();

        String className = "";

        if (fy.isSelected()) {
            className = "FY";
        }
        else if (sy.isSelected()) {
            className = "SY";
        }
        else if (ty.isSelected()) {
            className = "TY";
        }

        String hobbies = "";

        if (music.isSelected()) {
            hobbies += "Music ";
        }

        if (dance.isSelected()) {
            hobbies += "Dance ";
        }

        if (sports.isSelected()) {
            hobbies += "Sports ";
        }

        resultField.setText(
            "Name: " + name +
            ", Class: " + className +
            ", Hobbies: " + hobbies
        );
    }

    public static void main(String[] args) {
        new StudentGUI();
    }
}
