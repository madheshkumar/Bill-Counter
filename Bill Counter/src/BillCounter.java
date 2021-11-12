import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.table.*;

//Main class
public class BillCounter extends NewJFrame
{   
    //Instance variables
    String bill;
    String meal;
    int price;
    int quantity;
    int total=0;
    String[] column = {"Item","Quantity","Price"};
    
    Object[][] data = {{"Dosa",0,10},
                       {"Idli",0,5},
                       {"Chapati",0,10},
                       {"Veg Rice",0,70},
                       {"Veg Noodles",0,70},
                       {"Mushroom Rice",0,75},
                       {"Mushroom Noodles",0,75},
                       {"Chicken Rice",0,80},
                       {"Chicken Noodles",0,80},
                       {"Chicken-65 Fry",0,70},
                       {"Veg Briyani",0,110},
                       {"Chicken Briyani",0,150},
                       {"Mutton Briyani",0,180},
                       {"Fish curry",0,120},
                       {"Butter Chicken",0,70},
                       }; 
    //Constructor
    BillCounter()
    {   
        //Action Events
        AEvents e = new AEvents();
        calculate.addActionListener(e);
        veg.addActionListener(e);
        non_veg.addActionListener(e);
        amount.addActionListener(e);
        
        
        DefaultTableModel model = new DefaultTableModel(data,column);
        table.setModel(model);
        
        
        ListSelectionModel model1 = table.getSelectionModel();
        
        model1.addListSelectionListener(new ListSelectionListener()
        {
            @Override
            public void valueChanged(ListSelectionEvent ev) {
                if(! model1.isSelectionEmpty())
                {   
                    total = 0;
                    
                    for(int i =0;i<table.getRowCount();i++)
                    {  
                        
                        if(table.getValueAt(i, 1) instanceof java.lang.String){
                            quantity = Integer.parseInt((String)table.getValueAt(i, 1));
                        }
                        else{
                            quantity = (int)table.getValueAt(i, 1);
                        }

                        price =(int)table.getValueAt(i, 2);
                        price = quantity*price;
                        total += price;
                    }
                    
                    String s = String.valueOf(total);
                    amount.setText("₹ "+s);
                }
            }
            
        });
    }
    //Main Methodw
    public static void main(String[] args) 
    {
        BillCounter frame = new BillCounter();
        frame.setTitle("Bill Counter");
        frame.getContentPane().setBackground(new Color(157, 224, 172));
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(900,650);
        frame.setVisible(true);
         
    }
    
   //Action Event Class 
   public class AEvents implements ActionListener
    {        
        public void actionPerformed(ActionEvent e)
        {
            if( e.getSource() == calculate)
            {
                JOptionPane dialog = new JOptionPane();
            
                bill = " Customer name: "+name.getText()+"\n"
                    +"\n Customer Number: "+number.getText()+"\n"
                    +"\n Table Number: "+tmenu.getSelectedItem()
                    +"\n"+"\n Meal Type: "+meal
                    +"\n"+"\n Amount: Rs."+ total;

                dialog.showMessageDialog(null,new JTextArea(bill),"Your Bill",1);
            }
            
            if(e.getSource() == veg)
            {
                if (veg.isSelected())
                {
                    meal = "Veg";
                }
            }
            if(e.getSource()==non_veg)
            {
                if(non_veg.isSelected())
                {
                    meal= "Non Veg";
                }
            }
            if (e.getSource()==table)
            {
                
            }
        }
    }
         
}
