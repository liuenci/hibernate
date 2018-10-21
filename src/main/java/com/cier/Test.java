package com.cier;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.cier.pojo.Employee;

public class Test {

	public static void main(String[] args) {
		final StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		SessionFactory sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Employee e1 = new Employee();
        e1.setId(1001);
        e1.setFirstName("Yii");
        e1.setLastName("Bai");

        Employee e2 = new Employee();
        e2.setId(1002);
        e2.setFirstName("Min");
        e2.setLastName("Su");

        session.persist(e1);
        session.persist(e2);
        
        transaction.commit();
        session.close();
        System.out.println("successfully saved");
	}

}
