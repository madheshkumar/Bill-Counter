package billingapplication;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class DisplayRevenuePanel extends JPanel {

    private final Color textLabelColor = new Color(24, 46, 87);
    private final Color textFieldColor = new Color(52, 69, 97);
    private final Font textFont = new Font("Segoe UI", 1, 18);
    private final LineBorder lineBorder = new LineBorder(new Color(145, 118, 90), 2, true);


    private JLabel title;
    private JTable revenueTable;
    private JScrollPane revenueScrollPane;
    private JLabel totalLabel;
    private JButton backButton;


    public DisplayRevenuePanel(){
        initComponents();
    }

    private void initComponents() {

        title = new JLabel();
        revenueTable = new JTable();
        revenueScrollPane = new JScrollPane(revenueTable);
        totalLabel = new JLabel();
        backButton = new JButton();
        

        title.setText("REVENUE");
        title.setForeground(new java.awt.Color(60, 68, 126));
        title.setFont(new java.awt.Font("Segoe UI", 1, 22));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        title.setRequestFocusEnabled(false);
        title.setBounds(300, 0, 200, 50);
        add(title);

        revenueTable.setFont(textFont);
        revenueTable.setForeground(textFieldColor);
        revenueTable.setBounds(20, 100, 740, 300);
        revenueTable.setRowHeight(30);
        revenueTable.setBorder(new LineBorder(new Color(148, 114, 80), 1, true));
        revenueTable.setGridColor(new Color(148, 114, 80));
        revenueTable.setShowGrid(true);
        revenueTable.setShowVerticalLines(true);
        revenueTable.setShowHorizontalLines(true);
        revenueTable.getTableHeader().setBackground(new Color(148, 114, 80));
        revenueTable.getTableHeader().setForeground(Color.WHITE);
        revenueTable.getTableHeader().setFont(new Font("Segoe UI", 1, 16));
        revenueTable.getTableHeader().setBorder(lineBorder);
        revenueTable.getTableHeader().setReorderingAllowed(false);

        revenueScrollPane.setBounds(20, 50, 740, 400);
        revenueScrollPane.setBorder(lineBorder);
        
        totalLabel.setText("Total Revenue: ₹ 0");
        totalLabel.setFont(new Font("Segoe UI", 1, 18));
        totalLabel.setForeground(textLabelColor);
        totalLabel.setBounds(500, 480, 200, 40);
        
        backButton.setText("Back to menu");
        backButton.setBackground(new Color(138, 106, 74));
        backButton.setForeground(Color.WHITE);
        backButton.setFont(new java.awt.Font("Segoe UI", 1, 16));
        backButton.setBounds(100, 480, 200, 40);
        backButton.setBorder(lineBorder);
        backButton.setFocusPainted(false);


        add(revenueScrollPane);
        add(totalLabel);
        add(backButton);

        setLayout(null);
        setBackground(new Color(247, 193, 139));

    }
    public JButton getBackButton() {
        return backButton;
    }
    public JTable getRevenueTable() {
        return revenueTable;
    }
    public JLabel getTotalLabel() {
        return totalLabel;
    }
}
