package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import dao.AssetManagementService;
import dao.AssetManagementServiceImpl;
import myexceptions.AssetNotFoundException;
import myexceptions.AssetNotMaintainException;

public class ExceptionTest {

    @Test
    public void testAssetNotFoundException() {
        AssetManagementService service = new AssetManagementServiceImpl();
        int invalidAssetId = -99; 
        String date = "2024-12-15";
        String description = "Service";
        double cost = 500;

        assertThrows(AssetNotMaintainException.class, () -> {
            service.performMaintenance(invalidAssetId, date, description, cost);
        }, "Expected AssetNotMaintainException for invalid asset ID.");
    }

    @Test
    public void testReservationWithInvalidEmployeeId() {
        AssetManagementService service = new AssetManagementServiceImpl();
        int validAssetId = 1;     
        int invalidEmployeeId = -10; 
        String resDate = "2024-12-01";
        String startDate = "2024-12-10";
        String endDate = "2024-12-20";

        assertThrows(AssetNotFoundException.class, () -> {
            service.reserveAsset(validAssetId, invalidEmployeeId, resDate, startDate, endDate);
        }, "Expected AssetNotFoundException for invalid employee ID.");
    }
}
