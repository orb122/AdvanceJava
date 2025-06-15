package com.banck.Config;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.banck.Entity.BanckAccount;

public class SessionProvider {
	
	public Session seesionGiven() {
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(BanckAccount.class);
		
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		
		return session;
	
	}

}
