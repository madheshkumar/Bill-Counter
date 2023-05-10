/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class BillDatabase {
    public Connection con;
    public PreparedStatement ps;
    public void Connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/billcounter", "root", "Madhesh@17");
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
    public void Insert(String name,String tno,Object menu,String meal,int Total){
        
    }
    public static void main(String[] args) {  
    }
}
