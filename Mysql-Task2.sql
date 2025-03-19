USE CourierManagement;

Select * From customer;

Select * from orders where cust_id=1;

Select * From courier;

select*from parcel where order_id=6;

Select * From Orders Where courier_id = 2;

Select * From Parcel Where status!='Delivered';

Select * From Parcel Where status = 'Out for Delivery'; 

Select * from parcel where status= 'shipped';

Select o.courier_id, c.person_name, COUNT(p.parcel_id) as total_packages
from Orders o
join Parcel p on o.order_id = p.order_id
join Courier c on o.courier_id = c.courier_id
Group by o.courier_id, c.person_name;

Select o.courier_id, c.person_name, avg(timestampdiff(Hour, o.created_at, NOW())) as avg_delivery_time_hours
From Orders o
Join Courier c On o.courier_id = c.courier_id
Where o.order_status = 'Delivered'
Group by o.courier_id, c.person_name;

Select * From Parcel Where weight Between 2 And 5;

SELECT * From employee Where emp_name Like '%John%';

Select c. * from courier c 
Join Orders o On c.courier_id = o.courier_id
Join Payment p On o.payment_id = p.payment_id
Where p.amount > 50;










