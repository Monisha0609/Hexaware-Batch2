package com.hexaware;

import java.util.Random;
import java.util.Scanner;

public class Task14 {

    public static String generatePassword(int length) {
        // Character sets
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String digits = "0123456789";
        String special = "!@#$%^&*()-_=+<>?";

        String allChars = upper + lower + digits + special;

        StringBuilder password = new StringBuilder();
        Random random = new Random();

        password.append(upper.charAt(random.nextInt(upper.length())));
        password.append(lower.charAt(random.nextInt(lower.length())));
        password.append(digits.charAt(random.nextInt(digits.length())));
        password.append(special.charAt(random.nextInt(special.length())));

        // Fill the rest randomly
        for (int i = 4; i < length; i++) {
            password.append(allChars.charAt(random.nextInt(allChars.length())));
        }

        return password.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter desired password length (min 8): ");
        int length = scanner.nextInt();

        if (length < 8) {
            System.out.println("Password length must be at least 8 characters.");
        } else {
            String password = generatePassword(length);
            System.out.println("Your secure password: " + password);
        }

        scanner.close();
    }
}
