package com.sln.MyHiber;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtils {
	static SessionFactory sessionFactory;
	static {
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		try {
			sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
			
		} catch (Exception e) {
			System.out.println("Some problem");
			StandardServiceRegistryBuilder.destroy( registry );
		}
	}
}
