package application;

import entity.*;
import shelter.*;
import donation.*;
import db.*;
import exception.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        PetShelter shelter = new PetShelter();
        Scanner sc = new Scanner(System.in);

        try (Connection conn = DBConnection.getConnection()) {

            // 1. Display Pet Listings
            System.out.println("Available Pets for Adoption:");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Pets");

          
            while (rs.next()) {
                int petId = rs.getInt("PetID");
                String petName = rs.getString("Name");
                int petAge = rs.getInt("Age");
                String breed = rs.getString("Breed");
                String type = rs.getString("Type");

                System.out.println("Pet ID: " + petId + ", Name: " + petName +
                        ", Age: " + petAge + ", Breed: " + breed + ", Type: " + type);
            }
        
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
            throw new InsufficientFundsException("Minimum donation is Rs.10.");
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


         // 3. Adoption Event Registration
        System.out.println("\nUpcoming Adoption Events:");
        ResultSet eventRs = stmt.executeQuery("SELECT * FROM AdoptionEvents");
        while (eventRs.next()) {
            System.out.println("Event ID: " + eventRs.getInt("EventID") +
                    ", Name: " + eventRs.getString("EventName") +
                    ", Date: " + eventRs.getDate("EventDate"));
        }

        System.out.print("Enter Event ID to register for: ");
        int eventId = sc.nextInt();
        sc.nextLine(); 
        System.out.print("Enter your name to register: ");
        String participantName = sc.nextLine();

        PreparedStatement partStmt = conn.prepareStatement(
            "INSERT INTO Participants (ParticipantName, EventID) VALUES (?, ?)"
        );
        partStmt.setString(1, participantName);
        partStmt.setInt(2, eventId);
        partStmt.executeUpdate();
        System.out.println("Successfully registered for the event!");

            
        conn.close();
        sc.close();
    }
}
