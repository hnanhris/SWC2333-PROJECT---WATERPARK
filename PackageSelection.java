
/**
 * PROJECT SWC2333
 * Programme Description: To create a package selection page for SUNWAY LAGOON ONLINE TICKETING SYSTEM
 * Programmer: ZAINAB 
 * ID Number: AM2307014
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.ActionListener;

public class PackageSelection implements ActionListener 
{
    private JFrame frame;
    private JCheckBox chkBasic, chkPremium, chkVIP;
    private JButton btnNext;
    int qtyBasic = 0, qtyPremium = 0, qtyVIP = 0;

    public PackageSelection() {
        chkBasic = new JCheckBox("Basic Package (Access all rides) - RM100");
        chkPremium = new JCheckBox("Premium Package (Access all rides + Fast pass) - RM200");
        chkVIP = new JCheckBox("VIP Package (Access all rides + Fast pass + Private cabana) - RM300");

        JPanel panelTicket = new JPanel(new GridLayout(3, 1));
        panelTicket.setBorder(BorderFactory.createTitledBorder("Choose TICKET"));
        panelTicket.add(chkBasic);
        panelTicket.add(chkPremium);
        panelTicket.add(chkVIP);

        btnNext = new JButton("NEXT");

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(btnNext);

        frame = new JFrame("Package Selection");
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(520, 300);
        frame.add(panelTicket, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        btnNext.addActionListener(this);
        chkBasic.addActionListener(this);
        chkPremium.addActionListener(this);
        chkVIP.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) 
    {
    if (e.getSource() == btnNext) {
        String selectedPackages = "";

        if (chkBasic.isSelected()) {
            selectedPackages += "Basic Package (" + qtyBasic + " tickets) - RM100\n";
        }
        if (chkPremium.isSelected()) {
            selectedPackages += "Premium Package (" + qtyPremium + " tickets) - RM200\n";
        }
        if (chkVIP.isSelected()) {
            selectedPackages += "VIP Package (" + qtyVIP + " tickets) - RM300\n";
        }

        // Calculate total price based on the selected packages
        double totalPrice = calculateTotalPrice();
        
        new TicketSelection();
        frame.dispose();
        
    }
    }

    private double calculateTotalPrice() 
    {
    double totalPrice = 0.0;
    if (chkBasic.isSelected()) {
        totalPrice += qtyBasic * 100;
    }
    if (chkPremium.isSelected()) {
        totalPrice += qtyPremium * 200;
    }
    if (chkVIP.isSelected()) {
        totalPrice += qtyVIP * 300;
    }
    return totalPrice;
   }


public static void main(String[] args) 
{
    SwingUtilities.invokeLater(() -> new PackageSelection());
}
}