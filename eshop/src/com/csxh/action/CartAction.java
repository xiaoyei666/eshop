package com.csxh.action;

import javax.servlet.http.HttpServletRequest;

import com.csxh.model.Cart;
import com.csxh.model.CartItem;

public class CartAction {

	public static final String Add = "add";
	public static final String Delete = "delete";
	public static final String Update = "update";
	public static final String Find = "find";

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
		
		Cart cart=new Cart();

		if(this.op.equals(CartAction.Add)){
			
		}else if(this.op.equals(CartAction.Delete)){
			
		}else if(this.op.equals(CartAction.Update)){
			
		}else{
			
		}

		this.req.setAttribute("cart", cart);
		
		return result;
	}

	private String op;
	public void setOp(String op) {
	
		this.op=op;
		
	}

}
