package dao;

import entity.Asset;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;

public class AssetManagementServiceImpl implements AssetManagementService {

    private Connection connection;

    public AssetManagementServiceImpl() {
        connection = DBConnection.getConnection();
    }

    // 3.1 Add Asset
    @Override
    public boolean addAsset(Asset asset) {
        String query = "INSERT INTO assets (name, type, serial_number, purchase_date, location, status, owner_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
        	Date purchaseDate = Date.valueOf(asset.getPurchaseDate());
            ps.setString(1, asset.getName());
            ps.setString(2, asset.getType());
            ps.setString(3, asset.getSerialNumber());
            ps.setDate(4, purchaseDate);
            ps.setString(5, asset.getLocation());
            ps.setString(6, asset.getStatus());
            ps.setInt(7, asset.getOwnerId());
            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // 3.2 Update Asset
    @Override
    public boolean updateAsset(Asset asset) {
        String query = "UPDATE assets SET name = ?, type = ?, serial_number = ?, purchase_date = ?, location = ?, status = ?, owner_id = ? WHERE asset_id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
        	Date purchaseDate = Date.valueOf(asset.getPurchaseDate());
            ps.setString(1, asset.getName());
            ps.setString(2, asset.getType());
            ps.setString(3, asset.getSerialNumber());
            ps.setDate(4, purchaseDate);
            ps.setString(5, asset.getLocation());
            ps.setString(6, asset.getStatus());
            ps.setInt(7, asset.getOwnerId());
            ps.setInt(8, asset.getAssetId());
            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // 3.3 Delete Asset
    @Override
    public boolean deleteAsset(int assetId) {
        String query = "DELETE FROM assets WHERE asset_id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, assetId);
            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // 3.4 Allocate Asset
    @Override
    public boolean allocateAsset(int assetId, int employeeId, String allocationDate) {
        String query = "INSERT INTO asset_allocations (asset_id, employee_id, allocation_date) VALUES (?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, assetId);
            ps.setInt(2, employeeId);
            ps.setString(3, allocationDate);
            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // 3.5 Deallocate Asset
    @Override
    public boolean deallocateAsset(int assetId, int employeeId, String returnDate) {
        String query = "UPDATE asset_allocations SET return_date = ? WHERE asset_id = ? AND employee_id = ? AND return_date IS NULL";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, returnDate);
            ps.setInt(2, assetId);
            ps.setInt(3, employeeId);
            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // 3.6 Perform Maintenance
    @Override
    public boolean performMaintenance(int assetId, String maintenanceDate, String description, double cost) {
        String query = "INSERT INTO maintenance_records (asset_id, maintenance_date, description, cost) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, assetId);
            ps.setString(2, maintenanceDate);
            ps.setString(3, description);
            ps.setDouble(4, cost);
            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // 3.7 Reserve Asset
    @Override
    public boolean reserveAsset(int assetId, int employeeId, String reservationDate, String startDate, String endDate) {
        String query = "INSERT INTO reservations (asset_id, employee_id, reservation_date, start_date, end_date, status) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, assetId);
            ps.setInt(2, employeeId);
            ps.setString(3, reservationDate);
            ps.setString(4, startDate);
            ps.setString(5, endDate);
            ps.setString(6, "pending");
            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // 3.8 Withdraw Reservation
    @Override
    public boolean withdrawReservation(int reservationId) {
        String query = "UPDATE reservations SET status = ? WHERE reservation_id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, "canceled");
            ps.setInt(2, reservationId);
            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

	
}
