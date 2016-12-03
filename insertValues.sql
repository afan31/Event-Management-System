insert into Participant(name,email,phone,zipcode,password,isAdmin) 
	values('prasad','prasad@gmail.com','1234567890','02115','prasad',1);
insert into Participant(name,email,phone,zipcode,password,isAdmin) 
	values('emsAdmin','ems@gmail.com','1111111111','02119','ems',1);
insert into Participant(name,email,phone,zipcode,password,isAdmin) 
	values('afan','afan@gmail.com','2222222222','02120','afan',0);
insert into Participant(name,email,phone,zipcode,password,isAdmin) 
	values('sujith','sujith@gmail.com','333333333','02120','sujith',0);
insert into Participant(name,email,phone,zipcode,password,isAdmin) 
	values('rakesh','rakesh@gmail.com','444444444','02115','rakesh',0);
insert into Participant(name,email,phone,zipcode,password,isAdmin) 
	values('ken','ken@ccs.neu.edu','555555555','02115','ken',0);
insert into Participant(name,email,phone,zipcode,password,isAdmin) 
	values('dbAdmin','dbAdmin@ccs.neu.edu','6666666666','02115','admin',1);
insert into Participant(name,email,phone,zipcode,password,isAdmin) 
	values('test1','test1@yahoo.com','7777777777','02132','test1',0);
insert into Participant(name,email,phone,zipcode,password,isAdmin) 
	values('test2','test2@yahoo.com','8888888888','02142','test2',0);
insert into Participant(name,email,phone,zipcode,password,isAdmin) 
	values('test3','test3@yahoo.com','9999999999','03213','test3',0);
    

insert into Event(name,description,address,total_seats,time,date,isIndoor,organized_by)
	values('event1','the best event ever','313 Huntigton avenue',10,'8:00pm','12/12/2016',1,1);
insert into Event(name,description,address,total_seats,time,date,isIndoor,organized_by)
	values('event2','the best event ever','313 Huntigton avenue',100,'8:00pm','12/12/2016',1,6);
insert into Event(name,description,address,total_seats,time,date,isIndoor,organized_by)
	values('event3','the best event ever','313 Huntigton avenue',5,'8:00pm','12/12/2016',1,9);
insert into Event(name,description,address,total_seats,time,date,isIndoor,organized_by)
	values('event4','the best event ever','313 Huntigton avenue',20,'8:00pm','12/12/2016',1,1);
insert into Event(name,description,address,total_seats,time,date,isIndoor,organized_by)
	values('event5','the best event ever','313 Huntigton avenue',50,'8:00pm','12/12/2016',1,1);
    

insert into Organizer(id,type) 
	values(1,'Individual');
insert into Organizer(id,type,company) 
	values(6,'Company','NEU');
insert into Organizer(id,type) 
	values(9,'Individual');


insert into Attendee(id) values(2);
insert into Attendee(id) values(3);
insert into Attendee(id) values(4);
insert into Attendee(id) values(5);
insert into Attendee(id) values(6);
insert into Attendee(id) values(7);
insert into Attendee(id) values(8);
insert into Attendee(id) values(10);


insert into Event_Attendee(event_id,user_id,noOfGuests) 
	values(1,2,2);
insert into Event_Attendee(event_id,user_id,noOfGuests) 
	values(1,3,3);
insert into Event_Attendee(event_id,user_id,noOfGuests) 
	values(1,4,4);
insert into Event_Attendee(event_id,user_id,noOfGuests) 
	values(2,2,2);
insert into Event_Attendee(event_id,user_id,noOfGuests) 
	values(2,5,2);
insert into Event_Attendee(event_id,user_id,noOfGuests) 
	values(3,4,2);
insert into Event_Attendee(event_id,user_id,noOfGuests) 
	values(3,5,2);
insert into Event_Attendee(event_id,user_id,noOfGuests) 
	values(3,7,2);
insert into Event_Attendee(event_id,user_id,noOfGuests) 
	values(3,8,2);
insert into Event_Attendee(event_id,user_id,noOfGuests) 
	values(4,10,1);
insert into Event_Attendee(event_id,user_id,noOfGuests) 
	values(4,3,2);
insert into Event_Attendee(event_id,user_id,noOfGuests) 
	values(4,4,2);
insert into Event_Attendee(event_id,user_id,noOfGuests) 
	values(4,5,0);
    
    
insert into Event_Interests(event_id,user_id) 
	values(4,5);
insert into Event_Interests(event_id,user_id) 
	values(3,1);
    