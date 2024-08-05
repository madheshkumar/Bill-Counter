package billingapplication;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class BillingApplication extends UserInterface implements ActionListener,
        ChangeListener,
        ListSelectionListener,
        DocumentListener,
        TableModelListener {

    AddItemsPanel addItemsPanel;
    CreateBillPanel createBillPanel;
    DisplayRevenuePanel displayRevenuePanel;
    DisplayCustomersPanel displayCustomersPanel;

    BillDatabase db;

    String[] menuList;
    Integer[] tableNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    DefaultTableModel billModel, revenueModel, customerModel;

    DefaultTableCellRenderer leftRenderer;
    DefaultTableCellRenderer centerRenderer;
    DefaultTableCellRenderer rightRenderer;

    Object[] billColumnIdentifiers = {"S.no", "Mealname", "Quantity", "Price", "Remove"};
    Class<?>[] billColumnClasses = {Integer.class, String.class, Integer.class, Integer.class, Boolean.class};

    Object[] revenueColumnIdentifiers = {"Billid", "Customer", "Table No", "Date", "Payment"};
    Class<?>[] revenueColumnClasses = {Integer.class, String.class, Integer.class, String.class, Integer.class};

    Object[] customerColumnIdentifiers = {"Customerid", "Name", "Phone Number", "Total Orders"};
    Class<?>[] customerColumnClasses = {Integer.class, String.class, String.class, Integer.class};

    public BillingApplication() throws HeadlessException {
        db = new BillDatabase();

        billModel = new DefaultTableModel(billColumnIdentifiers, 0) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return billColumnClasses[columnIndex];
            }
        };

        revenueModel = new DefaultTableModel(revenueColumnIdentifiers, 0) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return revenueColumnClasses[columnIndex];
            }
        };

        customerModel = new DefaultTableModel(customerColumnIdentifiers, 0) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return customerColumnClasses[columnIndex];
            }
        };

        leftRenderer = new DefaultTableCellRenderer();
        leftRenderer.setHorizontalAlignment(SwingConstants.LEFT);

        centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);

        addItemsPanel = new AddItemsPanel();
        createBillPanel = new CreateBillPanel();
        displayRevenuePanel = new DisplayRevenuePanel();
        displayCustomersPanel = new DisplayCustomersPanel();

        createBillPanel.getBillTable().setModel(billModel);
        displayRevenuePanel.getRevenueTable().setModel(revenueModel);
        displayCustomersPanel.getCustomerTable().setModel(customerModel);

        addEventListeners();

        updateMenuList();
        updateTableNumbers();

    }

    private void addEventListeners() {
        this.createBill.addActionListener(this);
        this.updateMenu.addActionListener(this);
        this.displayRevenue.addActionListener(this);
        this.displayCustomers.addActionListener(this);

        addItemsPanel.getMeal().addActionListener(this);
        addItemsPanel.getPrice().addActionListener(this);
        addItemsPanel.getVegButton().addActionListener(this);
        addItemsPanel.getNonvegButton().addActionListener(this);
        addItemsPanel.getBackButton().addActionListener(this);
        addItemsPanel.getAddItem().addActionListener(this);

        createBillPanel.getCustomerName().getDocument().addDocumentListener(this);
        createBillPanel.getCustomerPhone().getDocument().addDocumentListener(this);
        createBillPanel.getTableNumbers().addActionListener(this);
        createBillPanel.getVegButton().addActionListener(this);
        createBillPanel.getNonVegButton().addActionListener(this);
        createBillPanel.getMealnameList().addListSelectionListener(this);
        createBillPanel.getQuantity().addChangeListener(this);
        createBillPanel.getPrice().addActionListener(this);

        createBillPanel.getBillTable().getModel().addTableModelListener(this);

        createBillPanel.getBackButton().addActionListener(this);
        createBillPanel.getAddToBill().addActionListener(this);
        createBillPanel.calculateBill().addActionListener(this);

        displayRevenuePanel.getBackButton().addActionListener(this);

        displayCustomersPanel.getBackButton().addActionListener(this);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new BillingApplication().setVisible(true);
        });
    }

    // for action events
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.createBill) {
            createBillPanel.setVisible(true);
            this.setPanel(this.createBillPanel);
        }
        if (e.getSource() == this.updateMenu) {
            addItemsPanel.setVisible(true);
            this.setPanel(this.addItemsPanel);
        }
        if (e.getSource() == this.displayRevenue) {
            displayRevenuePanel.setVisible(true);
            TableColumn column;
            DefaultTableModel model;
            model = (DefaultTableModel) displayRevenuePanel.getRevenueTable().getModel();

            for (int i = model.getRowCount() - 1; i >= 0; i--) {
                model.removeRow(i);
            }

            String[][] bills = db.getBills();

            for (String[] bill : bills) {
                model.addRow(new Object[]{Integer.valueOf(bill[0]), db.getCustomerName(bill[1]), Integer.valueOf(bill[2]), bill[4], Integer.valueOf(bill[3])});
            }
            displayRevenuePanel.getRevenueTable().setModel(model);

            column = displayRevenuePanel.getRevenueTable().getColumnModel().getColumn(0);
            column.setPreferredWidth(50);
            column.setMinWidth(50);
            column.setMaxWidth(50);
            column.setCellRenderer(centerRenderer);

            column = displayRevenuePanel.getRevenueTable().getColumnModel().getColumn(1);
            column.setPreferredWidth(300);
            column.setMinWidth(200);
            column.setMaxWidth(400);
            column.setCellRenderer(leftRenderer);

            column = displayRevenuePanel.getRevenueTable().getColumnModel().getColumn(2);
            column.setPreferredWidth(100);
            column.setMinWidth(50);
            column.setMaxWidth(100);
            column.setCellRenderer(centerRenderer);

            column = displayRevenuePanel.getRevenueTable().getColumnModel().getColumn(3);
            column.setPreferredWidth(150);
            column.setMinWidth(100);
            column.setMaxWidth(150);
            column.setCellRenderer(centerRenderer);

            column = displayRevenuePanel.getRevenueTable().getColumnModel().getColumn(4);
            column.setPreferredWidth(100);
            column.setMinWidth(100);
            column.setMaxWidth(100);
            column.setCellRenderer(rightRenderer);

            displayRevenuePanel.getTotalLabel().setText("Total Revenue: ₹ " + db.getTotalRevenue() + "");
            this.setPanel(this.displayRevenuePanel);
        }
        if (e.getSource() == this.displayCustomers) {
            displayCustomersPanel.setVisible(true);

            TableColumn column;
            DefaultTableModel model;
            model = (DefaultTableModel) displayCustomersPanel.getCustomerTable().getModel();

            for (int i = model.getRowCount() - 1; i >= 0; i--) {
                model.removeRow(i);
            }

            String[][] customers = db.getCustomers();

            for (String[] customer : customers) {
                model.addRow(new Object[]{Integer.valueOf(customer[0]), customer[1], customer[2], Integer.valueOf(customer[3])});
            }
            displayCustomersPanel.getCustomerTable().setModel(model);

            column = displayCustomersPanel.getCustomerTable().getColumnModel().getColumn(0);
            column.setPreferredWidth(100);
            column.setMinWidth(50);
            column.setMaxWidth(100);
            column.setCellRenderer(centerRenderer);

            column = displayCustomersPanel.getCustomerTable().getColumnModel().getColumn(1);
            column.setPreferredWidth(300);
            column.setMinWidth(200);
            column.setMaxWidth(400);
            column.setCellRenderer(leftRenderer);

            column = displayCustomersPanel.getCustomerTable().getColumnModel().getColumn(2);
            column.setPreferredWidth(150);
            column.setMinWidth(100);
            column.setMaxWidth(150);
            column.setCellRenderer(centerRenderer);


            column = displayCustomersPanel.getCustomerTable().getColumnModel().getColumn(3);
            column.setPreferredWidth(150);
            column.setMinWidth(100);
            column.setMaxWidth(150);
            column.setCellRenderer(rightRenderer);

            displayCustomersPanel.getTotalLabel().setText("Total Customers: " + db.getTotalCustomers() + "");
            this.setPanel(this.displayCustomersPanel);
        }
        if (e.getSource() == this.addItemsPanel.getBackButton()
                || e.getSource() == this.createBillPanel.getBackButton()
                || e.getSource() == this.displayRevenuePanel.getBackButton()
                || e.getSource() == this.displayCustomersPanel.getBackButton()) {
            addItemsPanel.setVisible(false);
            createBillPanel.setVisible(false);
            displayRevenuePanel.setVisible(false);
            displayCustomersPanel.setVisible(false);
            this.setPanel(this.homePanel);
        }

        // Add items to the menu
        if (e.getSource() == addItemsPanel.getAddItem()) {
            String meal = addItemsPanel.getMeal().getText();
            String price = addItemsPanel.getPrice().getText();
            String mealType = addItemsPanel.getVegButton().isSelected() ? "veg" : addItemsPanel.getNonvegButton().isSelected() ? "non-veg" : "Select Meal Type";
            if (meal.isEmpty() || price.isEmpty()) {
                showTimedMessage(addItemsPanel.getValidate(), "Enter Meal and Price", 2000);
                return;
            }
            if (mealType.equals("Select Meal Type")) {
                showTimedMessage(addItemsPanel.getValidate(), "Select meal type", 2000);
                return;
            }

            if (db.getMealId(meal) != -1) {
                showTimedMessage(addItemsPanel.getValidate(), "Meal already exists", 2000);
                return;
            }

            db.insertMenu(meal, mealType, Integer.parseInt(price));
            addItemsPanel.getMeal().setText("");
            addItemsPanel.getPrice().setText("");
            addItemsPanel.getVegButton().setSelected(false);
            addItemsPanel.getNonvegButton().setSelected(false);
            addItemsPanel.getValidate().setText("");
        }

        // Create a bill
        if (e.getSource() == createBillPanel.getTableNumbers()) {
            createBillPanel.getTableNo().setText("Table No: " + createBillPanel.getTableNumbers().getSelectedItem().toString());
        }

        if (e.getSource() == createBillPanel.getVegButton() || e.getSource() == createBillPanel.getNonVegButton()) {
            updateMenuList();
        }

        if (e.getSource() == createBillPanel.getAddToBill()) {

            TableColumn column;
            DefaultTableModel model;
            int sno = createBillPanel.getSerialNo() + 1;
            String mealname = createBillPanel.getMealnameList().getSelectedValue();
            int quantity = (int) createBillPanel.getQuantity().getValue();
            String price = createBillPanel.getPrice().getText();

            System.out.println(sno + " " + mealname + " " + quantity + " " + price);
            if (mealname == null) {
                showTimedMessage(createBillPanel.getValidate(), "Select a meal", 2000);
                return;
            }

            if (quantity == 0) {
                showTimedMessage(createBillPanel.getValidate(), "Enter Quantity", 2000);
                return;
            }

            if (price.isEmpty()) {
                showTimedMessage(createBillPanel.getValidate(), "Enter Price", 2000);
                return;
            }

            model = (DefaultTableModel) createBillPanel.getBillTable().getModel();
            model.addRow(new Object[]{sno, mealname, quantity, Integer.valueOf(price), false});
            createBillPanel.getBillTable().setModel(model);

            column = createBillPanel.getBillTable().getColumnModel().getColumn(0);
            column.setPreferredWidth(50);
            column.setMinWidth(50);
            column.setMaxWidth(50);
            column.setCellRenderer(centerRenderer);

            column = createBillPanel.getBillTable().getColumnModel().getColumn(1); 
            column.setPreferredWidth(300);
            column.setMinWidth(200);
            column.setMaxWidth(400);

            column = createBillPanel.getBillTable().getColumnModel().getColumn(2); 
            column.setPreferredWidth(100);
            column.setMinWidth(50);
            column.setMaxWidth(100);
            column.setCellRenderer(centerRenderer);

            column = createBillPanel.getBillTable().getColumnModel().getColumn(3); 
            column.setPreferredWidth(100);
            column.setMinWidth(100);
            column.setMaxWidth(100);
            column.setCellRenderer(rightRenderer);

            column = createBillPanel.getBillTable().getColumnModel().getColumn(4); 
            column.setPreferredWidth(100);
            column.setMinWidth(100);
            column.setMaxWidth(100);

            createBillPanel.setSerialNo(sno);

            createBillPanel.getMealnameList().clearSelection();
            createBillPanel.getQuantity().setValue(0);
            createBillPanel.getPrice().setText("");
            createBillPanel.getValidate().setText("");
        }

        if (e.getSource() == createBillPanel.calculateBill()) {

            String name = createBillPanel.getCustomerName().getText();
            String phone = createBillPanel.getCustomerPhone().getText();
            String tableno = createBillPanel.getTableNumbers().getSelectedItem().toString();
            int totalAmount = Integer.parseInt(createBillPanel.getTotalLabel().getText().substring(14, createBillPanel.getTotalLabel().getText().length()));

            if (name.isEmpty() || phone.isEmpty()) {
                showTimedMessage(createBillPanel.getBillValidate(), "Enter Name and Phone", 2000);
                return;
            }

            if (createBillPanel.getBillTable().getRowCount() == 0) {
                showTimedMessage(createBillPanel.getBillValidate(), "no orders yet", 2000);
                return;
            }

            int cid = db.getCustomerId(name, phone);

            if (cid == -1) {
                db.insertCustomer(name, phone);
                cid = db.getCustomerId(name, phone);
            }

            db.insertBill(cid, tableno, totalAmount, LocalDate.now().toString());

            for (int i = 0; i < createBillPanel.getBillTable().getRowCount(); i++) {
                String mealname = (String) createBillPanel.getBillTable().getValueAt(i, 1);
                int quantity = (int) createBillPanel.getBillTable().getValueAt(i, 2);
                db.insertOrder(db.getLastBill(), db.getMealId(mealname), quantity);
            }

            showTimedMessage(createBillPanel.getBillValidate(), "Bill created successfully", 2000);

            createBillPanel.getCustomerName().setText("");
            createBillPanel.getCustomerPhone().setText("");
            createBillPanel.getTableNumbers().setSelectedIndex(0);
            createBillPanel.getVegButton().setSelected(false);
            createBillPanel.getNonVegButton().setSelected(false);

            createBillPanel.getCustName().setText("Customer:");
            createBillPanel.getCustPhone().setText("Phone: ");
            createBillPanel.getTableNo().setText("Table No: ");
            createBillPanel.getTotalLabel().setText("Total Bill: ₹ 0");

            for (int i = createBillPanel.getBillTable().getModel().getRowCount() - 1; i >= 0; i--) {
                ((DefaultTableModel) createBillPanel.getBillTable().getModel()).removeRow(i);
            }
            createBillPanel.setSerialNo(0);

            createBillPanel.getBillTable().setModel(createBillPanel.getBillTable().getModel());
        }

    }

    // for change events
    @Override
    public void stateChanged(ChangeEvent e) {
        if (e.getSource() == createBillPanel.getQuantity()) {
            calculateprice();
        }
    }

    // for list selection events
    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (e.getSource() == createBillPanel.getMealnameList()) {
            calculateprice();
        }
    }

    private void calculateprice() {
        if (createBillPanel.getMealnameList().getSelectedValue() == null) {
            return;
        }
        int price = db.getMealPrice(createBillPanel.getMealnameList().getSelectedValue()) * (int) createBillPanel.getQuantity().getValue();
        createBillPanel.getPrice().setText("" + price);
    }

    // for document events
    @Override
    public void insertUpdate(DocumentEvent e) {
        if (e.getDocument() == createBillPanel.getCustomerName().getDocument()) {
            createBillPanel.getCustName().setText("Customer: " + createBillPanel.getCustomerName().getText());
        }
        if (e.getDocument() == createBillPanel.getCustomerPhone().getDocument()) {
            createBillPanel.getCustPhone().setText("Phone: " + createBillPanel.getCustomerPhone().getText());
        }
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        if (e.getDocument() == createBillPanel.getCustomerName().getDocument()) {
            createBillPanel.getCustName().setText("Customer: " + createBillPanel.getCustomerName().getText());
        }
        if (e.getDocument() == createBillPanel.getCustomerPhone().getDocument()) {
            createBillPanel.getCustPhone().setText("Phone: " + createBillPanel.getCustomerPhone().getText());
        }
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    // for table model events
    @Override
    public void tableChanged(TableModelEvent e) {

        if (e.getSource() == createBillPanel.getBillTable().getModel()) {
            for (int i = createBillPanel.getBillTable().getModel().getRowCount() - 1; i >= 0; i--) {
                if ((boolean) createBillPanel.getBillTable().getModel().getValueAt(i, 4)) {
                    ((DefaultTableModel) createBillPanel.getBillTable().getModel()).removeRow(i);
                    createBillPanel.setSerialNo(createBillPanel.getSerialNo() - 1);
                    for (int j = i; j < createBillPanel.getBillTable().getRowCount(); j++) {
                        createBillPanel.getBillTable().setValueAt(j + 1, j, 0);
                    }
                }
            }

            createBillPanel.getBillTable().setModel(createBillPanel.getBillTable().getModel());
        }

        if (e.getSource() == createBillPanel.getBillTable().getModel()) {
            int totalAmount = 0;
            for (int i = 0; i < createBillPanel.getBillTable().getRowCount(); i++) {
                totalAmount += (int) createBillPanel.getBillTable().getValueAt(i, 3);
            }
            createBillPanel.getTotalLabel().setText("Total Bill: ₹ " + totalAmount);
        }
    }

    private void updateMenuList() {

        if (createBillPanel.getVegButton().isSelected()) {
            menuList = db.getVegMenu();
        }
        if (createBillPanel.getNonVegButton().isSelected()) {
            menuList = db.getNonVegMenu();
        }
        if (!createBillPanel.getVegButton().isSelected() && !createBillPanel.getNonVegButton().isSelected()) {
            menuList = db.getMenu();
        }
        createBillPanel.getMealnameList().setListData(menuList);
    }

    private void updateTableNumbers() {
        createBillPanel.getTableNumbers().setModel(new DefaultComboBoxModel<>(tableNumbers));
    }

    private void showTimedMessage(JLabel label, String message, int delay) {
        label.setText(message);

        Timer timer = new Timer(delay, (ActionEvent e) -> {
            label.setText("");
        });

        timer.setRepeats(false);
        timer.start();
    }

}
