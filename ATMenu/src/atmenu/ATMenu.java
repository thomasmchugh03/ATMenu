package atmenu;

import java.awt.*;
import java.awt.event.*;
import java.util.InputMismatchException;
import javax.swing.*;

/**
 * Write a description of class StudentMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ATMenu 
{
    // User interface data
    JButton [] m;
    JLabel capAmount;
    JTextField txtAmount;
    JRadioButton sv, ch;
    ButtonGroup group;

    PIN myPin;
    BankAccount save, check, current;

    // Student data
    // YOUR DECLARATIONS GO HERE

    /**
     * Constructor for objects of class Menu
     */
    public ATMenu ()   {
        // ATM data

        save = new BankAccount("Bruce Wayne");
        check = new BankAccount(1000, "Clark Kent");

        // Create the user interface
        JFrame f;
        JPanel p;
        ButtonGroup g;
        String [] actions = {"Deposit", "Withdraw", "Check Balance"};
        f = new JFrame("ATM");
        p = new JPanel(new GridLayout(6,2));
        capAmount = new JLabel("Amount");
        txtAmount = new JTextField(8);
        ch = new JRadioButton("Checking");
        sv = new JRadioButton("Savings");
        group = new ButtonGroup();
        group.add(ch);
        group.add(sv);

        p.add(capAmount);
        p.add(txtAmount);
        p.add(ch);
        p.add(sv);
        // Buttons
        m = new JButton[actions.length];
        ButtonListener bl = new ButtonListener();
        int i = 0;
        for (String d: actions) 
        {
            m[i] = new JButton(d);
            m[i].addActionListener(bl);

            p.add(m[i++]);
        }
        RadioButtonListener rbl = new RadioButtonListener();
        ch.addActionListener(rbl);
        sv.addActionListener(rbl);
        f.getContentPane().add(p);
        f.pack();
        f.show();

    }
    
    private class ButtonListener implements ActionListener 
    {
        public void actionPerformed(ActionEvent event) 
        {
            JButton b = (JButton)event.getSource();
            double amount = 0;

            // get the dollar amount that the user wants to withdraw or deposit
            String text = txtAmount.getText();
            try
            {
                if (text.length() != 0) 
                {
                    amount = Double.parseDouble(txtAmount.getText());
                } 
            }
            catch(NumberFormatException e)
            {
                txtAmount.setText("Not a valid input");
            }
            
            if (b == m[0]) 
            { // User clicked the Deposit button
                current.deposit(amount);
            } 
            else if (b == m[1]) 
            { //User clicked the Withdraw button
                current.withdraw(amount);
            } 
            else if (b == m[2]) 
            { //User clicked the Check Balance button
                String str_amount = String.valueOf(current.getBalance());
                txtAmount.setText(str_amount);
            }
        }
    }

    private class RadioButtonListener implements ActionListener 
    {
        public void actionPerformed(ActionEvent event) 
        {
            JRadioButton b = (JRadioButton)event.getSource();
            if (sv.isSelected()) 
            {
                // Savings button
                current = save;
            } 
            else if (ch.isSelected()) 
            {
                // Checking button
                current = check;
            }

        }
    }
    
    public static void main(String[] args)
    {
        ATMenu frame = new ATMenu();
    }
}