
package app;

import dao.AssetManagementService;
import dao.AssetManagementServiceImpl;
import entity.Asset;
import myexceptions.AssetNotFoundException;
import myexceptions.AssetNotMaintainException;

import java.util.Scanner;

public class AssetManagementSystem {
    public static void main(String[] args)throws AssetNotMaintainException, AssetNotFoundException {
        Scanner sc = new Scanner(System.in);
        AssetManagementService service = new AssetManagementServiceImpl();

        while (true) {
            System.out.println("\n========= Asset Management System =========");
            System.out.println("1. Add Asset");
            System.out.println("2. Update Asset");
            System.out.println("3. Delete Asset");
            System.out.println("4. Allocate Asset");
            System.out.println("5. Deallocate Asset");
            System.out.println("6. Perform Maintenance");
            System.out.println("7. Reserve Asset");
            System.out.println("8. Withdraw Reservation");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            try {
                switch (choice) {
                    case 1:
                        System.out.println("Enter Asset Details:");
                        System.out.print("Name: ");
                        String name = sc.nextLine();
                        System.out.print("Type: ");
                        String type = sc.nextLine();
                        System.out.print("Serial Number: ");
                        String serial = sc.nextLine();
                        System.out.print("Purchase Date (YYYY-MM-DD): ");
                        String purchase = sc.nextLine();
                        System.out.print("Location: ");
                        String location = sc.nextLine();
                        System.out.print("Status (in use, decommissioned, under maintenance): ");
                        String status = sc.nextLine();
                        System.out.print("Owner ID: ");
                        int owner = sc.nextInt();

                        Asset newAsset = new Asset(0, name, type, serial, purchase, location, status, owner);
                        boolean added = service.addAsset(newAsset);
                        System.out.println(added ? "Asset added successfully." : "Asset addition failed.");
                        break;

                    case 2:
                        System.out.print("Enter Asset ID to update: ");
                        int upId = sc.nextInt();
                        sc.nextLine(); // consume newline
                        System.out.print("New Name: ");
                        String newName = sc.nextLine();
                        System.out.print("New Type: ");
                        String newType = sc.nextLine();
                        System.out.print("New Serial Number: ");
                        String newSerial = sc.nextLine();
                        System.out.print("New Purchase Date (YYYY-MM-DD): ");
                        String newPurchase = sc.nextLine();
                        System.out.print("New Location: ");
                        String newLocation = sc.nextLine();
                        System.out.print("New Status: ");
                        String newStatus = sc.nextLine();
                        System.out.print("New Owner ID: ");
                        int newOwner = sc.nextInt();

                        Asset updatedAsset = new Asset(upId, newName, newType, newSerial, newPurchase, newLocation, newStatus, newOwner);
                        boolean updated = service.updateAsset(updatedAsset);
                        System.out.println(updated ? "Asset updated successfully." : "Asset update failed.");
                        break;

                    case 3:
                        System.out.print("Enter Asset ID to delete: ");
                        int delId = sc.nextInt();
                        boolean deleted = service.deleteAsset(delId);
                        System.out.println(deleted ? "Asset deleted successfully." : "Asset deletion failed.");
                        break;

                    case 4:
                        System.out.print("Enter Asset ID: ");
                        int allocAsset = sc.nextInt();
                        System.out.print("Enter Employee ID: ");
                        int allocEmp = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter Allocation Date (YYYY-MM-DD): ");
                        String allocDate = sc.nextLine();
                        boolean allocated = service.allocateAsset(allocAsset, allocEmp, allocDate);
                        System.out.println(allocated ? "Asset allocated." : "Allocation failed.");
                        break;

                    case 5:
                        System.out.print("Enter Asset ID: ");
                        int deAsset = sc.nextInt();
                        System.out.print("Enter Employee ID: ");
                        int deEmp = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter Return Date (YYYY-MM-DD): ");
                        String returnDate = sc.nextLine();
                        boolean deallocated = service.deallocateAsset(deAsset, deEmp, returnDate);
                        System.out.println(deallocated ? "Asset deallocated." : "Deallocation failed.");
                        break;

                    case 6:
                        System.out.print("Enter Asset ID: ");
                        int mAsset = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter Maintenance Date (YYYY-MM-DD): ");
                        String mDate = sc.nextLine();
                        System.out.print("Enter Description: ");
                        String mDesc = sc.nextLine();
                        System.out.print("Enter Cost: ");
                        double cost = sc.nextDouble();
                        boolean maintained = service.performMaintenance(mAsset, mDate, mDesc, cost);
                        System.out.println(maintained ? "Maintenance record added." : "Maintenance failed.");
                        break;

                    case 7:
                        System.out.print("Enter Asset ID: ");
                        int resAsset = sc.nextInt();
                        System.out.print("Enter Employee ID: ");
                        int resEmp = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter Reservation Date (YYYY-MM-DD): ");
                        String resDate = sc.nextLine();
                        System.out.print("Enter Start Date (YYYY-MM-DD): ");
                        String startDate = sc.nextLine();
                        System.out.print("Enter End Date (YYYY-MM-DD): ");
                        String endDate = sc.nextLine();
                        boolean reserved = service.reserveAsset(resAsset, resEmp, resDate, startDate, endDate);
                        System.out.println(reserved ? "Asset reserved." : "Reservation failed.");
                        break;

                    case 8:
                        System.out.print("Enter Reservation ID: ");
                        int resId = sc.nextInt();
                        boolean withdrawn = service.withdrawReservation(resId);
                        System.out.println(withdrawn ? "Reservation withdrawn." : "Withdrawal failed.");
                        break;

                    case 9:
                        System.out.println("Exiting... Goodbye!");
                        sc.close();
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Invalid choice! Try again.");
                }
            } catch (Exception ex) {
                System.out.println("Unexpected Error: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }
   
}
