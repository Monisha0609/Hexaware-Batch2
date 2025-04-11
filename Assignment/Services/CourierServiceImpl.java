package Services;

import entity.*;
import java.util.*;

public class CourierServiceImpl implements CourierService {

    private Map<Integer, customer> customerMap = new HashMap<>();
    private Map<Integer, Courier> courierMap = new HashMap<>();
    private Map<Integer, Employee> employeeMap = new HashMap<>();
    private Map<Integer, Location> locationMap = new HashMap<>();
    private Map<Integer, Payment> paymentMap = new HashMap<>();
    private Map<Integer, Orders> orderMap = new HashMap<>();
    private Map<Integer, Parcel> parcelMap = new HashMap<>();

    // ------------------ Customer ------------------
    @Override
    public void addcustomer(customer customer) {
        customerMap.put(customer.getCustId(), customer);
    }

    @Override
    public customer getCustomerById(int custId) {
        return customerMap.get(custId);
    }

    // ------------------ Courier ------------------
    @Override
    public void addCourier(Courier courier) {
        courierMap.put(courier.getCourierId(), courier);
    }

    @Override
    public Courier getCourierById(int courierId) {
        return courierMap.get(courierId);
    }

    // ------------------ Employee ------------------
    @Override
    public void addEmployee(Employee employee) {
        employeeMap.put(employee.getEmpId(), employee);
    }

    @Override
    public Employee getEmployeeById(int empId) {
        return employeeMap.get(empId);
    }

    // ------------------ Location ------------------
    @Override
    public void addLocation(Location location) {
        locationMap.put(location.getLocationId(), location);
    }

    @Override
    public Location getLocationById(int locationId) {
        return locationMap.get(locationId);
    }

    // ------------------ Payment ------------------
    @Override
    public void addPayment(Payment payment) {
        paymentMap.put(payment.getPaymentId(), payment);
    }

    @Override
    public Payment getPaymentById(int paymentId) {
        return paymentMap.get(paymentId);
    }

    // ------------------ Orders ------------------
    @Override
    public void addOrder(Orders order) {
        orderMap.put(order.getOrderId(), order);
    }

    @Override
    public Orders getOrderById(int orderId) {
        return orderMap.get(orderId);
    }

    // ------------------ Parcel ------------------
    @Override
    public void addParcel(Parcel parcel) {
        parcelMap.put(parcel.getParcelId(), parcel);
    }

    @Override
    public Parcel getParcelById(int parcelId) {
        return parcelMap.get(parcelId);
    }

    // ------------------ Assign Courier ------------------
    @Override
    public void assignCourierToOrder(int orderId, int courierId) {
        Orders order = orderMap.get(orderId);
        if (order != null) {
            order.setCourierId(courierId);
            orderMap.put(orderId, order);
        }
    }

    // ------------------ Update Parcel Status ------------------
    @Override
    public void updateParcelStatus(int parcelId, String status) {
        Parcel parcel = parcelMap.get(parcelId);
        if (parcel != null) {
            parcel.setStatus(status);
            parcelMap.put(parcelId, parcel);
        }
    }

	@Override
	public void addCustomer(customer customer) {
		// TODO Auto-generated method stub
		
	}
}
