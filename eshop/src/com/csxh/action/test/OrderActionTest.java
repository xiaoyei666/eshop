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
		// 首选插入订单记录（只有一条）
		//Object[] os = JdbcUtil.queryForObject("select nextId from IdGenerater where tableName='order'");
		
		Transaction tx = null;
		try {
			// 打开会话对象
			Session se = HibernateSessionUtil.openSession();

			int orderId = (Integer)se.createSQLQuery(sql).list().get(0);

			// 使用面向对象而非面向SQL语句来执行插入
			// 面向对象的插入框架(orm)有很多（hibernate\eclipselink\toplink\orm\spring===>jpa）
			Order order = new Order();

			order.setCustomerId(1);
			order.setOrderId(orderId);
			order.setOrderDate(new Date());

			order.setDeliverName("deliverName");
			order.setDeliverCity("deli中文verCity");
			order.setDeliverZip("deliverZip");
			order.setDeliverPhone("deliverPhone");
			order.setDeliverAddres("deliverAddres");

			order.setPayMethodId(1);
			order.setShippingId(1);
			
			// 开启事务
			tx = se.beginTransaction();

			// 插入对象到表中
			se.save(order);

			// 再插入订单详细记录（有多条，每一个商品都对应一条记录）
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

			// hibernate的session提供了操作原生SQL的接口
			// 当完成订单插入后，要更新IdGenerater表中的nextId
			orderId++;
			sql = "update IdGenerater set nextId=" + orderId + " where tableName='order'";

			SQLQuery sq=se.createSQLQuery(sql);
			sq.executeUpdate();
			
			// 提交事务
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
