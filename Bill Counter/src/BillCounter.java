import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

//Main class
public class BillCounter extends NewJFrame
{   
    //Instance variables
    String bill;
    String meal;
    
    //Constructor
    BillCounter()
    {   
        //Action Events
        AEvents e = new AEvents();
        calculate.addActionListener(e);
        veg.addActionListener(e);
        non_veg.addActionListener(e);
          
    }
    
    //Main Method
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
                    +"\n"+"\n Meal Type: "+meal;
            
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
        }
    }
}
