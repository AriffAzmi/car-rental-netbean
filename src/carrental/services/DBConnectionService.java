/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrental.services;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author ariffazmi
 */
public class DBConnectionService {
    
    public static void main(String[] args){
        
        getConnection();
    }
    
    public static Connection getConnection(){
     
        Connection con = null;
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost/car_rental", "ayam", "goreng");
            
            System.out.println("Connection created : "+con);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        return con;
    }
}
