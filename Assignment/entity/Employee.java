package entity;

import java.sql.Timestamp;

public class Employee {

    private int empId;
    private String empName;
    private String email;
    private String phone;
    private String role;
    private int empSalary;
    private Timestamp createdAt;

    // Default constructor
    public Employee() {
    }

    // Parameterized constructor
    public Employee(int empId, String empName, String email, String phone, String role, int empSalary, Timestamp createdAt) {
        this.empId = empId;
        this.empName = empName;
        this.email = email;
        this.phone = phone;
        this.role = role;
        this.empSalary = empSalary;
        this.createdAt = createdAt;
    }

    // Getters and Setters
    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(int empSalary) {
        this.empSalary = empSalary;
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
        return "Employee [empId=" + empId + ", empName=" + empName + ", email=" + email
                + ", phone=" + phone + ", role=" + role + ", empSalary=" + empSalary + ", createdAt=" + createdAt + "]";
    }
}
