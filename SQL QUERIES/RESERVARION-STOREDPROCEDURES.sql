use newproject;

/* -------------------------------------------------------------------------------------------------- */
/*  --------- PROCEDURE TO VIEW THE BUSES DETAILS BY ENTERING SOURCE AND DESTINATION  --------- */	
delimiter //
create procedure enteringSD(in src varchar(20) , in dest varchar(20))
begin
select BusRegistration.Bus_Reg_No,source_name,destination,date_of_travel,boarding_time,arrival_time,TotalSeats,Bus_Type,ticket_charges 
from TripManaging,BusRegistration 
where source_name=src and destination = dest and TripManaging.Bus_Reg_No = BusRegistration.Bus_Reg_No;
end //
delimiter ;
call enteringSD('HYDERABAD','GOA'); -- EXAMPLE
/* -------------------------------------------------------------------------------------------------- */



/* --------------------------------------------------------------------------------------------------------------- */
/*  --------- PROCEDURE TO BOOK THE SEAT FROM THE AVAILABLE SEATS BY ENTERING BUS REGISTRATION NUMBER------------- */
delimiter //
create procedure callBusSeatsSecondData(in regNo varchar(10))
begin
select Seat_No,Berth,Status from BusSeatsData where BusSeatsData.Bus_Reg_No = regNo;
end //
delimiter ;

call callBusSeatsSecondData('AB-9996'); -- EXAMPLE
/* --------------------------------------------------------------------------------------------------------------- */




/* -------------------------------------------------------------------------------------------------------------------------------------------------- */
/*  --------- PROCEDURE TO BOOK THE TICKET USING SEAT NUMBER AND BUS REGISTRATION NUMBER, GENERATES UNIQUE PNR NUMBER and RESREVATION DATE AND TIME --------- */

delimiter //
create procedure bookingseat(in seat int, in regno varchar(10))
begin 
update BusSeatsData SET status ='Booked',  PNR_NO = (CONCAT(DATE_FORMAT(NOW(), '%Y%m%d%H%i%s'),FLOOR(RAND()*100))) , reserv_dt =NOW() 
where BusSeatsData.Seat_No = seat and BusSeatsData.Bus_Reg_No = regno ;
end //
delimiter ;
call bookingseat(1,'AB-9999'); -- EXAMPLE

/* -------------------------------------------------------------------------------------------------------------------------------------------------- */



/* -------------------------------------------------------------------------- */
/*  --------- PROCEDURE TO GENERATE THE FULL TICKET WITH THE USER DETAILS  --------- */

delimiter //
create procedure toselectAgaininJava(in seat int , in reg varchar(20))
begin
select * from UserReservation where Bus_Reg_No =reg and seat_booked =seat;
end //
delimiter ;

call toselectAgaininJava();  
/* ------------------------------------------------------------------- */


/* -------------------------------------------------------------------------- */
/*  --------- PROCEDURE TO VIEW THE TICKET DETAILS USING PNR NUMBER --------- */
drop procedure searching_using_pnr;
delimiter //
create procedure searching_using_pnr(in PNR_NO varchar(200))
begin
select distinct * from UserReservation where UserReservation.PNR_NO = PNR_NO;
end //
delimiter ;

call searching_using_pnr(2023012002362649); -- EXAMPLE
/* ---------------------------------------------------------------------------- */
