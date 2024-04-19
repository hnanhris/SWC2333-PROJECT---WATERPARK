
/**
 * PROJECT SWC2333
 * Programme Description: To create a welcome page for SUNWAY LAGOON ONLINE TICKETING SYSTEM
 * Programmer: Iqbal
 * ID Number: AM2307013960
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WelcomePage extends JFrame implements ActionListener {
    JButton startButton;

    public WelcomePage() {
        setTitle("Welcome to Sunway Lagoon Ticketing System");
        setSize(500, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        ImageIcon logo = new ImageIcon("SUNWAY LAGOON.png");
        JLabel logoLabel = new JLabel(logo);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        add(panel);

        startButton = new JButton("Start");
        startButton.addActionListener(this);

        panel.add(startButton, BorderLayout.SOUTH);
        setVisible(true);
        panel.add(logoLabel);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            dispose();
            new PackageSelection();
        }
    }

    public static void main(String[] args) {
        WelcomePage wp = new WelcomePage();
    }
}