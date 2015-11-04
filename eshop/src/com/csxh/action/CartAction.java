package com.csxh.action;

import org.apache.ibatis.session.SqlSession;
import org.apache.struts2.ServletActionContext;

import com.csxh.model.Cart;
import com.csxh.model.CartItem;
import com.csxh.util.MyBatisSessionUtil;
import com.csxh.util.ServletSessionUtil;
import com.opensymphony.xwork2.ActionSupport;

public class CartAction extends ActionSupport {

	public static final String Add = "add";
	public static final String Delete = "delete";
	public static final String Update = "update";
	public static final String Find = "find";
	public static final String Clean = "clean";
	public static final String List = "list";

	private String productId;
	
	public void setProductId(String productId) {
		this.productId = productId;
	}
	
	private int productCount=1;
	
	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}
	
	private String op=CartAction.List;

	public void setOp(String op) {

		this.op = op;
	}

	
	public String handle() {

		
		String result = "success";

		SqlSession session=MyBatisSessionUtil.openSession();
		CartItem item=session.selectOne("com.csxh.model.Order.findCartItem", this.productId);
		session.close();
		
		item.setProductCount(this.productCount);
		
		Cart cart=ServletSessionUtil.getCart(ServletActionContext.getRequest(), Cart.class);
		
		if (this.op.equals(CartAction.Add)) {
			
			cart.add(item);

		} else if (this.op.equals(CartAction.Delete)) {

			cart.delete(item);
			
		} else if (this.op.equals(CartAction.Update)) {

			cart.update(item,item.getProductCount());
			
		} else if (this.op.equals(CartAction.Clean)) {

			cart.clean();
			
		}else {
			
		}
		
		//�ж��û��Ƿ��¼��������е�¼���򷵻� "login"�����߹�����ת���¼ҳ�������ǹ���ҳ
		if(!ServletSessionUtil.isLoggined(ServletActionContext.getRequest())){
			
			return "login";
			
		}else{			
			
			return "success";
		}

	}

	
}
