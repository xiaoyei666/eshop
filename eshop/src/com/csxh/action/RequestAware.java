package com.csxh.action;

import javax.servlet.http.HttpServletRequest;

public interface RequestAware {

	public void setRequest(HttpServletRequest request);
}
