package com.cier;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.cier.pojo.Employee;

public class StoreData {

	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Employee e1=new Employee();
        e1.setId(101);
        e1.setFirstName("Max");
        e1.setLastName("Su");
        session.persist(e1);
        transaction.commit();
        session.close();
        System.out.println("successful saved");
	}

}
