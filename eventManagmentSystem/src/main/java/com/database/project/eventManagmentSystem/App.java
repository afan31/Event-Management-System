package com.database.project.eventManagmentSystem;

import java.util.*;
import java.util.Scanner;
import java.sql.*;

/**
 * App creates the database and necessary tables
 * and then adds an admin participant
 *
 */
public class App  {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/";
	static final String DB_NAME = "EventManagementSystem";
	
	//  Database credentials
	static String USER = "";
	static String PASS = "";
	public static void main( String[] args ){
    	Connection conn = null;
    	Statement stmt = null;
    	Scanner in = null;
        try {
        	in = new Scanner(System.in);
        	System.out.print("Enter Username for Database:");
        	USER = in.next();
        	System.out.print("\nPassword: ");
        	PASS = in.next();

        	createDbIfNotExists();
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL+DB_NAME,USER,PASS);
        	LinkedHashMap<String,String> createTables = new LinkedHashMap<String,String>();
        	/*
        	 * create table Participant (id int primary key auto_increment,name varchar(200) not null,email varchar(200) not null,phone varchar(200) not null,unique(email, phone),zipcode varchar(5) not null,isAdmin boolean default false)
        	 * create table Attendee (id int primary key, foreign key(id) references Participant(id) on delete cascade on update cascade)
        	 * create table Organizer (id int primary key, foreign key(id) references Participant(id) on delete cascade on update cascade, type enum('Individual', 'Company') not null, company varchar(200))
        	 * create table Event (id int primary key auto_increment, name varchar(200) not null, description varchar(200) not null, address varchar(200) not null, total_seats int, time varchar(10), date varchar(10), isIndoor boolean, organized_by int not null, foreign key(organized_by) references Participant(id) on delete cascade on update cascade)
        	 * create table Sport (id int primary key, foreign key(id) references Event(id) on delete cascade on update cascade, game varchar(200) not null)
        	 * create table Music (id int primary key, foreign key(id) references Event(id) on delete cascade on update cascade, genre varchar(200) not null, artist varchar(200) not null)
        	 * create table Technology (id int primary key, foreign key(id) references Event(id) on delete cascade on update cascade, category enum('Mobile','Robotics','Cloud') not null)
        	 * create table Event_Attendee (event_id int not null, foreign key (event_id) references Event(id) on delete cascade on update cascade, user_id int not null, foreign key (user_id) references Participant(id) on delete cascade on update cascade, primary key (event_id, user_id), noOfGuests int)
        	 * create table Event_Interests (event_id int not null, foreign key (event_id) references Event(id) on delete cascade on update cascade, user_id int not null, foreign key (user_id) references Participant(id) on delete cascade on update cascade,primary key (event_id, user_id))
        	 * */
        	createTables.put("Participant", "create table Participant("
        			+ " id int primary key auto_increment,"
        			+ " name varchar(200) not null,"
        			+ " email varchar(200) not null,"
        			+ " phone varchar(200) not null,"
        			+ " unique(email, phone),"
        			+ " zipcode varchar(5) not null,"
        			+ " isAdmin boolean default false"
        			+ ")");
        	createTables.put("Attendee", "create table Attendee("
        			+ " id int primary key,"
        			+ " foreign key(id) references Participant(id) on delete cascade on update cascade"
        			+ ")");
        	createTables.put("Organizer", "create table Organizer("
        			+ " id int primary key,"
        			+ " foreign key(id) references Participant(id) on delete cascade on update cascade,"
        			+ " type enum('Individual', 'Company') not null,"
        			+ " company varchar(200) not null"
        			+ ")");
        	createTables.put("Event", "create table Event("
        			+ " id int primary key auto_increment,"
        			+ " name varchar(200) not null,"
        			+ " description varchar(200) not null,"
        			+ " address varchar(200) not null,"
        			+ " total_seats int not null,"
        			+ " time varchar(10) not null,"
        			+ " date varchar(10) not null,"
        			+ " isIndoor boolean not null,"
        			+ " organized_by int not null,"
        			+ " foreign key(organized_by) references Participant(id) on delete cascade on update cascade"
        			+ ")");
        	createTables.put("Sport", "create table Sport("
        			+ " id int primary key,"
        			+ " foreign key(id) references Event(id) on delete cascade on update cascade,"
        			+ " game varchar(200) not null"
        			+ ")");
        	createTables.put("Music", "create table Music("
        			+ " id int primary key,"
        			+ " foreign key(id) references Event(id) on delete cascade on update cascade,"
        			+ " genre varchar(200) not null,"
        			+ " artist varchar(200) not null"
        			+ ")");
        	createTables.put("Technology", "create table Technology("
        			+ " id int primary key,"
        			+ " foreign key(id) references Event(id) on delete cascade on update cascade,"
        			+ " category enum('Mobile','Robotics','Cloud') not null"
        			+ ")");
        	createTables.put("Event_Attendee", "create table Event_Attendee("
        			+ " event_id int not null,"
        			+ " foreign key (event_id) references Event(id) on delete cascade on update cascade,"
        			+ " user_id int not null,"
        			+ " foreign key (user_id) references Participant(id) on delete cascade on update cascade,"
        			+ " primary key (event_id, user_id),"
        			+ " noOfGuests int not null"
        			+ ")");
        	createTables.put("Event_Interests", "create table Event_Interests("
        			+ " event_id int not null,"
        			+ " foreign key (event_id) references Event(id) on delete cascade on update cascade,"
        			+ " user_id int not null,"
        			+ " foreign key (user_id) references Participant(id) on delete cascade on update cascade,"
        			+ " primary key (event_id, user_id)"
        			+ ")");
        	
        	for(String table : createTables.keySet()) {
        		createTableIfNotExists(conn, table, createTables.get(table));
        	}
        	insertOneAdmin(conn);
        } catch(SQLException se){
        	//Handle errors for JDBC
        	se.printStackTrace();
        } catch(Exception e){
  	       //Handle errors for Class.forName
  	       e.printStackTrace();
  	    } finally{
  		    //finally block used to close resources
  		    in.close();
  		    try{
  			    if(stmt!=null) stmt.close();
  			    if(conn!=null) conn.close();
  		    } catch(SQLException se){
  			    se.printStackTrace();
  		    }
  	    }
        
    }
	
	public static void createDbIfNotExists() {
		   Connection conn = null;
		   Statement stmt = null;
		   
		   try{
			   Class.forName(JDBC_DRIVER);
			   
			   //check if DB already exists
			   conn = DriverManager.getConnection(DB_URL,USER,PASS);
			   ResultSet rs = conn.getMetaData().getCatalogs();
			   boolean db_exists = false; 
			   while(rs.next() && !db_exists) {
				   if(DB_NAME.equals(rs.getString(1))) db_exists = true;
			   }
			   if(!db_exists) {
				   String createDB = "CREATE DATABASE "+DB_NAME;
				   stmt = conn.createStatement();
				   stmt.executeUpdate(createDB);
			   }
		   }catch(SQLException se){
			   //Handle errors for JDBC
			   System.out.println("SQL Exception");
			   se.printStackTrace();
		   }catch(Exception e){
			   //Handle errors for Class.forName
			   System.out.println("Class.forName Exception");
			   e.printStackTrace();
		   }finally{
			   //finally block used to close resources
			   try{
				   if(stmt!=null) stmt.close();
			   }catch(SQLException se2){}// nothing we can do
			   try{
			       if(conn!=null) conn.close();
			   }catch(SQLException se){
				   System.out.println("Connection close Exception");
				   se.printStackTrace();
			   }
		   }
		   return;
	   }

	public static void createTableIfNotExists(Connection c, String tableName, String createSQL) throws SQLException, Exception {
		Statement s = null;
		DatabaseMetaData dbm = c.getMetaData();

		// check if table is there
		ResultSet tables = dbm.getTables(null, null, tableName, null);
		if (tables.next()) {
			// Table exists
			System.out.println("Table "+tableName+" already exists");
		} else {
			System.out.println("Creating "+tableName);
			// Table does not exist
			s = c.createStatement();
			s.executeUpdate(createSQL);
		}
		return;
	   }

	public static void insertOneAdmin(Connection c) throws SQLException, Exception {
		String selectSQL = "SELECT * from Participant";
		Statement s = c.createStatement();
		ResultSet rs = s.executeQuery(selectSQL);
		boolean adminPresent=false;
		while(rs.next()) {
			if(rs.getString("name").equals("EMS Admin") && rs.getBoolean("isAdmin")) {
				adminPresent = true;
				break;
			}
		}
		if(!adminPresent) {
	    	System.out.println("Creating an Admin account...");
	    	String insertAdmin = "INSERT INTO Participant(name,email,phone,zipcode,isAdmin) values('EMS Admin','ems@gmail.com','1234567890','02115',true)";
	    	s.executeUpdate(insertAdmin);
		}
	}
}
