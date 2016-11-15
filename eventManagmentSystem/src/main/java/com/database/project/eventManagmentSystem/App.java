package com.database.project.eventManagmentSystem;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
    	
    	ApplicationContext applicationContext = new FileSystemXmlApplicationContext("beans.xml");
    	
        Participant participant = (Participant) applicationContext.getBean("participant");
        
        Admin admin = (Admin) applicationContext.getBean("admin");
        
        System.out.println(participant);
        System.out.println(admin);
    }
}