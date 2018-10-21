package com.cier;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.cier.pojo1.ContractEmployee;
import com.cier.pojo1.Employee;
import com.cier.pojo1.RegularEmployee;


public class StoreData2 {

	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Employee e1 = new Employee();
        e1.setName("Yiibai");

        RegularEmployee e2 = new RegularEmployee();
        e2.setName("Max su");
        e2.setSalary(50000);
        e2.setBonus(5);

        ContractEmployee e3 = new ContractEmployee();
        e3.setName("Hippo su");
        e3.setPayPerHour(1000);
        e3.setContractDuration("15 hours");

        session.persist(e1);
        session.persist(e2);
        session.persist(e3);
        transaction.commit();
        session.close();
        System.out.println("successful saved");
	}

}
