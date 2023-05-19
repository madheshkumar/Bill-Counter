/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;
public class BillDatabase {
    public Connection con;
    public PreparedStatement ps;
    ArrayList<String> customers = new ArrayList<String>();
    public void Connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/billcounter", "root", "Madhesh@17");
            if(con!=null){
                System.out.println("Successfully Connected!");
            }
            else{
                System.out.println("Database not connected");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(BillCounter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void Insert(String name,String phno,Object tno,String meal,int total) throws SQLException{
        String tableno = tno.toString();
        String query="Insert into customer values('"+name+"','"+phno+"','"+tableno+"','"+meal+"',"+total+");";
        ps = con.prepareStatement(query);
        ps.executeUpdate();
    }
    public ArrayList Display() throws SQLException{
        String query1 = "Select name from customer";
        Statement s1 =con.createStatement();
        ResultSet rs = s1.executeQuery(query1);
        
        while(rs.next()){
            customers.add(rs.getString(1));
        }
        return customers;
    }
    public static void main(String[] args) {  
    }
}
