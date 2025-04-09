package application;

import entity.*;
import shelter.*;
import donation.*;
import db.*;
import exception.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        PetShelter shelter = new PetShelter();
        Scanner sc = new Scanner(System.in);

        // Add pet with validation
        System.out.println("Enter pet type (Dog/Cat): ");
        String type = sc.nextLine();

        System.out.println("Enter pet name: ");
        String name = sc.nextLine();

        System.out.println("Enter pet age: ");
        int age = sc.nextInt();
        if (age <= 0) throw new InvalidPetAgeException("Age must be a positive number.");

        System.out.print("Enter pet breed: ");
        String breed = sc.next();

        Pet pet = null;

        if (type.equalsIgnoreCase("Dog")) {
            System.out.print("Enter dog breed (specific): ");
            String dogBreed = sc.next();
            pet = new Dog(name, age, breed, dogBreed);
        } else if (type.equalsIgnoreCase("Cat")) {
            System.out.print("Enter cat color: ");
            String catColor = sc.next();
            pet = new Cat(name, age, breed, catColor);
        } else {
            System.out.println("Invalid pet type.");
        }

        if (pet != null) {
            shelter.addPet(pet);
            System.out.println("Pet added successfully.");
        }

        // Record cash donation
        System.out.print("Enter donor name: ");
        String donorName = sc.next();

        System.out.print("Enter donation amount: ");
        double amount = sc.nextDouble();

        if (amount < 10) {
            throw new InsufficientFundsException("Minimum donation is $10.");
        }

        CashDonation cd = new CashDonation(donorName, amount, LocalDateTime.now());
        cd.recordDonation();

        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(
            "INSERT INTO Donations (DonorName, DonationType, DonationAmount, DonationDate) VALUES (?, ?, ?, NOW())"
        );
        ps.setString(1, donorName);
        ps.setString(2, "Cash");
        ps.setDouble(3, amount);
        ps.executeUpdate();

        System.out.println("Donation recorded successfully.");

        conn.close();
        sc.close();
    }
}
