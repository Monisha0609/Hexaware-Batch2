create database petadoptionplatform;
use petadoptionplatform;

-- Table Pets
Create table Pets (
    PetID int primary key auto_increment,
    Name varchar(100) not null,
    Age int not null,
    Breed varchar(100),
    Type varchar(50) not null,
    AvailableForAdoption bit not null
);

Alter table Pets Add column Ownerid int null,add column Ownername varchar(100) null;

set sql_safe_updates=0;

update Pets set Ownerid = 1, Ownername = 'Annie'where Name = 'Buddy';
update Pets set Ownerid = 2, Ownername = 'John'where Name = 'Tinkoo';
update Pets set Ownerid = 3, Ownername = 'David'where Name = 'Scooby';
update Pets set Ownerid = 4, Ownername = 'Sarah'where Name = 'Kitten';
update Pets set Ownerid = null, Ownername = Null where Name = 'Rocky';
update Pets set Ownerid = 6, Ownername = 'Nancy'where Name = 'Shero';
update Pets set Ownerid = 7, Ownername = 'Priya'where Name = 'Snowbell';
update Pets set Ownerid = 8, Ownername = 'Sophia'where Name = 'Puppy';
update Pets set Ownerid = 9, Ownername = 'Daniel'where Name = 'Suzee';
update Pets set Ownerid = null, Ownername = null where Name = 'Tiger';

set sql_safe_updates=1;



-- Table Shelters
create table Shelters (
    ShelterID int primary key auto_increment,
    Name varchar(100) not null,
    Location varchar(255) not null
);

-- Table: Donations
CREATE TABLE Donations (
    DonationID int primary key auto_increment,
    DonorName varchar(100) not null,
    DonationType varchar(50) not null,
    DonationAmount decimal(10,2) default null,
    DonationItem varchar(255) default null,
    DonationDate datetime not null
);

-- Table AdoptionEvents
CREATE TABLE AdoptionEvents (
    EventID int primary key auto_increment,
    EventName varchar(100) not null,
    EventDate datetime not null,
    Location varchar(255) not null
);

-- Table Participants
CREATE TABLE Participants (
    ParticipantID int primary key auto_increment,
    ParticipantName varchar(100) not null,
    ParticipantType Enum('Shelter', 'Adopter') not null,
    EventID int,
    Foreign key (EventID) References AdoptionEvents(EventID) on delete set null
);

--  Pets table
insert into Pets (Name, Age, Breed, Type, AvailableForAdoption) values
('Buddy', 3, 'Golden Retriever', 'Dog', 1),
('tinkoo', 2, 'Siamese', 'Cat', 1),
('scooby', 5, 'Labrador', 'Dog', 0),
('kitten', 1, 'Persian', 'Cat', 1),
('Rocky', 4, 'Bulldog', 'Dog', 0),
('shero', 3, 'Husky', 'Dog', 1),
('snowbell', 2, 'Tabby', 'Cat', 1),
('puppy', 6, 'German Shepherd', 'Dog', 0),
('suzee', 4, 'Maine Coon', 'Cat', 1),
('Tiger', 2, 'Beagle', 'Dog', 1);

update pets  set breed = 'Husky' where name = 'Tiger';  


-- Shelters table
insert into Shelters (Name, Location) values
('Happy Tails Shelter', '123 Main St, New road,city A'),
('Furry Friends Haven', '456 main Road,high road,city B'),
('Paw Palace', '789 Main St,NH,City c'),
('Rescue Paws', '321 10th cross street,hih road,city A'),
('Safe Haven for Pets', '654 Main highway,City c'),
('The Pet Refuge', '987 broadway,NH4,city D'),
('Hope for Paws', '741 east main road,City D'),
('Home for Strays', '156, west main road,City c'),
('Loving Hearts Shelter', '852 10th st,New road,city C'),
('Second Chance Pets', '753 main highroad,City B');

--  Donations table
insert into Donations (DonorName, DonationType, DonationAmount, DonationItem, DonationDate) values
('John', 'Cash', 100.00, NULL, '2025-03-01 10:30:00'),
('Kumar', 'Item', NULL, 'Dog Food', '2025-03-02 12:00:00'),
('Saran', 'Cash', 50.00, NULL, '2025-03-03 15:45:00'),
('Monisha', 'Item', NULL, 'Cat Toys', '2025-03-04 09:15:00'),
('David', 'Cash', 200.00, NULL, '2025-03-05 14:20:00'),
('Sarah', 'Item', NULL, 'Pet Beds', '2024-11-06 17:10:00'),  
('Keerthi', 'Cash', 75.00, NULL, '2024-11-07 11:30:00'), 
('Sam', 'Item', NULL, 'Leashes & Collars', '2025-05-08 13:40:00'),  
('Mary', 'Cash', 150.00, NULL, '2024-05-09 16:50:00'),
('Ram', 'Item', NULL, 'Blankets', '2024-09-10 08:25:00'); 


