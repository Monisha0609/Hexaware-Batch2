//5. Write a Java program that uses a for loop to display all the orders for a specific customer.
package com.hexaware;

import java.sql.*;
import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/couriermanagement", "root", "Monisha@0903");

          
            System.out.print("Enter Customer Name: ");
            String customerName = scanner.nextLine();

           
            String query = "SELECT o.order_id, o.order_status, c.cust_name " +
                           "FROM Orders o " +
                           "JOIN Customer c ON o.cust_id = c.cust_id " +
                           "WHERE c.cust_name = ?";

            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, customerName);
            ResultSet rs = ps.executeQuery();

            // Display results
            boolean hasOrders = false;
            System.out.println("\nOrders for Customer: " + customerName);
            for (int count = 1; rs.next(); count++) { 
                hasOrders = true;
                System.out.println(count + ". Order ID: " + rs.getInt("order_id") + ", Status: " + rs.getString("order_status"));
            }

            if (!hasOrders) {
                System.out.println("No orders found for this customer.");
            }

           
            rs.close();
            ps.close();
            connection.close();
        } catch (Exception e) {
        	 System.out.println(e);
        } finally {
            scanner.close();
        }
    }
}
