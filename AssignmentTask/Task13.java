package com.hexaware;

import java.util.HashMap;
import java.util.Scanner;

public class Task13{

    public static double calculateCost(String source, String destination, double weight) {
        
        HashMap<String, Integer> locationMap = new HashMap<>();
        locationMap.put("CityA", 0);
        locationMap.put("CityB", 100);
        locationMap.put("CityC", 200);
        locationMap.put("CityD", 300);

        int distance = Math.abs(locationMap.get(source) - locationMap.get(destination));
        double ratePerKgPerKm = 0.5; // ₹0.5 per kg per km

        return weight * distance * ratePerKgPerKm;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Source City (e.g., CityA): ");
        String source = scanner.nextLine();

        System.out.print("Enter Destination City (e.g., CityB): ");
        String destination = scanner.nextLine();

        System.out.print("Enter Parcel Weight in kg: ");
        double weight = scanner.nextDouble();

        double cost = calculateCost(source, destination, weight);

        System.out.printf("Shipping Cost from %s to %s for %.2f kg is ₹%.2f\n", source, destination, weight, cost);

        scanner.close();
    }
}
