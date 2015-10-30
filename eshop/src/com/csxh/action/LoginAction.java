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
			// ��������ʽ��֤û��ͨ�����������µ�¼
			return "input";
		}

		// ��֤�ʼ�������
		//SQL ע�빥�� ��һ��where�������ɶ������������ʱ�����п�����Ϊ����һ��Ϊ������� 1=1 and 2=2
		Customer customer = JdbcUtil.queryForObject(Customer.class, "email='" + this.customer.getEmail() + "'");

		if(customer==null || !customer.getPassword().equals(this.customer.getPassword())){
			//����û��ͨ��
			return "fail";					
		}
		
		//���ͨ���ˣ����ж��Ƿ���ڹ��ﳵ����
		HttpSession session = this.req.getSession();
		Object o=session.getAttribute(this.req.getRemoteHost());
		if(o!=null){
			
			//��ʱ�Ѿ������ˣ������ﳵ����ת�浽��user������
			session.setAttribute("user", customer);
			session.setAttribute("cart", o);
			//ɾ����ǰ������ip���µĹ��ﳵ
			session.removeAttribute(this.req.getRemoteHost());
			return "cart";
					
		}else{
			//��¼�ɹ�������û�й���
			return "index";
		}
		
	}

	public boolean validate() {
		// TODO Auto-generated method stub
		return true;
	}

}
