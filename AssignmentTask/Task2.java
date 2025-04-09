//2. Implement a switch-case statement to categorize parcels based on their weight into "Light," "Medium," or "Heavy."
package com.hexaware;
import java.util.Scanner;

public class Task2 {

	public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);
	        
	        System.out.print("Enter the parcel weight in kg: ");
	        double weight = scanner.nextDouble();
	        
	        String category;
	        switch ((int) weight) {
	            case 0, 1, 2:
	                category = "Light";
	                break;
	            case 3, 4, 5:
	                category = "Medium";
	                break;
	            default:
	                category = "Heavy";
	        }
	        
	        System.out.println("The parcel is categorized as: " + category);
	        
	        scanner.close();

	}

}
