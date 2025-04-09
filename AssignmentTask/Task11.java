package com.hexaware;

import java.util.Scanner;

public class Task11{

   
    public static String capitalizeWords(String input) {
        String[] words = input.trim().toLowerCase().split("\\s+");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (word.length() > 0) {
                result.append(Character.toUpperCase(word.charAt(0)))
                      .append(word.substring(1)).append(" ");
            }
        }
        return result.toString().trim();
    }

   
    public static String formatAddress(String street, String city, String state, String zip) {
        String formattedStreet = capitalizeWords(street);
        String formattedCity = capitalizeWords(city);
        String formattedState = state.toUpperCase();
        String formattedZip = zip.trim();

        return formattedStreet + ", " + formattedCity + ", " + formattedState + " " + formattedZip;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter street: ");
        String street = scanner.nextLine();

        System.out.print("Enter city: ");
        String city = scanner.nextLine();

        System.out.print("Enter state (abbreviation or full): ");
        String state = scanner.nextLine();

        System.out.print("Enter zip code: ");
        String zip = scanner.nextLine();

       
        String formattedAddress = formatAddress(street, city, state, zip);
        System.out.println("\nFormatted Address:");
        System.out.println(formattedAddress);

        scanner.close();
    }
}
