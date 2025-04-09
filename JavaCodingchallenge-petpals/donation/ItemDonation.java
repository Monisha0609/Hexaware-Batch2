package donation;

import db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;

public class ItemDonation extends Donation {
    private String itemType;

    public ItemDonation(String donorName, String itemType) {
        super(donorName, 0.0);
        this.itemType = itemType;
    }

    public String getItemType() {
        return itemType;
    }

    @Override
    public void recordDonation() {
        System.out.println("Item donation by " + getDonorName() +
                           " of type: " + itemType);

        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO Donations (DonorName, DonationType, DonationAmount, DonationDate, ItemType) VALUES (?, ?, ?, ?, ?)"
            );
            ps.setString(1, getDonorName());
            ps.setString(2, "Item");
            ps.setDouble(3, 0.0);
            ps.setObject(4, LocalDateTime.now());
            ps.setString(5, itemType);

            ps.executeUpdate();
            System.out.println("Item donation saved to database.");
        } catch (Exception e) {
            System.out.println("Error saving item donation: " + e.getMessage());
        }
    }
}
