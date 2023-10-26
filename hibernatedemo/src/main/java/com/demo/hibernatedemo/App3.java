package com.demo.hibernatedemo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.demo.hibernatedemo.config.HibernateUtility;

public class App3 {

	public static void main(String[] args) {
		SessionFactory sessionFactory=HibernateUtility.getSessionFactoryObject();
		 Session session=sessionFactory.openSession();
		 Query query= session.createNativeQuery("select prdid,prdname from product where prdcategory=?");
		 query.setParameter(1, "Book");
		 List<Object[]> products=query.getResultList();
		 for(Object[] p:products) {
			 for(Object o:p)
			 System.out.println(o);
		 }
		 session.close();

	}

}
