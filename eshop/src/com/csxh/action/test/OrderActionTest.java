package com.csxh.action.test;

import java.util.Date;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.csxh.model.Order;
import com.csxh.model.OrderDetail;
import com.csxh.util.HibernateSessionUtil;
import com.csxh.util.JdbcUtil;

public class OrderActionTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {

		String sql="select nextId from IdGenerater where tableName='order'";
		// ��ѡ���붩����¼��ֻ��һ����
		//Object[] os = JdbcUtil.queryForObject("select nextId from IdGenerater where tableName='order'");
		
		Transaction tx = null;
		try {
			// �򿪻Ự����
			Session se = HibernateSessionUtil.openSession();

			int orderId = (Integer)se.createSQLQuery(sql).list().get(0);

			// ʹ����������������SQL�����ִ�в���
			// �������Ĳ�����(orm)�кܶࣨhibernate\eclipselink\toplink\orm\spring===>jpa��
			Order order = new Order();

			order.setCustomerId(1);
			order.setOrderId(orderId);
			order.setOrderDate(new Date());

			order.setDeliverName("deliverName");
			order.setDeliverCity("deli����verCity");
			order.setDeliverZip("deliverZip");
			order.setDeliverPhone("deliverPhone");
			order.setDeliverAddres("deliverAddres");

			order.setPayMethodId(1);
			order.setShippingId(1);
			
			// ��������
			tx = se.beginTransaction();

			// ������󵽱���
			se.save(order);

			// �ٲ��붩����ϸ��¼���ж�����ÿһ����Ʒ����Ӧһ����¼��
			// orderdetail

			// for (CartItem item : cart.getItemList()) {

			OrderDetail detail = new OrderDetail();

			detail.setOrderId(orderId);
			detail.setProductId("ProductId");
			detail.setProductName("getProductName");
			detail.setProductQuantity(1);
			detail.setProductWeight(1);
			detail.setTotalPrice(new java.math.BigDecimal(1));

			se.save(detail);
			// }

			// hibernate��session�ṩ�˲���ԭ��SQL�Ľӿ�
			// ����ɶ��������Ҫ����IdGenerater���е�nextId
			orderId++;
			sql = "update IdGenerater set nextId=" + orderId + " where tableName='order'";

			SQLQuery sq=se.createSQLQuery(sql);
			sq.executeUpdate();
			
			// �ύ����
			tx.commit();

			HibernateSessionUtil.closeSession();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();

			Assert.assertFalse(true);
		}

	}

}
