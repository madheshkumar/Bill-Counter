package billingapplication;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import javax.swing.border.*;

public class CreateBillPanel extends JTabbedPane {

    private final Color textLabelColor = new Color(24, 46, 87);
    private final Color textFieldColor = new Color(52, 69, 97);
    private final Font textFont = new Font("Segoe UI", 1, 18);
    private final LineBorder lineBorder = new LineBorder(new Color(52, 69, 97), 2, true);

    private int serialno;

    private JLabel title;
    private JPanel tab1;
    private JPanel tab2;

    private JLabel customerNameLabel;
    private JLabel customerPhoneLabel;

    private JTextField customerName;
    private JTextField customerPhone;

    private JLabel tableNumberLabel;
    private JComboBox<Integer> tableNumber;

    private JLabel mealnameLabel;

    private JScrollPane mealnameScrollPane;
    private JList<String> mealnameList;

    private JLabel quantityLabel;
    private JSpinner quantity;

    private JLabel priceLabel;
    private JTextField price;

    private JLabel mealtypeLabel;
    private ButtonGroup mealButtonGroup;
    private JRadioButton vegButton;
    private JRadioButton nonvegButton;

    private JLabel validate;

    private JLabel custName;
    private JLabel custPhone;
    private JLabel tableNo;

    private JTable billTable;
    private JLabel totalLabel;
    private JLabel billValidate;
    private JScrollPane billScrollPane;

    private JButton addToBill;
    private JButton calculateBill;
    private JButton displayBill;
    private JButton updateBill;
    private JButton backButton;

