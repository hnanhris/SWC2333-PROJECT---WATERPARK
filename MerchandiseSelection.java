
/**
 * PROJECT SWC2333
 * Programme Description: To create a Merchandise Page for SUNWAY LAGOON ONLINE TICKETING SYSTEM
 * Programmer: WAN NOR ANIS ATHIRAH
 * ID Number: AM2307013899
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MerchandiseSelection extends JFrame implements ActionListener {
    private JButton checkoutButton;
    private JCheckBox keychainCheckBox, shirtCheckBox, hatCheckBox, bagCheckBox;
    private String selectedDay;
    private int qtyAdult, qtyChildren;

    public MerchandiseSelection(String selectedDay, int qtyAdult, int qtyChildren) {
        this.selectedDay = selectedDay;
        this.qtyAdult = qtyAdult;
        this.qtyChildren = qtyChildren;

        setTitle("Merchandise Selection");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));
        add(panel);

        keychainCheckBox = new JCheckBox("Keychain (RM 3)");
        shirtCheckBox = new JCheckBox("T-Shirt (RM 14)");
        hatCheckBox = new JCheckBox("Hat (RM 5)");
        bagCheckBox = new JCheckBox("Tote Bag (RM 10)");

        panel.add(keychainCheckBox);
        panel.add(shirtCheckBox);
        panel.add(hatCheckBox);
        panel.add(bagCheckBox);

        checkoutButton = new JButton("Checkout");
        checkoutButton.addActionListener(this);
        panel.add(checkoutButton);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        double totalTicketPrice = (qtyAdult * 15) + (qtyChildren * 10);
        double totalPrice = totalTicketPrice;
        String merchandise = "";

        if (keychainCheckBox.isSelected()) {
            totalPrice += 3;
            merchandise += "Keychain (RM 3)\n";
        }
        if (shirtCheckBox.isSelected()) {
            totalPrice += 14;
            merchandise += "T-Shirt (RM 14)\n";
        }
        if (hatCheckBox.isSelected()) {
            totalPrice += 5;
            merchandise += "Hat (RM 5)\n";
        }
        if (bagCheckBox.isSelected()) {
            totalPrice += 10;
            merchandise += "Tote Bag (RM 10)\n";
        }

        // Display order summary
        JOptionPane.showMessageDialog(this,
                "Selected Day: " + selectedDay +
                        "\nTotal Adult Tickets: " + qtyAdult +
                        "\nTotal Child Tickets: " + qtyChildren +
                        "\nTotal Ticket Price: RM" + totalTicketPrice +
                        "\n\nSelected Merchandise:\n" + merchandise +
                        "\nTotal Price: RM" + totalPrice,
                "Order Summary", JOptionPane.INFORMATION_MESSAGE);

        // Create receipt
        new Receipt(selectedDay, totalPrice, qtyAdult, qtyChildren, totalTicketPrice, merchandise);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MerchandiseSelection("Monday", 2, 3));
    }
}