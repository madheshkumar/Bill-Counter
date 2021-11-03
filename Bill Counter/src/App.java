import java.awt.*;

import javax.swing.*;//contains all classes
import javax.swing.border.Border;



public class App {
    public static void main(String[] args) {

            JLabel title;
    JPanel tpanel,panel1,panel2,panel3,panel4,panel5,panel6;
    JRadioButton radiobutton1,radiobutton2;
    JTextArea txt1,txt2,txt3,txt4;
    txt1 = new JTextArea("MENU");
    txt2 = new JTextArea("QUANTITY");
    txt3 = new JTextArea("PRICE");
    txt4 = new JTextArea("TOTAL AMOUNT");
   // txt1.setSize(200, 9);
   // txt2.setSize(200, 9);
    ButtonGroup group = new ButtonGroup();
    radiobutton1 = new JRadioButton();
    radiobutton2 = new JRadioButton();
    group.add(radiobutton1);
    group.add(radiobutton2);
    radiobutton1.setText("VEGETARIAN");
    radiobutton2.setText("NON-VEGETARIAN");

    String[] a = {"table1","table2","table3","table4","table5"};

    //label 
   // Border border =  BorderFactory.createLineBorder(new Color(0,0,100),5);
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
    panel2.add(radiobutton1);
    panel2.add(radiobutton2);

     //pane3
     panel3 = new JPanel();
     panel3.setVisible(true);
     panel3.setBackground(Color.white);
     panel3.setBounds(200,70, 290, 430);
     panel3.setFont(new Font("Serif",Font.BOLD,8));
     panel3.add(txt1);
    //panel4
    panel4= new JPanel();
    panel4.setVisible(true);
    panel4.setBackground(Color.white);
    panel4.setBounds(530,70, 150, 430);
    panel4.setFont(new Font("Serif",Font.BOLD,8));
    panel4.add(txt2);

        //panel5
        panel5= new JPanel();
        panel5.setVisible(true);
        panel5.setBackground(Color.white);
        panel5.setBounds(700,70, 150, 430);
        panel5.setFont(new Font("Serif",Font.BOLD,8));
        panel5.add(txt3);
    //panel6
    panel6= new JPanel();
    panel6.setVisible(true);
    panel6.setBackground(Color.white);
    panel6.setBounds(20, 510 ,830, 80);
    panel6.setFont(new Font("Serif",Font.BOLD,8));
    panel6.add(txt4);

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
    window.add(panel3);
    window.add(panel4);
    window.add(panel5);
    window.add(panel6);
    

}   
      

