//3. Implement User Authentication 1. Create a login system for employees and customers using Java control flow statements.
package com.hexaware;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import java.sql.ResultSet;



public class Task3 {
    public static void main(String[] args)throws ClassNotFoundException,SQLException{
    	
    	 Class.forName("com.mysql.cj.jdbc.Driver"); 
    	 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/couriermanagement", "root", "Monisha@0903");
         
         
         Scanner scanner = new Scanner(System.in);
         System.out.print("Enter Username: ");
         String username = scanner.nextLine();  

         System.out.print("Enter Password (Phone Number): ");
         String password = scanner.nextLine(); 

         String sql = "SELECT e.emp_name AS user_name, e.phone AS password FROM employee e WHERE e.emp_name = ? AND e.phone = ? " +
                 "UNION " +
                 "SELECT c.cust_name AS user_name, c.phone AS password FROM customer c WHERE c.cust_name = ? AND c.phone = ?";

         PreparedStatement ps = connection.prepareStatement(sql);
         ps.setString(1, username); 
         ps.setString(2, password); 
         ps.setString(3, username); 
         ps.setString(4, password); 
         ResultSet rs = ps.executeQuery();
         if (rs.next()) {
             String userType = rs.getString("user_name"); 
             System.out.println("Login successful as: " + userType);
         } else {
             System.out.println("Invalid credentials");
         }

         rs.close();
         ps.close();
         connection.close();
         scanner.close();

   
    }
}
