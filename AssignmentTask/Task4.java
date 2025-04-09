//4. Implement Courier Assignment Logic 1. Develop a mechanism to assign couriers to shipments based on predefined criteria (e.g., proximity, load capacity) using loops.
package com.hexaware;

import java.sql.*;

public class Task4 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
    	 Class.forName("com.mysql.cj.jdbc.Driver"); 
    	 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/couriermanagement", "root", "Monisha@0903");
 
    	  // unassigned orders
    	   String getUnassignedOrders = "SELECT order_id FROM Orders WHERE courier_id IS NULL";
    	   Statement stmt = connection.createStatement();
    	   ResultSet orders = stmt.executeQuery(getUnassignedOrders);

    	   while (orders.next()) {
    	   int orderId = orders.getInt("order_id");

    	   // available couriers
    	   String getCourier = "SELECT courier_id FROM Courier WHERE status = 'Available'  ORDER BY RAND() LIMIT 1";
    	   ResultSet couriers = connection.createStatement().executeQuery(getCourier);

    	   if (couriers.next()) {
    	   int courierId = couriers.getInt("courier_id");

    	    //Assign courier to order
    	    String assignQuery = "UPDATE Orders SET courier_id = ? WHERE order_id = ?";
    	    PreparedStatement assignStmt = connection.prepareStatement(assignQuery);
    	    assignStmt.setInt(1, courierId);
    	    assignStmt.setInt(2, orderId);
    	    int rowsUpdated = assignStmt.executeUpdate();

    	    if (rowsUpdated > 0) {
    	       System.out.println("Assigned courier " + courierId + " to order " + orderId);
    	         }
    	    } else {
    	       System.out.println("No available couriers for order " + orderId);
    	    }
    	    }

    	    connection.close();

    	    } 
    	     
    	 }

         
        

