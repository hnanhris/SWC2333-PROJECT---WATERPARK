
/**
 * PROJECT SWC2333
 * Programme Description: To create a script selection page for SUNWAY LAGOON ONLINE TICKETING SYSTEM
 * Programmer: HANAN HARISANUAR
 * Id Number: AM2307013920
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Receipt extends JFrame implements ActionListener {
    private String selectedDay;
    private int qtyAdult;
    private int qtyChildren;
    private String merchandise;
    private double totalTicketPrice;
    private double totalPrice;

    public Receipt(String selectedDay, double totalPrice, int qtyAdult, int qtyChildren, double totalTicketPrice, String merchandise) {
        this.selectedDay = selectedDay;
        this.totalPrice = totalPrice;
        this.qtyAdult = qtyAdult;
        this.qtyChildren = qtyChildren;
        this.totalTicketPrice = totalTicketPrice;
        this.merchandise = merchandise;

        // Create receipt frame
        setTitle("Receipt");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create Panel
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        add(panel);

        // Create Label
        JLabel label = new JLabel(new ImageIcon("ticket.png"));
        panel.add(label, BorderLayout.NORTH);

        // Create receipt text area
        JTextArea receiptTextArea = new JTextArea("Day: " + selectedDay +
                "\nTotal Adult Tickets: " + qtyAdult +
                "\nTotal Child Tickets: " + qtyChildren +
                "\nTotal Ticket Price: RM" + totalTicketPrice +
                "\nMerchandise Selected:\n" + merchandise +
                "\nTotal Price : RM" + totalPrice);

        receiptTextArea.setEditable(true);
        receiptTextArea.setEditable(false);
        receiptTextArea.setBackground(Color.WHITE);
        receiptTextArea.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(receiptTextArea, BorderLayout.CENTER);

        receiptTextArea.append(String.format(" \n\n\n "));
        receiptTextArea.append(String.format(" [ Thank you and have a nice day <333 ] "));
        receiptTextArea.append(String.format(" \n\n "));
        receiptTextArea.append(String.format(" => Enjoy Your Day! <= "));

        // Create close button
        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(this);

        panel.add(closeButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        // Close the receipt window
        dispose();
    }
}