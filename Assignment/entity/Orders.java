package entity;

import java.sql.Timestamp;

public class Orders {

    private int orderId;
    private int custId;
    private Integer courierId; // Nullable
    private int locationId;
    private String orderStatus;
    private int paymentId;
    private Timestamp createdAt;

    // Default constructor
    public Orders() {
    }

    // Parameterized constructor
    public Orders(int orderId, int custId, Integer courierId, int locationId, String orderStatus, int paymentId, Timestamp createdAt) {
        this.orderId = orderId;
        this.custId = custId;
        this.courierId = courierId;
        this.locationId = locationId;
        this.orderStatus = orderStatus;
        this.paymentId = paymentId;
        this.createdAt = createdAt;
    }

    // Getters and Setters
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public Integer getCourierId() {
        return courierId;
    }

    public void setCourierId(Integer courierId) {
        this.courierId = courierId;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    // toString method
    @Override
    public String toString() {
        return "Orders [orderId=" + orderId + ", custId=" + custId + ", courierId=" + courierId +
                ", locationId=" + locationId + ", orderStatus=" + orderStatus + ", paymentId=" +
                paymentId + ", createdAt=" + createdAt + "]";
    }
}
