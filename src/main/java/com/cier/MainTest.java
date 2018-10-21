package com.cier;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.cier.pojo2.ContractEmployee;
import com.cier.pojo2.Employee;
import com.cier.pojo2.RegularEmployee;

public class MainTest {
    public static void main(String[] args) {
        // 但在5.1.0版本汇总，hibernate则采用如下新方式获取：
        // 1. 配置类型安全的准服务注册类，这是当前应用的单例对象，不作修改，所以声明为final
        // 在configure("cfg/hibernate.cfg.xml")方法中，如果不指定资源路径，默认在类路径下寻找名为hibernate.cfg.xml的文件
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        // 2. 根据服务注册类创建一个元数据资源集，同时构建元数据并生成应用一般唯一的的session工厂
        SessionFactory sessionFactory = new MetadataSources(registry)
                .buildMetadata().buildSessionFactory();

        /**** 上面是配置准备，下面开始我们的数据库操作 ******/
        Session session = sessionFactory.openSession();// 从会话工厂获取一个session

        // creating transaction object
        Transaction t = session.beginTransaction();

        Employee e1 = new Employee();
        e1.setName("用户名-01");

        RegularEmployee e2 = new RegularEmployee();
        e2.setName("yiibai su");
        e2.setSalary(50002);
        e2.setBonus(5);

        ContractEmployee e3 = new ContractEmployee();
        e3.setName("Mina su");
        e3.setPayPerHour(1010);
        e3.setContractDuration("15 hours");

        session.persist(e1);
        session.persist(e2);
        session.persist(e3);

        t.commit();
        session.close();
        System.out.println("success");
    }
}
