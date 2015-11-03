package com.csxh.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.csxh.model.Cart;
import com.csxh.model.CartItem;
import com.csxh.util.Log4jUtil;
import com.csxh.util.ServletSessionUtil;

public class CartAction {

	public static final String Add = "add";
	public static final String Delete = "delete";
	public static final String Update = "update";
	public static final String Find = "find";
	public static final String Clean = "clean";
	public static final String List = "list";

	HttpServletRequest req;

	public void setRequest(HttpServletRequest req) {
		// TODO Auto-generated method stub
		this.req = req;
	}

	private CartItem item;

	public void setItem(CartItem item) {
		// TODO Auto-generated method stub
		this.item = item;
	}

	public String handle() {

		
		String result = "success";

		
		Cart cart=ServletSessionUtil.getCart(this.req, Cart.class);
		
		if (this.op.equals(CartAction.Add)) {
			
			cart.add(this.item);

		} else if (this.op.equals(CartAction.Delete)) {

			cart.delete(this.item);
			
		} else if (this.op.equals(CartAction.Update)) {

			cart.update(this.item,this.item.getProductCount());
			
		} else if (this.op.equals(CartAction.Clean)) {

			cart.clean();
			
		}else {
			
		}
		
		//判断用户是否登录，如果不有登录，则返回 "login"，告诉过滤器转向登录页，而不是购物页
		if(!ServletSessionUtil.isLoggined(this.req)){
			
			return "login";
			
		}else{			
			
			return "success";
		}

	}

	private String op;

	public void setOp(String op) {

		this.op = op;

	}

}
