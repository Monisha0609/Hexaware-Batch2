Use couriermanagement;

-- 23 Retrieve Payments with Courier Information (INNER JOIN)
Select p.payment_id, p.amount, p.payment_method, p.payment_status, p.created_at,c.courier_id, c.person_name
From Payment p
Join Orders o On p.payment_id = o.payment_id
Join Courier c On o.courier_id = c.courier_id;

-- 24  Retrieve Payments with Location Information (INNER JOIN)
Select p.payment_id, p.amount, p.payment_method, p.payment_status, p.created_at,
       l.location_id, l.name AS location_name, l.city, l.state
From Payment p
Join Orders o On p.payment_id = o.payment_id
Join Location l On o.location_id = l.location_id;

-- 25 Retrieve Payments with Courier and Location Information (INNER JOIN)
Select p.payment_id, p.amount, p.payment_method, p.payment_status, p.created_at,
       c.courier_id, c.person_name,
       l.location_id, l.name as location_name, l.city, l.state
From Payment p
Join Orders o On p.payment_id = o.payment_id
Join Courier c On o.courier_id = c.courier_id
Join Location l On o.location_id = l.location_id;

-- 26 List all payments with courier details
Select p.payment_id, p.amount, p.payment_method, p.payment_status, p.created_at,
       c.courier_id, c.person_name
From Payment p
Left Join Orders o On p.payment_id = o.payment_id
Left Join Courier c On o.courier_id = c.courier_id
Union
Select p.payment_id, p.amount, p.payment_method, p.payment_status, p.created_at,
       c.courier_id, c.person_name
From Payment p
Right Join Orders o On p.payment_id = o.payment_id
Right Join Courier c On o.courier_id = c.courier_id;

-- 27 Total payments received for each courier
Select c.courier_id, c.person_name, SUM(p.amount) as total_payments
From Courier c
Left Join Orders o On c.courier_id = o.courier_id
Left join Payment p On o.payment_id = p.payment_id
Group by c.courier_id, c.person_name
Order by total_payments Desc;

-- 28 List payments made on a specific date
Select * From Payment
Where date(created_at) = '2025-03-18';

-- 29 Get Courier Information for Each Payment
Select c.courier_id, c.person_name, c.phone, c.status,c.vehicle_number,c.created_at,p.payment_id, p.amount, p.payment_status
From payment p
Join Orders o On p.payment_id = o.payment_id
Left join Courier c On o.courier_id = c.courier_id;

-- 30 Get payment details with location
Select p.payment_id, p.amount, p.payment_method,p.payment_status,p.created_at, l.location_id, l.name as location_name, l.city, l.state
From Payment p
Join Orders o On p.payment_id = o.payment_id
Join Location l On o.location_id = l.location_id;

-- 31 Calculating Total Payments for Each Courier

Select c.courier_id, c.person_name, SUM(p.amount) AS total_payments
From Orders o
Join Payment p On o.payment_id = p.payment_id
Join Courier c On o.courier_id = c.courier_id
Group by c.courier_id, c.person_name; 

-- 32 List Payments Within a Date Range

Select * from payment where created_at between '2025-03-18' and '2025-03-19';

-- 33 Retrieve a list of all users and their corresponding courier records, including cases where there are no matches on either side

Select cu.cust_id, cu.cust_name, c.courier_id, c.person_name
From Customer cu
Left join Orders o On cu.cust_id = o.cust_id
Left join Courier c On o.courier_id = c.courier_id;

-- 34 Retrieve a list of all couriers and their corresponding services, including cases where there are no matches on either side

Select c.courier_id, c.person_name, o.order_id, o.order_status
From Courier c
Left join Orders o On c.courier_id = o.courier_id;
 
 -- 35 Retrieve a list of all employees and their corresponding payments, including cases where there are no matches on either side
 
Select e.emp_id, e.emp_name, p.payment_id, p.amount, p.payment_status
From Employee e
Left join Orders o On e.emp_id = o.courier_id 
Left join Payment p On o.payment_id = p.payment_id;

-- 36 List all users and all courier services, showing all possible combinations.

Select cust_id as ID, cust_name as Name, 'Customer' From Customer
Union
Select courier_id as ID, person_name as Name, 'Courier'  From Courier;

-- 37 
Select emp_id as ID, emp_name as Name, role as designation From employee
Union
Select location_id as ID, name as Name, city as designation  From location;

-- 38 Retrieve a list of couriers and their corresponding sender information (if available)
 select c.courier_id,c.person_name,cu.cust_id,cu.cust_name,cu.email,cu.phone,cu.address,cu.type  From
courier c 
left join orders o  on c.courier_id = o.courier_id
left join customer cu on o.cust_id = cu.cust_id
where cu.type = 'sender';

