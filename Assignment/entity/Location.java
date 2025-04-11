package entity;

public class Location {

    private int locationId;
    private String name;
    private String address;
    private String city;
    private String state;
    private String zipCode;

    // Default constructor
    public Location() {
    }

    // Parameterized constructor
    public Location(int locationId, String name, String address, String city, String state, String zipCode) {
        this.locationId = locationId;
        this.name = name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    // Getters and Setters
    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    // toString method
    @Override
    public String toString() {
        return "Location [locationId=" + locationId + ", name=" + name + ", address=" + address
                + ", city=" + city + ", state=" + state + ", zipCode=" + zipCode + "]";
    }
}
