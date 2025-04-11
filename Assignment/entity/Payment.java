package entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Payment {

    private int paymentId;
    private int custId;
    private BigDecimal amount;
    private String paymentMethod;
    private String paymentStatus;
    private Timestamp createdAt;

    // Default constructor
    public Payment() {
    }

    // Parameterized constructor
    public Payment(int paymentId, int custId, BigDecimal amount, String paymentMethod, String paymentStatus, Timestamp createdAt) {
        this.paymentId = paymentId;
        this.custId = custId;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
        this.createdAt = createdAt;
    }

    // Getters and Setters
    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
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
        return "Payment [paymentId=" + paymentId + ", custId=" + custId + ", amount=" + amount
                + ", paymentMethod=" + paymentMethod + ", paymentStatus=" + paymentStatus
                + ", createdAt=" + createdAt + "]";
    }
}
