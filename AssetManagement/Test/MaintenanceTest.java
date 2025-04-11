package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import dao.AssetManagementService;
import dao.AssetManagementServiceImpl;

public class MaintenanceTest {

    @Test
    public void testMaintenanceAddedSuccessfully() {
        AssetManagementService service = new AssetManagementServiceImpl();
        int assetId = 1; // Assume asset ID 1 exists
        String date = "2024-12-15";
        String description = "Battery Replacement";
        double cost = 300.00;

        boolean result = service.performMaintenance(assetId, date, description, cost);
        assertTrue(result, "Maintenance should be added successfully.");
    }
}
