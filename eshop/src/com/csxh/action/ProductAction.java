package com.csxh.action;

import javax.servlet.http.HttpServletRequest;

public class ProductAction implements RequestAware {

	private String id;
	public void setId(String id) {
		this.id=id;
	}

	private int currentPage;
	public void setCurrentPage(int currentPage) {
		// TODO Auto-generated method stub
		this.currentPage=currentPage;
	}

	public String handle() {
		
		String result="fail";
		
		
		
		return result;
	}

	HttpServletRequest request;
	@Override
	public void setRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request=request;
	}

}
