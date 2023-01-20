
use newproject;

drop table if exists UserReservation;

create table UserReservation
(
	Bus_Reg_No varchar(10),
    seat_booked varchar(200),
    Birth_type varchar(200),
    Status_check varchar(200),
	PNR_NO varchar(200),
    reservation_date_time varchar(30),
    username VARCHAR(40),
    email VARCHAR(100),
    phone_no VARCHAR(10),
    age INT,
    source_name varchar(255),
	destination varchar(255),
	date_of_travel varchar(255),
	boarding_time time,
	arrival_time time,
	ticket_charges varchar(255)
);