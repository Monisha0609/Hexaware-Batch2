CREATE DATABASE CourierManagement;
USE CourierManagement;

-- User Table (Customers)
CREATE TABLE Customer (
    cust_id INT AUTO_INCREMENT PRIMARY KEY,
    cust_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    phone VARCHAR(20) UNIQUE NOT NULL,
    address VARCHAR(200) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
INSERT INTO customer (cust_name, email, phone, address) VALUES
('Monisha', 'monisha123@gmail.com', '9790438189', '123 Main Street, City A'),
('Sam', 'sam456@gmail.com', '8754758189', '24 Main Road, City A'),
('Mary', 'mary789@gmail.com', '9629772554', '12 1st Cross St, City B'),
('Saran', 'saran234@gmail.com', '6374469079', '20 1st East Road, City B');
INSERT INTO customer (Cust_id,cust_name, email, phone, address) VALUES
(5,'Jansi','jansi@gmail.com', '9003455502', '4 10th East Main Road, City C');

alter table customer add column type enum('sender', 'receiver')Default Null;
SET SQL_SAFE_UPDATES = 0;

UPDATE customer SET type = 'Receiver' WHERE cust_name IN ('Monisha', 'Sam');
UPDATE customer SET type = 'Sender' WHERE type IS NULL;

SET SQL_SAFE_UPDATES = 1;  


-- Courier Table (Delivery personnel)
CREATE TABLE Courier (
    courier_id INT AUTO_INCREMENT PRIMARY KEY,
    person_name VARCHAR(100) NOT NULL,
    phone VARCHAR(20) UNIQUE NOT NULL,
    vehicle_number VARCHAR(50) UNIQUE NOT NULL,
    status ENUM('Available', 'On Delivery', 'Inactive') DEFAULT 'Available',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

Insert into Courier(person_name,phone,vehicle_number,status)values
('Jack', '8888888001', 'TN 07 AB 1234', 'Available'),
('John', '8888888002', 'KA 05 CD 5678', 'On Delivery'),
('Sarah', '8888888003', 'MH 12 EF 9012', 'Available'),
('Angel', '8888888004', 'DL 08 GH 3456', 'Inactive'),
('Akash', '8888888005', 'WB 10 IJ 7890', 'Available');

alter table courier add column  servicetype enum('Same-Day Delivery',
'Next-Day Delivery',
'Standard Shipping',
'Express Delivery',
'International Shipping',
'Local Delivery')Default Null;

Update courier 
Set servicetype = 
    Case 
        When courier_id = 1 Then 'Express Delivery'
        When courier_id = 2 Then 'Same-Day Delivery'
        When courier_id = 3 Then 'Next-Day Delivery'
        When courier_id = 4 Then 'Standard Shipping'
        When courier_id = 5 Then 'Next-Day Delivery'
        When courier_id = 6 Then 'Local Delivery'
        When courier_id = 7 Then 'International Shipping'
        When courier_id = 8 Then 'Local Delivery'
    End
Where courier_id Between 1 and 8;


Alter Table Courier Add Column service_cost int DEFAULT NULL;

SET SQL_SAFE_UPDATES = 0;

UPDATE Courier 
SET service_cost = CASE
    WHEN servicetype = 'Express Delivery' THEN 800
    WHEN servicetype = 'Same-Day Delivery' THEN 1000
    WHEN servicetype = 'Next-Day Delivery' THEN 500
    WHEN servicetype = 'Standard Shipping' THEN 450  -- Fixed name
    WHEN servicetype = 'Local Delivery' THEN 400
    WHEN servicetype = 'International Shipping' THEN 2000  -- Fixed name
    ELSE NULL
END
WHERE servicetype IS NOT NULL;

SET SQL_SAFE_UPDATES = 1;








-- Employee Table (Office Staff)
CREATE TABLE Employee (
    emp_id INT AUTO_INCREMENT PRIMARY KEY,
    emp_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    phone VARCHAR(20) UNIQUE NOT NULL,
    role ENUM('Manager', 'Dispatcher', 'Support') NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

Insert into employee(emp_name,email,phone,role)values
('Peter', 'peter@example.com', '7777777001', 'Manager'),
('Bruce', 'bruce@example.com', '7777777002', 'Dispatcher'),
('Clark', 'clark@example.com', '7777777003', 'Support'),
('Diana', 'diana@example.com', '7777777004', 'Manager'),
('Tony', 'tony@example.com', '7777777005', 'Dispatcher');

Alter Table employee Add Column emp_salary int DEFAULT NULL;

Set sql_safe_updates =0;

update employee
set emp_salary =case
when role='Manager' then 50000
when role='Dispatcher'then 30000
when role='support'then 25000
else null
end;

set sql_safe_updates=1;

-- Location Table (Warehouses or Hubs)
CREATE TABLE Location (
    location_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    address TEXT NOT NULL,
    city VARCHAR(50) NOT NULL,
    state VARCHAR(50) NOT NULL,
    zip_code VARCHAR(10) NOT NULL
);

Insert into location(name,address,city,state,zip_code)values
('Central Hub', '123 Logistics Lane', 'City A', 'State X', '110001'),
('East Hub', '456 Transport St', 'City B', 'State Y', '220002'),
('West Hub', '789 Delivery Rd', 'City C', 'State Z', '330003'),
('North Hub', '321 Express Ave', 'City D', 'State X', '440004'),
('South Hub', '654 Freight Blvd', 'City E', 'State Y', '550005');



-- Payment Table (For Order Payments)
CREATE TABLE Payment (
    payment_id INT AUTO_INCREMENT PRIMARY KEY,
    cust_id INT NOT NULL,
    amount DECIMAL(10,2) NOT NULL,
    payment_method ENUM('Credit Card', 'Debit Card', 'UPI', 'Cash', 'Net Banking') NOT NULL,
    payment_status ENUM('Pending', 'Completed', 'Failed') DEFAULT 'Pending',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (cust_id) REFERENCES customer(cust_id) ON DELETE CASCADE);
    
INSERT INTO Payment (cust_id, amount, payment_method, payment_status) VALUES
(1, 500.00, 'Credit Card', 'Completed'),
(2, 250.50, 'UPI', 'Completed'),
(3, 120.75, 'Cash', 'Pending'),
(4, 400.20, 'Net Banking', 'Failed');
INSERT INTO Payment (cust_id, amount, payment_method, payment_status) VALUES
(5,550.00,'UPI','completed');
 

-- Orders Table (Package & Shipments)
CREATE TABLE Orders (
    order_id INT AUTO_INCREMENT PRIMARY KEY,
    cust_id INT NOT NULL,
    courier_id INT DEFAULT NULL,
    location_id INT NOT NULL,
    order_status ENUM('Pending', 'In Transit', 'Delivered', 'Cancelled') DEFAULT 'Pending',
    payment_id INT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (cust_id) REFERENCES customer(cust_id) ON DELETE CASCADE,
    FOREIGN KEY (courier_id) REFERENCES Courier(courier_id) ON DELETE SET NULL,
    FOREIGN KEY (location_id) REFERENCES Location(location_id) ON DELETE CASCADE,
    FOREIGN KEY (payment_id) REFERENCES Payment(payment_id) ON DELETE CASCADE
);

Insert into orders(Cust_id,courier_id,location_id,order_status,payment_id)values
(1, 1, 1, 'In Transit', 16),
(2, 2, 2, 'Delivered', 17),
(3, NULL, 3, 'Pending', 18),
(4, 4, 4, 'Cancelled', 19),
(5, 5, 5, 'In Transit', 26);


-- Parcels Table (Individual Items in an Order)
CREATE TABLE Parcel (
    parcel_id INT AUTO_INCREMENT PRIMARY KEY,
    order_id INT NOT NULL,
    weight DECIMAL(10,2) NOT NULL,
    dimensions VARCHAR(50) NOT NULL,
    description TEXT NOT NULL,
    status ENUM('Packed', 'Shipped', 'Out for Delivery', 'Delivered') DEFAULT 'Packed',
    FOREIGN KEY (order_id) REFERENCES Orders(order_id) ON DELETE CASCADE
);
Insert into parcel(order_id,weight,dimensions,description,status)values
(6, 2.5, '10x5x8', 'Electronics', 'Shipped'),
(7, 1.2, '8x4x6', 'Clothing', 'Delivered'),
(8, 5.0, '15x10x12', 'Books', 'Packed'),
(9, 0.8, '5x3x4', 'Accessories', 'Cancelled'),
(10, 3.6, '12x8x10', 'Shoes', 'Shipped');








