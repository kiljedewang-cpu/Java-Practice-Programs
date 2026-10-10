import javax.swing.*;
import java.awt.*;
import java.awt.font.TextAttribute;
import java.util.Map;

public class FontGUI extends JFrame {

    JComboBox<String> fontBox;
    JComboBox<Integer> sizeBox;

    JCheckBox bold;
    JCheckBox italic;
    JCheckBox underline;

    JTextField textField;

    Font currentFont;

    FontGUI() {

        setTitle("Font and Style");
        setSize(400, 250);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Font label
        JLabel fontLabel = new JLabel("Font");
        fontLabel.setBounds(30, 20, 80, 25);
        add(fontLabel);

        // Font ComboBox
        String fonts[] = {"Arial", "Times New Roman", "Serif", "SansSerif"};

        fontBox = new JComboBox<>(fonts);
        fontBox.setBounds(30, 45, 130, 30);
        add(fontBox);

        // Size label
        JLabel sizeLabel = new JLabel("Size");
        sizeLabel.setBounds(30, 85, 80, 25);
        add(sizeLabel);

        // Size ComboBox
        Integer sizes[] = {10, 12, 14, 16, 18, 20, 24, 28};

        sizeBox = new JComboBox<>(sizes);
        sizeBox.setBounds(30, 110, 130, 30);
        add(sizeBox);

        // Style label
        JLabel styleLabel = new JLabel("Style");
        styleLabel.setBounds(200, 20, 80, 25);
        add(styleLabel);

        // Checkboxes
        bold = new JCheckBox("Bold");
        bold.setBounds(200, 45, 100, 25);
        add(bold);

        italic = new JCheckBox("Italic");
        italic.setBounds(200, 75, 100, 25);
        add(italic);

        underline = new JCheckBox("Underline");
        underline.setBounds(200, 105, 120, 25);
        add(underline);

        // Text field
        textField = new JTextField();
        textField.setBounds(30, 155, 300, 35);
        add(textField);

        // Action listeners
        fontBox.addActionListener(e -> changeFont());
        sizeBox.addActionListener(e -> changeFont());

        bold.addActionListener(e -> changeFont());
        italic.addActionListener(e -> changeFont());
        underline.addActionListener(e -> changeFont());

        setVisible(true);
    }

    // Change font of text field
    void changeFont() {

        String fontName = (String) fontBox.getSelectedItem();

        int size = (Integer) sizeBox.getSelectedItem();

        int style = Font.PLAIN;

        if (bold.isSelected()) {
            style = style | Font.BOLD;
        }

        if (italic.isSelected()) {
            style = style | Font.ITALIC;
        }

        currentFont = new Font(fontName, style, size);

        // Apply underline
        if (underline.isSelected()) {

            Map<TextAttribute, Object> attributes =
                    (Map<TextAttribute, Object>)
                    currentFont.getAttributes();

            attributes.put(
                    TextAttribute.UNDERLINE,
                    TextAttribute.UNDERLINE_ON
            );

            currentFont = currentFont.deriveFont(attributes);
        }

        textField.setFont(currentFont);
    }

    public static void main(String[] args) {

        new FontGUI();
    }
}
