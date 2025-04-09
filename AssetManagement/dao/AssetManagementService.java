package dao;

import entity.Asset;

public interface AssetManagementService {

    // a. Add Asset
    boolean addAsset(Asset asset);

    // b. Update Asset
    boolean updateAsset(Asset asset);

    // c. Delete Asset
    boolean deleteAsset(int assetId);

    // d. Allocate Asset
    boolean allocateAsset(int assetId, int employeeId, String allocationDate);

    // e. Deallocate Asset
    boolean deallocateAsset(int assetId, int employeeId, String returnDate);

    // f. Perform Maintenance
    boolean performMaintenance(int assetId, String maintenanceDate, String description, double cost);

    // g. Reserve Asset
    boolean reserveAsset(int assetId, int employeeId, String reservationDate, String startDate, String endDate);

    // h. Withdraw Reservation
    boolean withdrawReservation(int reservationId);
}
