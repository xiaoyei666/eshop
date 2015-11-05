package com.csxh.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class MyBatisSessionUtil {

	private static SqlSessionFactory factory;

	static {
		try {
			InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
			factory = new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static final ThreadLocal<SqlSession> session = new ThreadLocal<SqlSession>();

	public static SqlSession openSession() {

		Object o = session.get();
		if (o != null) {
			return (SqlSession) o;
		} else {
			SqlSession s = factory.openSession();
			session.set(s);
			return s;
		}

	}

	public static void closeSession() {
		SqlSession s = (SqlSession) session.get();
		if (s != null) {
			s.close();
		}
		session.set(null);
	}

}
