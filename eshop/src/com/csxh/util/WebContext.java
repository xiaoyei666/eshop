package com.csxh.util;

import javax.servlet.http.HttpServletRequest;

@SuppressWarnings("unchecked")
public class WebContext {

	private static final String Cart = "cart";

	private static final String User = "user";

	private static final String VerifCode = "verifcode";

	private static final String CTX = "ctx";

	// 在第一次被引用时被加载
	static class Nested {
		private static WebContext instance = new WebContext();
	}

	public static WebContext getInstance() {
		return Nested.instance;
	}

	private WebContext() {
		// TODO Auto-generated constructor stub
	}
	
	
	private static HttpServletRequest request;
	public static void saveContext(HttpServletRequest request) {
		request.setAttribute(WebContext.CTX, WebContext.getInstance());
		WebContext.request=request;
	}

	public static <T> void saveCart(HttpServletRequest request, T cart) {
		request.getSession().setAttribute(WebContext.Cart, cart);
		WebContext.saveContext(request);
	}

	public static <T> T getCart(HttpServletRequest request) {
		Object o = request.getSession().getAttribute(WebContext.Cart);
		if (o == null) {
			return null;
		} else {
			return (T) o;
		}
	}

	public static <T> T buildCart(HttpServletRequest request, Class<T> cartClazz) {

		T cart = WebContext.getCart(request);
		if (cart == null) {
			Object o = request.getSession().getAttribute(request.getRemoteHost());
			if (o != null) {
				return (T) o;
			}
			try {
				cart = cartClazz.newInstance();
				request.getSession().setAttribute(request.getRemoteHost(), cart);
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		WebContext.saveContext(request);

		return cart;
	}

	public static <T> void saveUser(HttpServletRequest request, T user) {
		request.getSession().setAttribute(WebContext.User, user);
		WebContext.saveContext(request);
	}

	public static <T> T getUser(HttpServletRequest request) {
		Object o = request.getSession().getAttribute(WebContext.User);
		if (o == null) {
			return null;
		} else {
			return (T) o;
		}
	}

	public static <T> boolean userLogined(HttpServletRequest request) {
		T user = WebContext.getUser(request);

		boolean fok = user != null;

		return fok;
	}

	public static <T, S> void userLoginSuccess(HttpServletRequest request, T user, Class<S> cartClazz) {
		
		WebContext.saveUser(request, user);
		
		S cart = WebContext.buildCart(request, cartClazz);
		WebContext.saveCart(request, cart);
		
		request.getSession().removeAttribute(request.getRemoteHost());
	}

	public static <T> void saveVerifCode(HttpServletRequest request, T verifcode) {
		request.getSession().setAttribute(WebContext.VerifCode, verifcode);
		WebContext.saveContext(request);
	}

	public static <T> T getVerifCode(HttpServletRequest request) {
		Object o = request.getSession().getAttribute(WebContext.VerifCode);
		if (o == null) {
			return null;
		} else {
			return (T) o;
		}
	}

	public static <T> boolean verifCodePassed(HttpServletRequest request, T inputCode) {
		T code = WebContext.getVerifCode(request);
		return inputCode.equals(code);
	}
	
	public <T> T getCart(){
		return WebContext.getCart(WebContext.request);
	}
	
	public <T> T getUser(){
		return WebContext.getUser(WebContext.request);
	}

	public <T> T getVerifCode(){
		return WebContext.getVerifCode(WebContext.request);
	}

}
