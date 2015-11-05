package com.csxh.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionUtil {

	private static SessionFactory factory;

	static {
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static final ThreadLocal<Session> session = new ThreadLocal<Session>();

	public static Session openSession() {
		Object o = session.get();
		if (o != null) {
			return (Session) o;
		} else {
			Session s = factory.openSession();
			session.set(s);
			return s;
		}
	}
	
	public static void closeSession() throws HibernateException {
        Session s = (Session) session.get();
        if (s != null){        	
        	s.close();
        }
        session.set(null);
    }

}