alter table Donations add column ShelterID int,
add constraint Fk_Donations_Shelter Foreign key (ShelterID) References Shelters(ShelterID) on delete set null;

set sql_safe_updates=0;

update Donations set ShelterID = 1 where DonorName = 'John';
update Donations set ShelterID = 2 where DonorName = 'Kumar';
update Donations set ShelterID = 3 where DonorName = 'saran';
update Donations set ShelterID = 4 where DonorName = 'Monisha';
update Donations set ShelterID = 5 where DonorName = 'David';
update Donations set ShelterID = 6 where DonorName = 'Sarah';
update Donations set ShelterID = 7 where DonorName = 'Keerthi';
update Donations set ShelterID = 8 where DonorName = 'Sam';
update Donations set ShelterID = 9 where DonorName = 'Mary';
update Donations set ShelterID = 10 where DonorName = 'Ram';

set sql_safe_updates=1;


--  AdoptionEvents table
insert into AdoptionEvents (EventName, EventDate, Location) values
('Spring Adoption Fair', '2025-04-01 10:00:00', 'Central Park, City A'),
('Paws for Love', '2025-04-10 11:30:00', 'City center'),
('Homeward Bound', '2025-04-15 12:00:00', 'pets Shelter'),
('Forever Homes Event', '2025-04-20 14:00:00', 'Town Community Center'),
('Adopt-A-Pet Weekend', '2025-04-25 09:00:00', 'Central Beach Park'),
('Love a Pet Day', '2025-05-01 13:30:00', 'Home Pet Center'),
('Pawfest', '2025-05-10 15:00:00', ' City Square'),
('Find a Friend', '2025-05-20 10:00:00', 'Paris Area'),
('Rescue and Rehome', '2025-05-30 11:45:00', 'Wonder Pet Store'),
('Give a Pet a Home', '2025-06-05 12:30:00', 'Miracle Dog Park');

-- Insert data into Participants table
insert into Participants (ParticipantName, ParticipantType, EventID) values
('Happy Tails Shelter', 'Shelter', 1),
('Furry Friends Haven', 'Shelter', 2),
('Paw Palace', 'Shelter', 3),
('Rescue Paws', 'Shelter', 4),
('Safe Haven for Pets', 'Shelter', 5),
('Saran', 'Adopter', 6),
('Sarah', 'Adopter', 7),
('Keerthi', 'Adopter', 8),
('Sam', 'Adopter', 9),
('Mary', 'Adopter', 10);


alter table Pets add column ShelterID int null;

set sql_safe_updates = 0;

update pets set ShelterID = 1 where Name in ('Buddy'); -- Golden Retriever in Shelter 1
update pets set ShelterID = 2 where Name in ('Tinkoo', 'Snowbell'); -- Siamese and Tabby in Shelter 2
update pets set ShelterID = 3 where Name in ('Scooby', 'Rocky'); -- Labrador and Bulldog in Shelter 3
update pets set ShelterID = 4 where Name in ('Kitten', 'Suzee'); -- Persian and Maine Coon in Shelter 4
update pets set ShelterID = 5 where Name in ('Shero', 'Tiger'); -- Both Huskies placed in the same Shelter 5
update pets set ShelterID = 6 where Name = 'Puppy'; -- German Shepherd in Shelter 6
update pets set ShelterID = NULL where Name = 'Rocky'; -- Leaving Rocky without a shelter

set sql_safe_updates = 1;


-- Tasks
-- 1. Provide a SQL script that initializes the database for the Pet Adoption Platform ”PetPals”.
-- 2. Create tables for pets, shelters, donations, adoption events, and participants.
-- 3. Define appropriate primary keys, foreign keys, and constraints.
-- 4. Ensure the script handles potential errors, such as if the database or tables already exist.

-- the above tasks are completed...alter

-- 5. Write an SQL query that retrieves a list of available pets (those marked as available for adoption) from the "Pets" table. Include the pet's name, age, breed, and type in the result set. Ensure that the query filters out pets that are not available for adoption.

select name,age,breed, type from pets where availableforadoption=1;

-- 6. Write an SQL query that retrieves the names of participants (shelters and adopters) registered for a specific adoption event. Use a parameter to specify the event ID. Ensure that the query joins the necessary tables to retrieve the participant names and types.

