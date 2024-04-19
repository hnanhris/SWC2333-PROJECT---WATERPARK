
/**
 * PROJECT SWC2333
 * Programme Description: To create a package selection page for SUNWAY LAGOON ONLINE TICKETING SYSTEM
 * Programmer: WAN NUR ADILA
 * ID Number: AM2307013897
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicketSelection extends JFrame implements ActionListener
 {
    private JFrame frame;
    private JComboBox<String> packagesBox;
    private JRadioButton[] radioDays;
    private JCheckBox chkAdult, chkChild;
    private JButton nextButton;
    private String selectedDay = "";
    private int qtyAdult = 0, qtyChildren = 0;

    public TicketSelection() 
    {
        frame = new JFrame("Ticket Selection");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(520, 350);
        frame.setLayout(new BorderLayout());

        JPanel panelDays = createDaysPanel();
        frame.add(panelDays, BorderLayout.NORTH);

        JPanel panelTicket = createTicketPanel();
        frame.add(panelTicket, BorderLayout.CENTER);

        nextButton = new JButton("Next");
        nextButton.addActionListener(this);
        frame.add(nextButton, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private JPanel createDaysPanel() 
    {
        JPanel panel = new JPanel(new GridLayout(6, 10));
        radioDays = new JRadioButton[7];
        ButtonGroup groupDays = new ButtonGroup();
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        for (int i = 0; i < 7; i++) 
        {
            radioDays[i] = new JRadioButton(days[i]);
            radioDays[i].addActionListener(this);
            groupDays.add(radioDays[i]);
            panel.add(radioDays[i]);
        }
        panel.setBorder(BorderFactory.createTitledBorder("Choose Days"));
        return panel;
    }

    private JPanel createTicketPanel() 
    {
        JPanel panel = new JPanel();
        chkAdult = new JCheckBox("Adult Ticket (RM 15)");
        chkChild = new JCheckBox("Child Ticket (RM 10)");
        chkAdult.addActionListener(this);
        chkChild.addActionListener(this);
        panel.add(chkAdult);
        panel.add(chkChild);
        panel.setBorder(BorderFactory.createTitledBorder("Choose Tickets"));
        return panel;
    }

    public void actionPerformed(ActionEvent e)
    {
        for (int i = 0; i < 7; i++)
        {
            if (e.getSource() == radioDays[i])
            {
                selectedDay = radioDays[i].getText();
                break;
            }
        }

        if (e.getSource() == nextButton) 
        {
            if (chkAdult.isSelected()) 
            {
                qtyAdult = Integer.parseInt(JOptionPane.showInputDialog("How many ADULT tickets?"));
            }
            if (chkChild.isSelected()) 
            {
                qtyChildren = Integer.parseInt(JOptionPane.showInputDialog("How many CHILD tickets?"));
            }

            frame.dispose();
            new MerchandiseSelection(selectedDay, qtyAdult, qtyChildren);
        }
    }

    public static void main(String[] args) 
    {
        new TicketSelection();
    }
}//end of class