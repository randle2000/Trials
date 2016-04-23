package com.sln.MyHiber;

import org.hibernate.Session;

public class Hiber {

	public static void main(String[] args) {
		Session session = HibernateUtils.sessionFactory.openSession();
		session.beginTransaction();
		
		RootClass rc = new RootClass();
		rc.xField = 1;
		//rc.componentClass.csA=2;
		OneToManyClass a;
		a = new OneToManyClass(); a.rc=rc; rc.oneToManyList.add(a);
		a = new OneToManyClass(); a.rc=rc; rc.oneToManyList.add(a);
		a = new OneToManyClass(); a.rc=rc; rc.oneToManyList.add(a);
		a = new OneToManyClass(); a.rc=rc; rc.oneToManyList.add(a);
		
		rc.oneToOneClass = new OneToOneClass();
		rc.oneToOneClass.rc = rc;
		
		
		session.save(rc);
		
		session.getTransaction().commit();
		session.close();
		HibernateUtils.sessionFactory.close();
	}

}
