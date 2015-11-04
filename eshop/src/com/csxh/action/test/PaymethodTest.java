package com.csxh.action.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.csxh.model.CartItem;
import com.csxh.util.MyBatisSessionUtil;

public class PaymethodTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {

		SqlSession session = MyBatisSessionUtil.openSession();
//		List<Paymethod> list = session.selectList("com.csxh.model.Order.findPaymethodList");
//		List<Paymethod> list = session.selectList("com.csxh.model.Order.findShippingList");
//		System.out.println(list);
//		Assert.assertNotNull(list);
	CartItem item=	session.selectOne("com.csxh.model.Order.findCartItem","ISBN 7-900054-37-5/TP.38");
	
	System.out.println(item);
	Assert.assertNotNull(item);
		session.close();

	}

}
