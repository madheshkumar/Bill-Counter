import java.awt.*;

import javax.swing.*;//contains all classes
import javax.swing.border.Border;



public class App {
    public static void main(String[] args) {

        JLabel title;
        JPanel tpanel,panel1,panel2;

        String[] a = {"table1","table2","table3","table4","table5"};

        //label 
        Border border =  BorderFactory.createLineBorder(new Color(0,0,100),5);
        title = new JLabel();
        title.setText("Bill Counter");
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setVerticalAlignment(JLabel.TOP);
        title.setVisible(true);
        title.setFont(new Font("Serif",Font.BOLD,32));


        //tpanel
        tpanel = new JPanel();
        tpanel.setVisible(true);
        tpanel.setBackground(new Color(28, 145, 166));
        tpanel.setBounds(0, 0, 900, 80);
        tpanel.add(title);
        
        //panel
        panel1 = new JPanel();
        panel1.setVisible(true);
        panel1.setBackground(Color.white);
        panel1.setBounds(20,80, 150, 200);

        //panel2
        panel2 = new JPanel();
        panel2.setVisible(true);
        panel2.setBackground(Color.white);
        panel2.setBounds(20,300, 150, 200);



        JComboBox  menu = new JComboBox<>(a);
        menu.setVisible(true);

        panel1.add(menu);

        // frame 
        JFrame window = new JFrame();
        window.setTitle("Bill Counter");
        window.setSize(900,650);
        window.setLayout(null);
        window.setVisible(true);
        window.getContentPane().setBackground(new Color(28, 145, 166));
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(true);
        window.add(tpanel);
        window.add(panel1);
        window.add(panel2);
        

    }   
    
}       

