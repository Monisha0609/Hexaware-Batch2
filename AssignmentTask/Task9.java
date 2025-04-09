//Parcel tracking using 2D array
package com.hexaware;

import java.util.Scanner;

public class Task9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] parcels = {
            {"ID001", "In Transit"},
            {"ID002", "Out for Delivery"},
            {"ID003", "Delivered"},
            {"ID004", "In Transit"},
            {"ID005", "Delivered"}
        };

        System.out.print("Enter your parcel tracking number: ");
        String trackingnumber = scanner.nextLine();

        boolean found = false;

        for (int i = 0; i < parcels.length; i++) {
            if (parcels[i][0].equals(trackingnumber)) {
                found = true;
                String status = parcels[i][1];

                switch (status) {
                    case "In Transit":
                        System.out.println("Parcel is currently in transit.");
                        break;
                    case "Out for Delivery":
                        System.out.println("Parcel is out for delivery.");
                        break;
                    case "Delivered":
                        System.out.println("Parcel has been delivered.");
                        break;
                    default:
                        System.out.println("Status unknown.");
                }
                break; 
            }
        }

     
        if (!found) {
            System.out.println("Tracking number not found.");
        }

        scanner.close();
    }
}
