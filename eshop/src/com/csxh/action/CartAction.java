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

		HttpSession session = this.req.getSession();
		Object o=null;
		
		
		String ip = this.req.getRemoteHost();
		
		Cart cart;
		
		//���Ѿ���¼ʱ��ͨ��user�����湺��
		o=session.getAttribute("user");
		boolean isLogin=o!=null;
		if(!isLogin){			
			
//			cart = new Cart();
//			session.setAttribute("user", cart);
			// ��û�е�¼ʱ��ͨ��IP��ַ�����湺��
			o=session.getAttribute(ip);
			
			if(o==null){			
				cart = new Cart();
				session.setAttribute(ip, cart);
				
			}else{
				cart=(Cart)o;
			}

		}else{
			//���Ѿ���¼������Ǵ�login.jsp����,��op=list
			//���Ѿ���¼������Ǵ�product.jsp���£���op=add
			o=session.getAttribute("cart");
			if(o==null){
				cart=new Cart();
				session.setAttribute("cart", cart);
			}else{
				cart=(Cart)o;
			}
			
			//��ʱ�Ĳ���Ϊ�г��Ѿ�ѡ��õĹ��ﳵ������������ɾ�����Ĳ���
			
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
			this.req.setAttribute("cart", cart);
		}
		
		//�ж��û��Ƿ��¼��������е�¼���򷵻� "login"�����߹�����ת���¼ҳ�������ǹ���ҳ
		if(!isLogin){
			
			return "login";
			
		}else{			
			this.req.setAttribute("cart", cart);
			return "success";
		}

	}

	private String op;

	public void setOp(String op) {

		this.op = op;

	}

}
