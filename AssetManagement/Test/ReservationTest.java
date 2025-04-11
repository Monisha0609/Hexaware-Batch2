package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import dao.AssetManagementService;
import dao.AssetManagementServiceImpl;

public class ReservationTest {

    @Test
    public void testReservationSuccessfully() {
        AssetManagementService service = new AssetManagementServiceImpl();
        int assetId = 1;    // Ensure asset ID exists
        int employeeId = 2; // Ensure employee ID exists
        String reservationDate = "2024-12-01";
        String startDate = "2024-12-10";
        String endDate = "2024-12-20";

        boolean result = service.reserveAsset(assetId, employeeId, reservationDate, startDate, endDate);
        assertTrue(result, "Reservation should be successful.");
    }
}
