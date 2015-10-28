package com.csxh.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ActionContext {

	private HttpServletRequest req;
	public void setRequest(HttpServletRequest req) {
		this.req=req;
	}
	
	public HttpServletRequest getRequest() {
		return this.req;
	}
	

	public void setSession(HttpSession session) {
		// TODO Auto-generated method stub
		
	}

}
