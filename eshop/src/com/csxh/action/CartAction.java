package com.csxh.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.csxh.model.Cart;
import com.csxh.model.CartItem;
import com.csxh.util.Log4jUtil;

public class CartAction {

	public static final String Add = "add";
	public static final String Delete = "delete";
	public static final String Update = "update";
	public static final String Find = "find";
	public static final String Clean = "clean";

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

		HttpSession session = this.req.getSession();
		
		
		String ip = this.req.getRemoteHost();
		
		Object o=null;
		Cart cart;
		
		//在已经登录时，通过user来缓存购物
		o=session.getAttribute("user");
		if(o==null){			
			
//			cart = new Cart();
//			session.setAttribute("user", cart);
			// 在没有登录时，通过IP地址来缓存购物
			o=session.getAttribute(ip);
			
			if(o==null){			
				cart = new Cart();
				session.setAttribute(ip, cart);
				
			}else{
				cart=(Cart)o;
			}

		}else{
			session.removeAttribute(ip);
			cart=(Cart)o;
		}
		
		//System.out.println(this.req.getHeader("referer"));
		
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

		this.req.setAttribute("cart", cart);

		return result;
	}

	private String op;

	public void setOp(String op) {

		this.op = op;

	}

}
