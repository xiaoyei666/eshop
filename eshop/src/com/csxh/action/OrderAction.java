package com.csxh.action;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.csxh.model.Cart;
import com.csxh.model.CartItem;
import com.csxh.model.Customer;
import com.csxh.model.Order;
import com.csxh.model.OrderDetail;
import com.csxh.model.Paymethod;
import com.csxh.model.Shipping;
import com.csxh.util.HibernateSessionUtil;
import com.csxh.util.JdbcUtil;
import com.csxh.util.Log4jUtil;
import com.csxh.util.MyBatisSessionUtil;
import com.csxh.util.ServletSessionUtil;

public class OrderAction {

	private String deliverName;
	private String deliverCity;
	private String deliverPhone;
	private String deliverZip;
	private String deliverAddres;
	private String op = "add";

	public void setDeliverName(String deliverName) {
		this.deliverName = deliverName;
	}

	public void setDeliverCity(String deliverCity) {
		this.deliverCity = deliverCity;
	}

	public void setDeliverPhone(String deliverPhone) {
		this.deliverPhone = deliverPhone;
	}

	public void setDeliverZip(String deliverZip) {
		this.deliverZip = deliverZip;
	}

	public void setDeliverAddres(String deliverAddres) {
		Log4jUtil.info(deliverAddres);
		this.deliverAddres = deliverAddres;
	}

	public void setOp(String op) {
		this.op = op;
	}

	private Integer payMethodId;

	public void setPayMethodId(Integer payMethodId) {
		Log4jUtil.info(payMethodId);
		this.payMethodId = payMethodId;
	}

	private Integer shippingId;

	public void setShippingId(Integer shippingId) {
		
		this.shippingId = shippingId;
	}

	public String handle() {

		
		
		// �ռ�һЩ�Ѿ��еĶ�����Ϣ
		Customer user = ServletSessionUtil.getUser(ServletActionContext.getRequest());
		if(user==null){
			return "login";
		}
		
		Cart cart = ServletSessionUtil.getCart(ServletActionContext.getRequest(), Cart.class);

		// �ж��Ƿ񴫲���
		if (this.payMethodId == null) {// ��ʾ��
			
			
			
			SqlSession session = MyBatisSessionUtil.openSession();

			List<Paymethod> paymethodList = session.selectList("com.csxh.model.Order.findPaymethodList");
			List<Shipping> shippingList = session.selectList("com.csxh.model.Order.findShippingList");

			ServletActionContext.getRequest().setAttribute("paymethodList", paymethodList);
			ServletActionContext.getRequest().setAttribute("shippingList", shippingList);
			
			return "success";
			
		} else {// ��������ύ

			Transaction tx=null;
			try {
				//�򿪻Ự����
				Session se = HibernateSessionUtil.openSession();

				// ��ѡ���붩����¼��ֻ��һ����
				//Object[] os = JdbcUtil.queryForObject("select nextId from IdGenerater where tableName='order'");
				String sql="select nextId from IdGenerater where tableName='order'";
				int orderId = (Integer)se.createSQLQuery(sql).list().get(0);
				
				// ʹ����������������SQL�����ִ�в���
				// �������Ĳ�����(orm)�кܶࣨhibernate\eclipselink\toplink\orm\spring===>jpa��
				Order order = new Order();
				
				order.setCustomerId(user.getId());
				order.setOrderId(orderId);
				order.setOrderDate(new Date());
				order.setDeliverName(this.deliverName);
				order.setDeliverCity(this.deliverCity);
				order.setDeliverZip(this.deliverZip);
				order.setDeliverPhone(this.deliverPhone);
				order.setDeliverAddres(this.deliverAddres);
				order.setPayMethodId(this.payMethodId);
				order.setShippingId(this.shippingId);

				
				//��������
				tx = se.beginTransaction();
				
				//������󵽱���
				se.save(order);
				
				// �ٲ��붩����ϸ��¼���ж�����ÿһ����Ʒ����Ӧһ����¼��
				//orderdetail
				
				for(CartItem item : cart.getItemList()){
					
					OrderDetail detail=new OrderDetail();
					
					detail.setOrderId(orderId);
					detail.setProductId(item.getProductId());
					detail.setProductName(item.getProductName());
					detail.setProductQuantity(item.getProductCount());
					detail.setProductWeight(item.getProductWeight());
					detail.setTotalPrice(new java.math.BigDecimal( item.getProductCount()*item.getProductPrice()));
					
					se.save(detail);
				}
				

				// ����ɶ��������Ҫ����IdGenerater���е�nextId
				sql="update IdGenerater set nextId=" + (orderId + 1) + " where tableName='order'";
				se.createSQLQuery(sql).executeUpdate();
				
				//JdbcUtil.queryForObject(sql);
				//�ύ����
				tx.commit();
				
				ServletActionContext.getRequest().setAttribute("order", order);
				
				return "checkorder";
				
			} catch (Exception e) {
				if(tx!=null){
					tx.rollback();
				}
				e.printStackTrace();
			}

		}

		return "faile";
	}
}