    public CreateBillPanel() {
        initComponents();
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    private void initComponents() {
        serialno = 0;

        title = new JLabel();
        tab1 = new JPanel();
        tab2 = new JPanel();

        customerNameLabel = new JLabel();
        customerName = new JTextField();
        customerPhoneLabel = new JLabel();
        customerPhone = new JTextField();
        tableNumberLabel = new JLabel();
        tableNumber = new JComboBox();

        mealnameLabel = new JLabel();
        mealnameList = new JList(new DefaultListModel());
        mealnameScrollPane = new JScrollPane(mealnameList);
        quantityLabel = new JLabel();
        quantity = new JSpinner();

        mealtypeLabel = new JLabel();
        mealButtonGroup = new ButtonGroup();
        vegButton = new JRadioButton();
        nonvegButton = new JRadioButton();

        validate = new JLabel();

        priceLabel = new JLabel();
        price = new JTextField();

        addToBill = new JButton();
        calculateBill = new JButton();
        displayBill = new JButton();
        updateBill = new JButton();
        backButton = new JButton("Back to menu");

        // tab 1 - Create bill
        title.setText("CREATE BILL");
        title.setForeground(new Color(60, 68, 126));
        title.setFont(new Font("Segoe UI", 1, 22));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setHorizontalTextPosition(SwingConstants.CENTER);
        title.setRequestFocusEnabled(false);
        title.setBounds(300, 10, 200, 50);
        tab1.add(title);

        customerNameLabel.setText("Customer Name");
        customerNameLabel.setFont(textFont);
        customerNameLabel.setForeground(textLabelColor);
        customerNameLabel.setBounds(50, 70, 200, 40);
        customerNameLabel.setHorizontalAlignment(SwingConstants.LEFT);

        customerName.setText("");
        customerName.setFont(textFont);
        customerName.setForeground(textFieldColor);
        customerName.setBounds(50, 130, 200, 40);
        customerName.setBorder(lineBorder);

        customerPhoneLabel.setText("Customer Phone");
        customerPhoneLabel.setFont(textFont);
        customerPhoneLabel.setForeground(textLabelColor);
        customerPhoneLabel.setBounds(50, 200, 200, 40);
        customerPhoneLabel.setHorizontalAlignment(SwingConstants.LEFT);

        customerPhone.setText("");
        customerPhone.setFont(textFont);
        customerPhone.setForeground(textFieldColor);
        customerPhone.setBounds(50, 260, 200, 40);
        customerPhone.setBorder(lineBorder);

        tableNumberLabel.setText("Table No.");
        tableNumberLabel.setFont(textFont);
        tableNumberLabel.setForeground(textLabelColor);
        tableNumberLabel.setBounds(50, 330, 200, 40);
        tableNumberLabel.setHorizontalAlignment(SwingConstants.LEFT);

        tableNumber.setFont(textFont);
        tableNumber.setForeground(textFieldColor);
        tableNumber.setBounds(50, 400, 200, 40);
        tableNumber.setBorder(lineBorder);

        mealtypeLabel.setText(" Select Meal Type");
        mealtypeLabel.setFont(textFont);
        mealtypeLabel.setForeground(textLabelColor);
        mealtypeLabel.setBounds(325, 70, 200, 40);
        mealtypeLabel.setHorizontalAlignment(SwingConstants.CENTER);

        vegButton.setText("Veg");
        vegButton.setFont(textFont);
        vegButton.setForeground(textLabelColor);
        vegButton.setBackground(null);
        vegButton.setBounds(300, 120, 150, 40);
        vegButton.setHorizontalAlignment(SwingConstants.LEFT);
        vegButton.setFocusPainted(false);

        nonvegButton.setText("Non-Veg");
        nonvegButton.setFont(textFont);
        nonvegButton.setForeground(textLabelColor);
        nonvegButton.setBackground(null);
        nonvegButton.setBounds(450, 120, 150, 40);
        nonvegButton.setHorizontalAlignment(SwingConstants.LEFT);
        nonvegButton.setFocusPainted(false);

        mealButtonGroup.add(vegButton);
        mealButtonGroup.add(nonvegButton);

        validate.setText("");
        validate.setFont(new Font("Segoe UI", 1, 16));
        validate.setForeground(new Color(209, 35, 23));
        validate.setBounds(300, 420, 200, 30);

        mealnameLabel.setText("Meal Name");
        mealnameLabel.setFont(textFont);
        mealnameLabel.setForeground(textLabelColor);
        mealnameLabel.setBounds(300, 170, 225, 30);
        mealnameLabel.setHorizontalAlignment(SwingConstants.CENTER);

        mealnameScrollPane = new JScrollPane(mealnameList);
        mealnameScrollPane.setBounds(300, 220, 225, 200);
        mealnameScrollPane.setBorder(lineBorder);

        mealnameList.setFont(textFont);
        mealnameList.setForeground(textFieldColor);
        mealnameList.setBounds(300, 220, 225, 200);
        mealnameList.setBorder(lineBorder);
        mealnameList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        mealnameList.setLayoutOrientation(JList.VERTICAL);
        mealnameList.setVisibleRowCount(1);
        mealnameList.setSelectionBackground(new Color(247, 178, 173));

        quantityLabel.setText("Quantity");
        quantityLabel.setFont(textFont);
        quantityLabel.setForeground(textLabelColor);
        quantityLabel.setBounds(550, 170, 150, 30);
        quantityLabel.setHorizontalAlignment(SwingConstants.CENTER);

        quantity.setFont(textFont);
        quantity.setForeground(textFieldColor);
        quantity.setBounds(575, 220, 100, 40);
        quantity.setBorder(lineBorder);

        priceLabel.setText("Price (in Rs)");
        priceLabel.setFont(textFont);
        priceLabel.setForeground(textLabelColor);
        priceLabel.setBounds(550, 270, 150, 30);
        priceLabel.setHorizontalAlignment(SwingConstants.CENTER);

        price.setFont(textFont);
        price.setHorizontalAlignment(SwingConstants.RIGHT);
        price.setForeground(textFieldColor);
        price.setBounds(575, 320, 100, 40);
        price.setBorder(lineBorder);

        addToBill.setText("Add to Bill");
        addToBill.setFont(new Font("San Serif", 1, 16));
        addToBill.setBounds(550, 380, 150, 40);
        addToBill.setBackground(new Color(36, 97, 62));
        addToBill.setForeground(new Color(193, 213, 245));
        addToBill.setFocusPainted(false);

        displayBill.setText("Display Bill");
        displayBill.setFont(new Font("San Serif", 1, 16));
        displayBill.setBounds(530, 460, 200, 40);
        displayBill.setBackground(new Color(120, 65, 79));
        displayBill.setForeground(new Color(193, 213, 245));
        displayBill.setFocusPainted(false);
        displayBill.addActionListener(e -> this.setSelectedIndex(1));

        backButton.setFont(new Font("San Serif", 1, 16));
        backButton.setBounds(300, 460, 200, 40);
        backButton.setBackground(new Color(52, 69, 97));
        backButton.setForeground(new Color(193, 213, 245));
        backButton.setFocusPainted(false);

        tab1.add(customerNameLabel);
        tab1.add(customerName);
        tab1.add(customerPhoneLabel);
        tab1.add(customerPhone);
        tab1.add(tableNumberLabel);
        tab1.add(tableNumber);
        tab1.add(mealtypeLabel);
        tab1.add(vegButton);
        tab1.add(nonvegButton);
        tab1.add(mealnameLabel);
        tab1.add(mealnameScrollPane);
        tab1.add(quantityLabel);
        tab1.add(quantity);
        tab1.add(priceLabel);
        tab1.add(price);
        tab1.add(validate);

        tab1.add(addToBill);
        tab1.add(displayBill);
        tab1.add(backButton);
        tab1.setLayout(null);
        tab1.setBackground(new Color(252, 179, 193));

        //tab 2 - Display Bill
        custName = new JLabel();
        custPhone = new JLabel();
        tableNo = new JLabel();

        billTable = new JTable();
        billScrollPane = new JScrollPane(billTable);
        totalLabel = new JLabel();
        billValidate = new JLabel();

        custName.setText("Customer: ");
        custName.setFont(new Font("San Serif", 1, 16));
        custName.setForeground(textLabelColor);
        custName.setBounds(20, 50, 250, 40);
        custName.setHorizontalAlignment(SwingConstants.LEFT);

        custPhone.setText("Phone: ");
        custPhone.setFont(new Font("San Serif", 1, 16));
        custPhone.setForeground(textLabelColor);
        custPhone.setBounds(300, 50, 250, 40);
        custPhone.setHorizontalAlignment(SwingConstants.LEFT);

        tableNo.setText("Table No. : ");
        tableNo.setFont(new Font("San Serif", 1, 16));
        tableNo.setForeground(textLabelColor);
        tableNo.setBounds(600, 50, 200, 40);
        tableNo.setHorizontalAlignment(SwingConstants.LEFT);

        billTable.setFont(textFont);
        billTable.setForeground(textFieldColor);
        billTable.setBounds(20, 100, 740, 300);
        billTable.setRowHeight(30);
        billTable.setBorder(new LineBorder(new Color(120, 65, 79), 1, true));
        billTable.setGridColor(new Color(120, 65, 79));
        billTable.setShowGrid(true);
        billTable.setShowVerticalLines(true);
        billTable.setShowHorizontalLines(true);
        billTable.getTableHeader().setBackground(new Color(120, 65, 79));
        billTable.getTableHeader().setForeground(Color.WHITE);
        billTable.getTableHeader().setFont(new Font("San Serif", 1, 16));
        billTable.getTableHeader().setBorder(new LineBorder(new Color(120, 65, 79), 1, true));
        billTable.getTableHeader().setReorderingAllowed(false);

        billScrollPane.setBounds(20, 100, 740, 300);
        billScrollPane.setBorder(lineBorder);

        totalLabel.setText("Total Bill: ₹ 0");
        totalLabel.setFont(new Font("San Serif", 1, 18));
        totalLabel.setForeground(textLabelColor);
        totalLabel.setBounds(520, 400, 200, 40);

        billValidate.setText("");
        billValidate.setFont(new Font("San Serif", 1, 16));
        billValidate.setForeground(new Color(209, 35, 23));
        billValidate.setBounds(300, 410, 200, 30);

        updateBill.setText("Add orders");
        updateBill.setFont(new Font("San Serif", 1, 16));
        updateBill.setBounds(100, 450, 200, 40);
        updateBill.setBackground(new Color(120, 65, 79));
        updateBill.setForeground(new Color(193, 213, 245));
        updateBill.setFocusPainted(false);
        updateBill.addActionListener(e -> this.setSelectedIndex(0));

        calculateBill.setText("Calculate Bill");
        calculateBill.setFont(new Font("San Serif", 1, 16));
        calculateBill.setBounds(500, 450, 200, 40);
        calculateBill.setBackground(new Color(36, 97, 62));
        calculateBill.setForeground(new Color(193, 213, 245));
        calculateBill.setFocusPainted(false);

        tab2.add(custName);
        tab2.add(custPhone);
        tab2.add(tableNo);
        tab2.add(billScrollPane);
        tab2.add(totalLabel);
        tab2.add(billValidate);

        tab2.add(updateBill);
        tab2.add(calculateBill);
        tab2.setLayout(null);
        tab2.setBackground(new Color(252, 179, 193));

        this.addTab("Create Bill", tab1);
        this.addTab("Display Bill", tab2);
    }
    //tab1 create bill methods

    public int getSerialNo() {
        return serialno;
    }

    public void setSerialNo(int sno) {
        serialno = sno;
    }

    public JTextField getCustomerName() {
        return customerName;
    }

    public JTextField getCustomerPhone() {
        return customerPhone;
    }

    public JComboBox<Integer> getTableNumbers() {
        return tableNumber;
    }

    public JRadioButton getVegButton() {
        return vegButton;
    }

    public JRadioButton getNonVegButton() {
        return nonvegButton;
    }

    public JList<String> getMealnameList() {
        return mealnameList;
    }

    public JSpinner getQuantity() {
        return quantity;
    }

    public JTextField getPrice() {
        return price;
    }

    public JLabel getValidate() {
        return validate;
    }

    public JButton getAddToBill() {
        return addToBill;
    }

    //tab2 methods
    public JLabel getCustName() {
        return custName;
    }

    public JLabel getCustPhone() {
        return custPhone;
    }

    public JLabel getTableNo() {
        return tableNo;
    }

    public JTable getBillTable() {
        return billTable;
    }

    public JLabel getTotalLabel() {
        return totalLabel;
    }

    public JLabel getBillValidate(){
        return billValidate;
    }

    public JButton calculateBill() {
        return calculateBill;
    }

    public JButton getBackButton() {
        return backButton;
    }

}
