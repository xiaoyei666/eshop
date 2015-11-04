package com.csxh.action;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.struts2.ServletActionContext;

import com.csxh.model.Cart;
import com.csxh.model.Customer;
import com.csxh.model.Paymethod;
import com.csxh.model.Shipping;
import com.csxh.util.MyBatisSessionUtil;
import com.csxh.util.ServletSessionUtil;

public class OrderAction {

	public String handle() {

		Cart cart = ServletSessionUtil.getCart(ServletActionContext.getRequest(), Cart.class);

		Customer user = ServletSessionUtil.getUser(ServletActionContext.getRequest());

		SqlSession session = MyBatisSessionUtil.openSession();

		List<Paymethod> paymethodList = session.selectList("com.csxh.model.Order.findPaymethodList");
		List<Shipping> shippingList = session.selectList("com.csxh.model.Order.findShippingList");

		ServletActionContext.getRequest().setAttribute("paymethodList", paymethodList);
		ServletActionContext.getRequest().setAttribute("shippingList", shippingList);

		return "success";
	}
}
