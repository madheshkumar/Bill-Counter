
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.*;
import javax.swing.table.*;

//Main class
public class BillCounter extends UserWindow {

    //Instance variables
    String bill;
    String meal;
    int price;
    int quantity;
    int total = 0;
    String[] column = {"Item", "Quantity", "Price"};

    Object[][] data = {{"Dosa", 0, 10},
    {"Idli", 0, 5},
    {"Chapati", 0, 10},
    {"Veg Rice", 0, 70},
    {"Veg Noodles", 0, 70},
    {"Mushroom Rice", 0, 75},
    {"Mushroom Noodles", 0, 75},
    {"Chicken Rice", 0, 80},
    {"Chicken Noodles", 0, 80},
    {"Chicken-65 Fry", 0, 70},
    {"Veg Briyani", 0, 110},
    {"Chicken Briyani", 0, 150},
    {"Mutton Briyani", 0, 180},
    {"Fish curry", 0, 120},
    {"Butter Chicken", 0, 70},};

    //Constructor
    BillCounter() {
        BillDatabase db = new BillDatabase();
        db.Connect();
        //Action Events
        AEvents e = new AEvents(db);
        calculate.addActionListener(e);
        veg.addActionListener(e);
        non_veg.addActionListener(e);
        amount.addActionListener(e);

        //table
        DefaultTableModel model = new DefaultTableModel(data, column);
        table.setModel(model);
        ListSelectionModel model1 = table.getSelectionModel();
        model1.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent ev) {
                if (!model1.isSelectionEmpty()) {
                    total = 0;

                    for (int i = 0; i < table.getRowCount(); i++) {

                        if (table.getValueAt(i, 1) instanceof java.lang.String) {
                            quantity = Integer.parseInt((String) table.getValueAt(i, 1));
                        } else {
                            quantity = (int) table.getValueAt(i, 1);
                        }

                        price = (int) table.getValueAt(i, 2);
                        price = quantity * price;
                        total += price;
                    }

                    String s = String.valueOf(total);
                    amount.setText("₹ " + s);
                }

            }

        });
    }
    //Main Method
    public static void main(String[] args) {

        BillCounter frame = new BillCounter();
        
        
        
        frame.setTitle("Bill Counter");
        frame.getContentPane().setBackground(new Color(157, 224, 172));
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(900, 650);
        frame.setResizable(false);
        frame.setVisible(true);

    }

    //Action Event Class 
    public class AEvents implements ActionListener {
        BillDatabase db;
        AEvents(BillDatabase db){
            this.db=db;
        }
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == calculate) {
                JOptionPane dialog = new JOptionPane();

                bill = " Customer name: " + name.getText() + "\n"
                        + "\n Customer Number: " + number.getText() + "\n"
                        + "\n Table Number: " + tmenu.getSelectedItem()
                        + "\n" + "\n Meal Type: " + meal
                        + "\n" + "\n Amount: Rs." + total;

                dialog.showMessageDialog(null, new JTextArea(bill), "Your Bill", 1);
                db.Insert(name.getText(), number.getText(), tmenu.getSelectedItem(), meal, total);
            }

            if (e.getSource() == veg) {
                if (veg.isSelected()) {
                    meal = "Veg";
                }
            }
            if (e.getSource() == non_veg) {
                if (non_veg.isSelected()) {
                    meal = "Non Veg";
                }
            }
        }
    }


}
