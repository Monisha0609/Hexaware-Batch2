package com.hexaware;

import java.util.Scanner;

public class Task12 {

    public static String generateEmail(String name, String orderNumber, String address, String deliveryDate) {
        return "Dear " + name + ",\n\n" +
               "Thank you for your order!\n\n" +
               "📦 Order Details:\n" +
               "Order Number : " + orderNumber + "\n" +
               "Delivery Address : " + address + "\n" +
               "Expected Delivery Date : " + deliveryDate + "\n\n" +
               "We hope you enjoy your purchase.\n\n" +
               "Regards,\n" +
               "HexaCourier Team";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       
        System.out.print("Enter Customer Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Order Number: ");
        String orderNumber = scanner.nextLine();

        System.out.print("Enter Delivery Address: ");
        String address = scanner.nextLine();

        System.out.print("Enter Expected Delivery Date (e.g., 2025-04-08): ");
        String deliveryDate = scanner.nextLine();

      
        String email = generateEmail(name, orderNumber, address, deliveryDate);

        System.out.println("\n======= Order Confirmation Email =======");
        System.out.println(email);

        scanner.close();
    }
}
