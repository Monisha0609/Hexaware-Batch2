USE CourierManagement;

-- 1. List all customers:
Select * From customer;

-- 2. List all orders for a specific customer:
Select * from orders where cust_id=1;

-- 3. List all couriers:
Select * From courier;

-- 4. List all packages for a specific order:
select*from parcel where order_id=6;

-- 5. List all deliveries for a specific courier:
Select * From Orders Where courier_id = 2;

-- 6. List all undelivered packages:
Select * From Parcel Where status!='Delivered';

-- 7. List all packages that are scheduled for delivery today:
Select * From Parcel Where status = 'Out for Delivery'; 


-- 8. List all packages with a specific status:
Select * from parcel where status= 'shipped';

-- 9. Calculate the total number of packages for each courier.
Select o.courier_id, c.person_name, COUNT(p.parcel_id) as total_packages
from Orders o
join Parcel p on o.order_id = p.order_id
join Courier c on o.courier_id = c.courier_id
Group by o.courier_id, c.person_name;

-- 10. Find the average delivery time for each courier
Select o.courier_id, c.person_name, avg(timestampdiff(Hour, o.created_at, NOW())) as avg_delivery_time_hours
From Orders o
Join Courier c On o.courier_id = c.courier_id
Where o.order_status = 'Delivered'
Group by o.courier_id, c.person_name;

-- 11. List all packages with a specific weight range:
Select * From Parcel Where weight Between 2 And 5;

-- 12. Retrieve employees whose names contain 'John'
SELECT * From employee Where emp_name Like '%John%';

-- 13. Retrieve all courier records with payments greater than $50.
Select c. * from courier c 
Join Orders o On c.courier_id = o.courier_id
Join Payment p On o.payment_id = p.payment_id
Where p.amount > 50;





















