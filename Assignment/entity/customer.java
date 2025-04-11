package entity;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class customer {

    private int custId;
    private String custName;
    private String email;
    private String phone;
    private String address;
    private Timestamp createdAt;

    // Default constructor
    public customer(String name, String email2, String phone2, String address2) {
    }

    // Parameterized constructor
    public customer(int custId, String custName, String email, String phone, String address, Timestamp createdAt) {
        this.custId = custId;
        this.custName = custName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.createdAt = createdAt;
    }

    public customer(int int1, String string, String string2, String string3, String string4,
			LocalDateTime localDateTime) {
		// TODO Auto-generated constructor stub
	}

	// Getters and Setters
    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
        return "Customer [custId=" + custId + ", custName=" + custName + ", email=" + email + ", phone=" + phone
                + ", address=" + address + ", createdAt=" + createdAt + "]";
    }
}
