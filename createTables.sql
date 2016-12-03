drop schema EventManagementSystem;
create schema EventManagementSystem;
use EventManagementSystem;

create table Participant (
	id int primary key auto_increment,
    name varchar(200) not null,
    email varchar(200) not null,
    phone varchar(200) not null,
    unique(email, phone),
    zipcode varchar(5) not null,
    password varchar(50) not null,
    isAdmin boolean default false
);

create table Attendee (
	id int primary key,
    foreign key(id)
		references Participant(id)
        on delete cascade on update cascade
);

create table Organizer (
	id int primary key,
    foreign key(id)
		references Participant(id)
        on delete cascade on update cascade,
	type enum('Individual', 'Company') not null,
    company varchar(200)
);

create table Event (
	id int primary key auto_increment,
	name varchar(200) not null,
    unique(name),
	description varchar(200) not null,
	address varchar(200) not null,
	total_seats int,
    time varchar(10),
    date varchar(10),
    isIndoor boolean,
	organized_by int not null,
    foreign key(organized_by) 
		references Organizer(id)
        on delete cascade on update cascade
);

create table Sport (
	id int primary key,
    foreign key(id) 
		references Event(id) 
		on delete cascade on update cascade,
    game varchar(200) not null
);
    
create table Music (
	id int primary key,
    foreign key(id)
		references Event(id)
        on delete cascade on update cascade,
    genre varchar(200) not null,
    artist varchar(200) not null
);
    
create table Technology (
	id int primary key,
    foreign key(id) 
		references Event(id)
		on delete cascade on update cascade,
    category enum('Mobile','Robotics','Cloud') not null
);

create table Event_Attendee (
	event_id int not null,
	foreign key (event_id)
		references Event(id)
        on delete cascade on update cascade,
	user_id int not null,
	foreign key (user_id)
		references Attendee(id)
        on delete cascade on update cascade,
	primary key (event_id, user_id),
    noOfGuests int
);

create table Event_Interests (
	event_id int not null,
	foreign key (event_id)
		references Event(id)
        on delete cascade on update cascade,
	user_id int not null,
	foreign key (user_id)
		references Participant(id)
        on delete cascade on update cascade,
	primary key (event_id, user_id)
);