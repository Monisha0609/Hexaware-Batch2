package entity;

public class Parcel {

    private int parcelId;
    private int orderId;
    private double weight;
    private String dimensions;
    private String description;
    private String status;

    // Default constructor
    public Parcel() {
    }

    // Parameterized constructor
    public Parcel(int parcelId, int orderId, double weight, String dimensions, String description, String status) {
        this.parcelId = parcelId;
        this.orderId = orderId;
        this.weight = weight;
        this.dimensions = dimensions;
        this.description = description;
        this.status = status;
    }

    // Getters and Setters
    public int getParcelId() {
        return parcelId;
    }

    public void setParcelId(int parcelId) {
        this.parcelId = parcelId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // toString method
    @Override
    public String toString() {
        return "Parcel [parcelId=" + parcelId + ", orderId=" + orderId + ", weight=" + weight +
                ", dimensions=" + dimensions + ", description=" + description + ", status=" + status + "]";
    }
}
