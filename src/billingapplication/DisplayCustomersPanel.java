package billingapplication;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;

public class DisplayCustomersPanel extends JPanel {
    private final Color textLabelColor = new Color(24, 46, 87);
    private final Color textFieldColor = new Color(52, 69, 97);
    private final Font textFont = new Font("Segoe UI", 1, 18);
    private final LineBorder lineBorder = new LineBorder(new Color(72, 89, 115), 2, true);


    private JLabel title;
    private JTable customerTable;
    private JScrollPane customerScrollPane;
    private JLabel totalLabel;
    private JButton backButton;


    public  DisplayCustomersPanel(){
        initComponents();
    }

    private void initComponents() {

        title = new JLabel();
        customerTable = new JTable();
        customerScrollPane = new JScrollPane(customerTable);
        totalLabel = new JLabel();
        backButton = new JButton();
        

        title.setText("Customers");
        title.setForeground(new java.awt.Color(60, 68, 126));
        title.setFont(new java.awt.Font("Segoe UI", 1, 22));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        title.setRequestFocusEnabled(false);
        title.setBounds(300, 0, 200, 50);
        add(title);

        customerTable.setFont(textFont);
        customerTable.setForeground(textFieldColor);
        customerTable.setBounds(20, 100, 740, 300);
        customerTable.setRowHeight(30);
        customerTable.setBorder(new LineBorder(new Color(72, 89, 115), 1, true));
        customerTable.setGridColor(new Color(72, 89, 115));
        customerTable.setShowGrid(true);
        customerTable.setShowVerticalLines(true);
        customerTable.setShowHorizontalLines(true);
        customerTable.getTableHeader().setBackground(new Color(72, 89, 115));
        customerTable.getTableHeader().setForeground(Color.WHITE);
        customerTable.getTableHeader().setFont(new Font("Segoe UI", 1, 16));
        customerTable.getTableHeader().setBorder(new LineBorder(new Color(72, 89, 115), 1, true));
        customerTable.getTableHeader().setReorderingAllowed(false);

        customerScrollPane.setBounds(20, 50, 740, 400);
        customerScrollPane.setBorder(lineBorder);
        
        totalLabel.setText("Total Customers: 0");
        totalLabel.setFont(new Font("Segoe UI", 1, 18));
        totalLabel.setForeground(textLabelColor);
        totalLabel.setBounds(500, 480, 200, 40);
        
        backButton.setText("Back to menu");
        backButton.setBackground(new Color(52, 69, 97));
        backButton.setForeground(Color.WHITE);
        backButton.setFont(new java.awt.Font("Segoe UI", 1, 16));
        backButton.setBounds(100, 480, 200, 40);
        backButton.setBorder(lineBorder);
        backButton.setFocusPainted(false);

        backButton.setBorder(lineBorder);
        add(customerScrollPane);
        add(totalLabel);
        add(backButton);
        setLayout(null);
        setBounds(0, 0, 800, 600);
        setBackground(new Color(193, 213, 245));


    }
    public JButton getBackButton() {
        return backButton;
    }
    public JTable getCustomerTable() {
        return customerTable;
    }
    public JLabel getTotalLabel() {
        return totalLabel;
    }
}