-- 39 Retrieve a list of couriers and their corresponding receiver information (if available):
 select c.courier_id,c.person_name,cu.cust_id,cu.cust_name,cu.email,cu.phone,cu.address,cu.type From
courier c 
left join orders o  on c.courier_id = o.courier_id
left join customer cu on o.cust_id = cu.cust_id
where cu.type = 'Receiver';

-- 40 Retrieve a list of couriers along with the courier service details (if available):

Select c.courier_id,c.person_name,c.phone,c.servicetype from courier c;

-- 41 Retrieve a list of employees and the number of couriers assigned to each employee:
Select c.courier_id, c.person_name, COUNT(o.order_id) as courier_count
From courier c
Left join orders o On o.courier_id = c.courier_id
Group by c.courier_id, c.person_name
Order by courier_count desc;


-- 42 Retrieve a list of locations and the total payment amount received at each location:

select l.location_id,l.name, sum(p.amount) as total_payment from location l
Left join Orders o On l.location_id = o.location_id
Left join Payment p On o.cust_id = p.cust_id
Group by l.location_id, l.name
Order by total_payment Desc;

-- 43 Retrieve all couriers sent by the same sender (based on SenderName).
select cu.cust_id, cu.cust_name,c.courier_id from customer cu
left join orders o on cu.cust_id = o.cust_id
left join courier c on o.courier_id = c. courier_id
where cu.type = sender;

-- 44 List all employees who share the same role.
Select e1.emp_id,e1.emp_name,e1.role from employee e1
join employee e2 on e1.role = e2.role and e1.emp_id<>e2.emp_id
order by e1.role,e1.emp_name;

-- 45 Retrieve all payments made for couriers sent from the same location
select p.payment_id,p.cust_id,p.payment_method,p.amount,p.payment_status,c.cust_name,o.location_id,l.name as location_name from payment p 
join orders o on p.payment_id = o.payment_id
join customer c on p.cust_id = c.cust_id
join location l on o.location_id = l.location_id
order by o.location_id; 

-- 46 Retrieve all couriers sent from the same location (based on SenderAddress).
select o.order_id,c.cust_name as sender_name,c.address as sender_address,o.location_id,l.name as location_name,co.courier_id,co.person_name as courier_name,
co.vehicle_number,co.servicetype FROM Orders o
Join Customer c On o.cust_id = c.cust_id 
Join Location l On o.location_id = l.location_id 
Left Join Courier co On o.courier_id = co.courier_id
Order by l.name;

-- 47 List employees and the number of couriers they have delivered: 
Select co.courier_id, co.person_name as courier_name, Count(o.order_id) as total_deliveries
from Orders o
Join Courier co On o.courier_id = co.courier_id
Where o.order_status = 'Delivered'
Group by co.courier_id, co.person_name
Order by total_deliveries Desc;

-- 48 Find couriers that were paid an amount greater than the cost of their respective courier services

Select co.courier_id,co.person_name as courier_name, p.amount as amount_paid,co.service_cost 
From Orders o
Join Courier co On o.courier_id = co.courier_id
Join Payment p On o.payment_id = p.payment_id
where p.amount >co.service_cost
order by Co.service_cost desc;

-- 49 Find couriers that have a weight greater than the average weight of all couriers
Select c.courier_id, c.person_name, p.weight  
From Courier c
Join Orders o On c.courier_id = o.courier_id
Join Parcel p On o.order_id = p.order_id
Where p.weight > (Select avg(weight) From Parcel);

-- 50 Find the names of all employees who have a salary greater than the average salary:
Select emp_name, role From Employee 
Where emp_salary > (Select AVG(emp_salary) from Employee);

-- 51 Find the total cost of all courier services where the cost is less than the maximum cost
Select Sum(service_cost) as total_cost from Courier
Where service_cost < (Select max(service_cost) from Courier);

-- 52 Find all couriers that have been paid for
Select distinct c.courier_id, c.person_name from Courier c
Join Orders o on c.courier_id = o.courier_id
Join Payment p on o.payment_id = p.payment_id
where p.payment_status = 'Completed';

-- 53 Find the locations where the maximum payment amount was made

select l.name, l.address, p.amount
from location l
join orders o on l.location_id = o.location_id
join payment p on o.payment_id = p.payment_id
where p.amount = (select max(amount) from payment);

-- 54 Find all couriers whose weight is greater than the weight of all couriers sent by a specific sender (e.g., 'SenderName')
select distinct c.courier_id, c.person_name, p.weight from courier c
join orders o on c.courier_id = o.courier_id
join parcel p on o.order_id = p.order_id
where p.weight > all (
    select p2.weight from parcel p2
    join orders o2 on p2.order_id = o2.order_id
    join customer cu on o2.cust_id = cu.cust_id
    where cu.cust_name = 'sendername'
);










