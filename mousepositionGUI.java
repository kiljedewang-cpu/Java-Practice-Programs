import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class mousepositionGUI extends JFrame
        implements MouseListener, MouseMotionListener, KeyListener {

    String message = "Perform an event...";

    mousepositionGUI() {

        setTitle("Event Handling Demo");
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setBackground(Color.WHITE);

        // Add listeners
        addMouseListener(this);
        addMouseMotionListener(this);
        addKeyListener(this);

        setFocusable(true);

        setVisible(true);

        requestFocus();
    }

    // Display message in center
    public void paint(Graphics g) {

        super.paint(g);

        g.setFont(new Font("Arial", Font.BOLD, 20));

        FontMetrics fm = g.getFontMetrics();

        int x = (getWidth() - fm.stringWidth(message)) / 2;
        int y = getHeight() / 2;

        g.drawString(message, x, y);
    }

    // Mouse clicked
    public void mouseClicked(MouseEvent e) {

        message = "Mouse Clicked - Button: "
                + e.getButton();

        repaint();
    }

    // Mouse pressed
    public void mousePressed(MouseEvent e) {

        message = "Mouse Pressed - Button: "
                + e.getButton();

        repaint();
    }

    // Mouse released
    public void mouseReleased(MouseEvent e) {

        message = "Mouse Released - Button: "
                + e.getButton();

        repaint();
    }

    // Mouse entered
    public void mouseEntered(MouseEvent e) {

        message = "Mouse Entered";

        repaint();
    }

    // Mouse exited
    public void mouseExited(MouseEvent e) {

        message = "Mouse Exited";

        repaint();
    }

    // Mouse moved
    public void mouseMoved(MouseEvent e) {

        message = "Mouse Moved - X: "
                + e.getX() + " Y: " + e.getY();

        repaint();
    }
    // Mouse dragged
    public void mouseDragged(MouseEvent e) {

        message = "Mouse Dragged - X: "
                + e.getX() + " Y: " + e.getY();

        repaint();
    }

    // Key pressed
    public void keyPressed(KeyEvent e) {

        message = "Key Pressed: "
                + e.getKeyChar();

        repaint();
    }

    // Required KeyListener methods
    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }

    public static void main(String[] args) {

        new mousepositionGUI();
    }
}

