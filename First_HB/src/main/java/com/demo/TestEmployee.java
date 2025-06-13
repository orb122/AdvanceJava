package com.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestEmployee {
	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Employee.class);
		
		
	SessionFactory sf=	cfg.buildSessionFactory();
	Session session= sf.openSession();
	Employee emp=new Employee(101, "Omkar", 22);
	session.save(emp);
	
	
	session.beginTransaction().commit();
	}

}
