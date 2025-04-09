package com.hexaware;

import java.util.Scanner;

public class Task10 {

    public static boolean validateCustomer(String data, String detailType) {
        switch (detailType.toLowerCase()) {
            case "name":
                return data.matches("([A-Z][a-z]+)(\\s[A-Z][a-z]+)*");

            case "address":
                return data.matches("[A-Za-z0-9\\s,.-]+");

            case "phone":
                return data.matches("\\d{3}\\d{3}\\d{4}");

            default:
                System.out.println("Unknown detail type: " + detailType);
                return false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 🔁 Get user input
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();

        System.out.print("Enter address: ");
        String address = scanner.nextLine();

        System.out.print("Enter phone number (##########): ");
        String phone = scanner.nextLine();

     
        boolean isNameValid = validateCustomer(name, "name");
        boolean isAddressValid = validateCustomer(address, "address");
        boolean isPhoneValid = validateCustomer(phone, "phone");

        System.out.println("\nValidation Results:");
        System.out.println("Name    : " + name + " --> " + (isNameValid ? "Valid " : "Invalid "));
        System.out.println("Address : " + address + " --> " + (isAddressValid ? "Valid " : "Invalid "));
        System.out.println("Phone   : " + phone + " --> " + (isPhoneValid ? "Valid " : "Invalid "));

        scanner.close();
    }
}
