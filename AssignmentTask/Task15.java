package com.hexaware;

import java.util.Scanner;

public class Task15 {

    public static boolean isSimilar(String addr1, String addr2) {
        
        addr1 = addr1.toLowerCase().trim();
        addr2 = addr2.toLowerCase().trim();

      
        String[] words1 = addr1.split("\\s+");
        String[] words2 = addr2.split("\\s+");

        int matchCount = 0;

        for (String w1 : words1) {
            for (String w2 : words2) {
                if (w1.equals(w2)) {
                    matchCount++;
                }
            }
        }

        // If 50% or more words match, consider similar
        int minLength = Math.min(words1.length, words2.length);
        return ((double) matchCount / minLength) >= 0.5;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       
        String[] addressList = {
            "123 Main Street City A",
            "24 Main Road City A",
            "12 1st Cross Street City B",
            "123 Main St City A",
            "25 Market Road City C"
        };

        System.out.print("Enter address to compare: ");
        String inputAddress = scanner.nextLine();

        System.out.println("\n Similar Addresses:");
        for (String addr : addressList) {
            if (isSimilar(inputAddress, addr)) {
                System.out.println(addr);
            }
        }

        scanner.close();
    }
}
