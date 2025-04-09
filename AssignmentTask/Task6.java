//6. Implement a while loop to track the real-time location of a courier until it reaches its destination.
package com.hexaware;

import java.sql.*;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Task6 {
    public static void main(String[] args) {
        try {
           
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/couriermanagement", "root", "Monisha@0903");

          
            String fetchOrders = "SELECT order_id, courier_id FROM Orders WHERE order_status = 'In Transit'";
            PreparedStatement fetchOrdersPs = connection.prepareStatement(fetchOrders);
            ResultSet ordersResultSet = fetchOrdersPs.executeQuery();

            Random random = new Random();

            while (ordersResultSet.next()) {
                int orderId = ordersResultSet.getInt("order_id");
                int courierId = ordersResultSet.getInt("courier_id");

                System.out.println("\nTracking Order ID: " + orderId + " (Courier ID: " + courierId + ")");

               
                int locationProgress = 0; 
                while (locationProgress < 100) {
                    locationProgress += random.nextInt(30) + 10; 
                    if (locationProgress > 100) {
                        locationProgress = 100;
                    }

                    System.out.println("Courier " + courierId + " is " + locationProgress + "% towards the destination...");
                    
                   
                    TimeUnit.SECONDS.sleep(2);
                }

                
                String updateOrderStatus = "UPDATE Orders SET order_status = 'Delivered' WHERE order_id = ?";
                PreparedStatement updateOrderPs = connection.prepareStatement(updateOrderStatus);
                updateOrderPs.setInt(1, orderId);
                updateOrderPs.executeUpdate();

                
                String updateCourierStatus = "UPDATE Courier SET status = 'Available' WHERE courier_id = ?";
                PreparedStatement updateCourierPs = connection.prepareStatement(updateCourierStatus);
                updateCourierPs.setInt(1, courierId);
                updateCourierPs.executeUpdate();

                System.out.println("Order " + orderId + " has been DELIVERED!\n");
            }

           
            ordersResultSet.close();
            fetchOrdersPs.close();
            connection.close();
            
        } catch (Exception e) {
        	 System.out.println(e);
        }
    }
}
