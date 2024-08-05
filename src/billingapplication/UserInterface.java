package billingapplication;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import javax.swing.*;
import javax.swing.border.*;

public class UserInterface extends JFrame {

    public JPanel homePanel = new JPanel();
    public JLabel title = new JLabel();
    public JButton createBill, updateMenu, displayRevenue, displayCustomers;
    public ImageIcon billgif, menugif, revenuegif, customergif;
    public Image img, scaledImg;

    public JLabel billLabel, menuLabel, revenueLabel, customerLabel;

    private void createHomePanel() {

        title.setText("Bill Counter");
        title.setForeground(new Color(24, 46, 87));
        title.setFont(new Font("San Serif", 1, 24));
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setVerticalAlignment(JLabel.CENTER);
        title.setBounds(300, 10, 200, 30);

        //Create Bill
        billgif = new ImageIcon("src/billingapplication/images/bill.gif");
        img = billgif.getImage();
        scaledImg = img.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        billgif = new ImageIcon(scaledImg);
        billLabel = new JLabel(billgif);
        billLabel.setBounds(275, 100, 50, 50);
        billLabel.setBorder(new LineBorder(new Color(52, 69, 97), 2));
        billLabel.setBackground(new Color(128, 191, 183, 255));

        createBill = new JButton();
        createBill.setText("Calculate Bill");
        createBill.setFont(new Font("San Serif", 1, 16));
        createBill.setBackground(new Color(52, 69, 97));
        createBill.setForeground(new Color(193, 213, 245));
        createBill.setBounds(325, 100, 200, 50);
        createBill.setBorder(new LineBorder(new Color(52, 69, 97), 2, true));
        createBill.setFocusPainted(false);

        //Update Menu List

        menugif = new ImageIcon("src/billingapplication/images/menu.gif");
        img = menugif.getImage();
        scaledImg = img.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        menugif = new ImageIcon(scaledImg);
        menuLabel = new JLabel(menugif);
        menuLabel.setBounds(275, 200, 50, 50);
        menuLabel.setBorder(new LineBorder(new Color(52, 69, 97), 2));
        menuLabel.setBackground(new Color(128, 191, 183, 255));

        updateMenu = new JButton();
        updateMenu.setText("Update menu");
        updateMenu.setFont(new Font("San Serif", 1, 16));
        updateMenu.setBackground(new Color(52, 69, 97));
        updateMenu.setForeground(new Color(193, 213, 245));
        updateMenu.setBounds(325, 200, 200, 50);
        updateMenu.setBorder(new LineBorder(new Color(52, 69, 97), 2, true));
        updateMenu.setFocusPainted(false);

        //display Revenue
        revenuegif = new ImageIcon("src/billingapplication/images/revenue.gif");
        img = revenuegif.getImage();
        scaledImg = img.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        revenuegif = new ImageIcon(scaledImg);
        revenueLabel = new JLabel(revenuegif);
        revenueLabel.setBounds(275, 300, 50, 50);
        revenueLabel.setBorder(new LineBorder(new Color(52, 69, 97), 2));
        revenueLabel.setBackground(new Color(128, 191, 183, 255));

        displayRevenue = new JButton();
        displayRevenue.setText("Display Revenue");
        displayRevenue.setFont(new Font("San Serif", 1, 16));
        displayRevenue.setBackground(new Color(52, 69, 97));
        displayRevenue.setForeground(new Color(193, 213, 245));
        displayRevenue.setBounds(325, 300, 200, 50);
        displayRevenue.setBorder(new LineBorder(new Color(52, 69, 97), 2, true));
        displayRevenue.setFocusPainted(false);

        //display Customers
        customergif = new ImageIcon("src/billingapplication/images/customer.gif");
        img = customergif.getImage();
        scaledImg = img.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        customergif = new ImageIcon(scaledImg);
        customerLabel = new JLabel(customergif);
        customerLabel.setBounds(275, 400, 50, 50);
        customerLabel.setBorder(new LineBorder(new Color(52, 69, 97), 2));
        customerLabel.setBackground(new Color(128, 191, 183, 255));

        displayCustomers = new JButton();
        displayCustomers.setText("Display Customers");
        displayCustomers.setFont(new Font("San Serif", 1, 16));
        displayCustomers.setBackground(new Color(52, 69, 97));
        displayCustomers.setForeground(new Color(193, 213, 245));
        displayCustomers.setBounds(325, 400, 200, 50);
        displayCustomers.setBorder(new LineBorder(new Color(52, 69, 97), 2, true));
        displayCustomers.setFocusPainted(false);

        homePanel.add(title);
        homePanel.add(billLabel);
        homePanel.add(createBill);
        homePanel.add(menuLabel);
        homePanel.add(updateMenu);
        homePanel.add(revenueLabel);
        homePanel.add(displayRevenue);
        homePanel.add(customerLabel);
        homePanel.add(displayCustomers);
        homePanel.setLayout(null);
        homePanel.setBackground(new Color(128, 191, 183, 255));

    }

    public UserInterface() throws HeadlessException {
        createHomePanel();

        this.setContentPane(homePanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("BillCounter");
        this.setSize(800, 600);
        this.setIconImage(new ImageIcon("src/billingapplication/images/icon.png").getImage());
        this.setResizable(false);
        this.setVisible(true);

    }

    public void setPanel(JPanel panel) {
        this.setContentPane(panel);
        this.revalidate();
        this.repaint();
    }

    public void setPanel(JTabbedPane panel) {
        this.setContentPane(panel);
        this.revalidate();
        this.repaint();
    }

}
