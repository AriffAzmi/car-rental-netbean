/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrental.services;

import carrental.services.DBConnectionService;
import carrental.services.CurrentUserService;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ariffazmi
 */
public class AuthService {
    
    private static String myDb = "jdbc:derby://localhost:1527/car_rental";
    private static Connection DBconn;
    private static Statement stmt;
    private static PreparedStatement loginQuery;
    public static boolean isUserLoggedIn=false;
    
    public static void main(String[] args) {
        
    }
    
    public static boolean login(String username, String password){
        PreparedStatement ps;
        ResultSet rs;
        boolean checkUser = false;
        String query = "SELECT * FROM AYAM.USERS WHERE username ='"+username+"' AND password='"+password+"'";
        
        try {
            ps = DBConnectionService.getConnection().prepareStatement(query);
            rs = ps.executeQuery();
            
            if(rs.next())
            {
                checkUser = true;
                isUserLoggedIn = true;
                System.out.println("Successfully login");
                System.out.println(rs.getInt(1));
                CurrentUserService.setUserId(rs.getInt(1));
                CurrentUserService.setName(username);
            }
            else {
                System.out.println("login failed");
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return checkUser;
    }
    
    public static boolean register(String username, String password) throws SQLException {
        
        PreparedStatement ps;
        PreparedStatement ps1;
        ResultSet rs;
        ResultSet rs1;
        boolean successRegister = false;
        Integer new_id;
        Integer default_increment = new Integer(1);
        
        try {
            System.out.println("sini 1\n");
            ps1 = DBConnectionService.getConnection().prepareStatement("SELECT id FROM users ORDER BY id DESC FETCH FIRST ROW ONLY");
            rs1 = ps1.executeQuery();
            
            System.out.println("sini 2\n");

            if(rs1.next()) {
                
                System.out.println("sini 3\n");
                
                new_id = new Integer(rs1.getInt(1))+default_increment;
                System.out.println(new_id);
            }
            else {
                
                System.out.println("sini 4\n");
                new_id = new Integer(1);
            }
            
            System.out.println("sini 5\n");
            String query = "INSERT INTO users(id,username,password,is_admin) VALUES(?,?,?,?)";

            ps = DBConnectionService.getConnection().prepareStatement(query);
            ps.setInt(1, new_id);
            ps.setString(2, username);
            ps.setString(3, password);
            ps.setBoolean(4, Boolean.TRUE);
            
            ps.execute();
            successRegister = true;
            isUserLoggedIn = true;
            System.out.println("Successfully register");
            CurrentUserService.setUserId(new_id);
            CurrentUserService.setName(username);
            /**
            if()
            {
               
            }
            else {
                System.out.println("Registration failed");
            }
            * */
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return successRegister;
    }
}
