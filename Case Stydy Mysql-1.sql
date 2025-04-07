create database assetmanagementsystem;
use assetmanagementsystem;

CREATE TABLE employees (
    employee_id INT PRIMARY KEY AUTO_INCREMENT, 
    name VARCHAR(100) NOT NULL, 
    department VARCHAR(100), 
    email VARCHAR(100) UNIQUE NOT NULL, 
    password VARCHAR(255) NOT NULL 
);

CREATE TABLE assets (
    asset_id INT PRIMARY KEY AUTO_INCREMENT, 
    name VARCHAR(255) NOT NULL, 
    type VARCHAR(100) NOT NULL, 
    serial_number VARCHAR(100) UNIQUE NOT NULL,  
    purchase_date DATE NOT NULL, 
    location VARCHAR(255), 
    status ENUM('in use', 'decommissioned', 'under maintenance') NOT NULL, 
    owner_id INT, 
    FOREIGN KEY (owner_id) REFERENCES employees(employee_id) ON DELETE SET NULL 
);

CREATE TABLE maintenance_records (
    maintenance_id INT PRIMARY KEY AUTO_INCREMENT, 
    asset_id INT NOT NULL,  
    maintenance_date DATE NOT NULL,  
    description TEXT NOT NULL,  
    cost DECIMAL(10,2) NOT NULL,  
    FOREIGN KEY (asset_id) REFERENCES assets(asset_id) ON DELETE CASCADE  
);

CREATE TABLE asset_allocations (
    allocation_id INT PRIMARY KEY AUTO_INCREMENT,  
    asset_id INT NOT NULL,  
    employee_id INT NOT NULL, 
    allocation_date DATE NOT NULL,  
    return_date DATE DEFAULT NULL,  
    FOREIGN KEY (asset_id) REFERENCES assets(asset_id) ON DELETE CASCADE,  
    FOREIGN KEY (employee_id) REFERENCES employees(employee_id) ON DELETE CASCADE  
);

CREATE TABLE reservations (
    reservation_id INT PRIMARY KEY AUTO_INCREMENT,  
    asset_id INT NOT NULL,  
    employee_id INT NOT NULL,  
    reservation_date DATE NOT NULL,  
    start_date DATE NOT NULL,  
    end_date DATE NOT NULL,  
    status ENUM('pending', 'approved', 'canceled') NOT NULL,  
    FOREIGN KEY (asset_id) REFERENCES assets(asset_id) ON DELETE CASCADE,  
    FOREIGN KEY (employee_id) REFERENCES employees(employee_id) ON DELETE CASCADE 
);


insert into employees(name,department,email,password) values
('Monisha', 'IT', 'monisha@gmail.com', 'password123'),
('Mary', 'Finance', 'mary@gmail.com', 'password456'),
('Sam', 'HR', 'sam@gmail.com', 'password789'),
('Saran', 'Marketing', 'saran@gmail.com', 'pass123'),
('Jansi', 'IT','jansi@gmail.com', 'securepass'),
('Sarah', 'HR', 'sarah@gmail.com', 'sarahpass'),
('Kumar', 'Finance', 'kumar@gmail.com', 'davidpass'),
('Ajay', 'Marketing', 'ajay@gmail.com', 'emma123'),
('Ram', 'IT', 'ram@gmail.com', 'robertpass'),
('Sophia', 'Finance', 'sophia@gmail.com', 'sophiapass');

insert into assets (name, type, serial_number, purchase_date, location, status, owner_id) values 
('Dell Laptop', 'Laptop', 'SN12345', '2025-01-15', 'Office A', 'in use', 1),
('Lenovo Laptop', 'Laptop', 'LM14357', '2024-05-10', 'Garage', 'in use', 2),
('Canon Printer', 'Equipment', 'PRT4567', '2024-08-20', 'Office B', 'under maintenance', 3),
('MacBook Pro', 'Laptop', 'SN67890', '2024-07-10', 'Office C', 'in use', 4),
('HP Printer', 'Equipment', 'HP3345', '2024-12-05', 'Office D', 'decommissioned', 5),
('Lenovo Laptop', 'Laptop', 'LEN7765', '2024-02-01', 'Office E', 'in use', 6),
('Projector', 'Equipment', 'PROJ9876', '2024-06-12', 'Conference Room', 'in use', 7),
('Electric Scooter', 'Vehicle', 'ESCOOT123', '2024-09-25', 'Garage', 'under maintenance', 8),
('Samsung Monitor', 'Equipment', 'SAM9876', '2024-11-11', 'Office F', 'in use', 9),
('Company Car', 'Vehicle', 'COMP1234', '2024-03-30', 'Garage', 'decommissioned', 10);

INSERT INTO maintenance_records (asset_id, maintenance_date, description, cost) VALUES 
(3, '2025-02-01', 'Replaced toner cartridge', 50.00),
(8, '2024-10-10', 'Battery replacement', 120.00),
(5, '2024-12-20', 'General service check', 80.00),
(7, '2024-07-01', 'Lamp replacement', 200.00),
(3, '2025-03-05', 'Fixed paper jam issue', 30.00),
(9, '2025-01-15', 'Screen replacement', 250.00),
(6, '2024-06-25', 'Keyboard replacement', 90.00),
(10, '2024-05-15', 'Engine checkup', 500.00),
(1, '2025-03-10', 'Software updates and cleanup', 0.00),
(4, '2024-08-15', 'Battery replacement', 150.00);

insert into asset_allocations (asset_id, employee_id, allocation_date, return_date) values
(1, 1, '2024-03-01', '2024-03-10'),
(2, 3, '2024-02-15', NULL),
(3, 5, '2024-02-20', '2024-03-05'),
(4, 7, '2024-01-10', '2024-02-01'),
(5, 2, '2024-03-05', NULL),
(6, 6, '2024-01-25', '2024-02-20'),
(7, 4, '2024-02-28', NULL),
(8, 8, '2024-03-01', '2024-03-15'),
(9, 9, '2024-02-10', '2024-02-25'),
(10, 10, '2024-01-05', NULL);

insert into reservations (asset_id, employee_id, reservation_date, start_date, end_date, status) values
(1, 2, '2024-03-01', '2024-03-05', '2024-03-10', 'approved'),
(2, 4, '2024-02-10', '2024-02-15', '2024-02-20', 'pending'),
(3, 6, '2024-03-03', '2024-03-06', '2024-03-12', 'approved'),
(4, 8, '2024-01-20', '2024-01-25', '2024-02-05', 'canceled'),
(5, 10, '2024-02-05', '2024-02-10', '2024-02-15', 'approved'),
(6, 1, '2024-01-15', '2024-01-20', '2024-01-30', 'pending'),
(7, 3, '2024-02-28', '2024-03-01', '2024-03-07', 'approved'),
(8, 5, '2024-02-25', '2024-02-28', '2024-03-10', 'canceled'),
(9, 7, '2024-03-10', '2024-03-12', '2024-03-18', 'approved'),
(10, 9, '2024-01-30', '2024-02-01', '2024-02-07', 'pending');




