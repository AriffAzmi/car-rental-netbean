/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrental.services;

//import static carrental.services.LoginService.createConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ariffazmi
 */
public class RegistrationService {
    
    private static String myDb = "jdbc:derby://localhost:1527/car_rental";
    private static Connection DBconn;
    private static Statement stmt;
    private static PreparedStatement registrationQuery;
    
    public static void main(String[] args) {
        try {
            createConnection("ayam","goreng");
            doRegister("admin","admin",Boolean.TRUE);
        } catch (SQLException ex) {
        Logger.getLogger(RegistrationService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void createConnection(String username, String password) throws SQLException {
        
        try{
            DBconn = DriverManager.getConnection(myDb, username,password);
            System.out.println("Database connection successfully created");
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public static boolean doRegister(String username, String password, Boolean isAdmin) {
        
        try{
            
            stmt = DBconn.createStatement();
            registrationQuery = DBconn.prepareStatement("insert into users(id,username,password,is_admin) values(1,?,?,?)");
            registrationQuery.setString(1,username);
            registrationQuery.setString(2,password);
            registrationQuery.setBoolean(3, isAdmin);
            
            registrationQuery.execute();
            
            System.out.println("Super admin successfully created");
            
            return true;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