select p.ParticipantName, p.ParticipantType from Participants p
join AdoptionEvents e on p.EventID = e.EventID
where p.EventID = 1; 

-- 7. Create a stored procedure in SQL that allows a shelter to update its information (name and location) in the "Shelters" table. Use parameters to pass the shelter ID and the new information. Ensure that the procedure performs the update and handles potential errors, such as an invalid shelter ID.

Delimiter //

create  procedure updateshelterinfo( 
in p_Shelterid int,in p_Newname varchar(100),
    in p_Newlocation varchar(255)
)
Begin
if (select count(*) from Shelters where ShelterID = p_Shelterid) = 0 then
        signal sqlstate '45000' 
        set message_text = 'Error: Shelter ID not found';
    else
        -- Update  info
        Update Shelters set Name = p_NewName, Location = p_NewLocation
        where ShelterID = p_ShelterID;
    end if;
end //

Delimiter ;

call updateshelterinfo(2, 'Furry Friends Rescue', 'New Highway, City B');

call UpdateShelterInfo(50, 'New Shelter Name', 'Some Location');

-- 8. Write an SQL query that calculates and retrieves the total donation amount for each shelter (by shelter name) from the "Donations" table. The result should include the shelter name and the total donation amount. Ensure that the query handles cases where a shelter has received no donations.

Select s.Name AS ShelterName,sum(d.DonationAmount) as Totaldonationamount from Shelters s
Left join Donations d on s.ShelterID = d.ShelterID
Group by s.ShelterID, s.Name;

-- 9. Write an SQL query that retrieves the names of pets from the "Pets" table that do not have an owner (i.e., where "OwnerID" is null). Include the pet's name, age, breed, and type in the result set.

select name,age,breed,type  from pets where ownerid is null;

-- 10. Write an SQL query that retrieves the total donation amount for each month and year (e.g., January 2023) from the "Donations" table. The result should include the month-year and the corresponding total donation amount. Ensure that the query handles cases where no donations were made in a specific month-year.
select  
    date_format(min(DonationDate), '%M %Y') as MonthYear,  sum(DonationAmount) as TotalDonationAmount  from Donations  
where year(DonationDate) = 2024 and month(DonationDate) = 11  
Group by year(DonationDate), month(DonationDate);

-- 11. Retrieve a list of distinct breeds for all pets that are either aged between 1 and 3 years or older than 5 years.
select distinct Breed from Pets
Where (Age between 1 and 3) or (Age > 5);

-- 12. Retrieve a list of pets and their respective shelters where the pets are currently available for adoption.
select p.name, p.breed, p.type, s.name as shelter_name, s.location from pets p
join shelters s on p.ownerid = s.shelterid
where p.availableforadoption = 1;

-- 13 Find the total number of participants in events organized by shelters located in specific city. Example: City=Chennai
select p.name, p.breed, p.type, s.name as shelter_name, s.location from pets p
join shelters s on p.ownerid = s.shelterid
where p.availableforadoption = 1 and lower(s.location) like '%city a%';

-- 14. Retrieve a list of unique breeds for pets with ages between 1 and 5 years.

select distinct breed from pets 
where age between 1 and 5;

-- 15. Find the pets that have not been adopted by selecting their information from the 'Pet' table.

select * from pets 
where ownerid is null;

-- 16. Retrieve the names of all adopted pets along with the adopter's name from the 'Adoption' and 'User' tables.

select name as pet_name, ownername as adopter_name  from pets  
where ownerid is not null;

-- 17. Retrieve a list of all shelters along with the count of pets currently available for adoption in each shelter.

select s.name as shelter_name, count(p.petid) as available_pets_count  from shelters s  
left join pets p on s.shelterid = p.ownerid and p.availableforadoption = 1  
group by s.shelterid, s.name;

-- 18. Find pairs of pets from the same shelter that have the same breed.
select p1.name as pet1, p2.name as pet2, p1.breed, s.name as shelter_name from pets p1
join pets p2 on p1.shelterid = p2.shelterid and p1.breed = p2.breed and p1.petid < p2.petid
join shelters s on p1.shelterid = s.shelterid
where p1.shelterid is not null;

-- 19. List all possible combinations of shelters and adoption events.

select s.name as shelter_name, e.eventname as adoption_event from shelters s 
cross join adoptionevents e;

-- 20. Determine the shelter that has the highest number of adopted pets.
select s.name as shelter_name, count(p.petid) as adopted_pets_count from pets p
join shelters s on p.shelterid = s.shelterid
where p.availableforadoption = 0
group by s.shelterid
order by adopted_pets_count desc
limit 1;
