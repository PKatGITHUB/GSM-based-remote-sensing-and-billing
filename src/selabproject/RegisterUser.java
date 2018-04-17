/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selabproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class RegisterUser {
    
    boolean registerNewUser(String firstName,String lastName,String userName,String emailId,String password,String userType,String deviceId){
        
        String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
        String DB_URL = "jdbc:mysql://localhost:3306/selab";

        //  Database credentials
        String USER = "root";
        String PASS = "password";

        Connection conn = null;
        Statement stmt = null;
        try{
           //STEP 2: Register JDBC driver
           Class.forName("com.mysql.jdbc.Driver");

           //STEP 3: Open a connection
           System.out.println("Connecting to a selected database...");
           conn = DriverManager.getConnection(DB_URL, USER, PASS);
           System.out.println("Connected database successfully...");
           
            
            stmt=conn.createStatement();
            String insertBasicInformation="INSERT INTO basic_user_information " + 
                    "VALUES ('" + firstName + "','" + lastName + "','" + userName + "','" + emailId + "','" + password + "','" + userType + "')";
            stmt.executeUpdate(insertBasicInformation);
            return true;
            
        }catch(SQLException e){
            System.out.print("Exception");
        } catch (Exception ex) {
            Logger.getLogger(SELabGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
}
