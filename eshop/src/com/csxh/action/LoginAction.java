package com.csxh.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.csxh.model.Cart;
import com.csxh.model.Customer;
import com.csxh.util.JdbcUtil;

public class LoginAction {

	HttpServletRequest req;

	public void setRequest(HttpServletRequest req) {
		// TODO Auto-generated method stub
		this.req = req;
	}

	Customer customer;

	public void setCustomer(Customer c) {
		// TODO Auto-generated method stub
		this.customer = c;
	}

	public String handle() {

		if (!validate()) {
			// 如果输入格式验证没有通过，让其重新登录
			return "input";
		}

		// 验证邮件与密码
		//SQL 注入攻击 当一个where条件是由多个子条件构造时，就有可能人为构造一个为真的条件 1=1 and 2=2
		Customer customer = JdbcUtil.queryForObject(Customer.class, "email='" + this.customer.getEmail() + "'");

		if(customer==null || !customer.getPassword().equals(this.customer.getPassword())){
			//内容没有通过
			return "fail";					
		}
		
		//如果通过了，则判断是否存在购物车对象
		HttpSession session = this.req.getSession();
		Object o=session.getAttribute(this.req.getRemoteHost());
		if(o!=null){
			
			//此时已经购物了，将购物车对象转存到以user的名下
			session.setAttribute("user", customer);
			session.setAttribute("cart", o);
			//删除以前保存在ip名下的购物车
			session.removeAttribute(this.req.getRemoteHost());
			return "cart";
					
		}else{
			//登录成功，但还没有购物
			return "index";
		}
		
	}

	public boolean validate() {
		// TODO Auto-generated method stub
		return true;
	}

}
