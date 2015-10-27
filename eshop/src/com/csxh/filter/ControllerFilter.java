package com.csxh.filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.csxh.action.CategoryAction;
import com.csxh.action.IndexAction;
import com.csxh.action.SubcategoryAction;
import com.csxh.model.ActionContext;
import com.csxh.util.Log4jUtil;

/**
 * Servlet Filter implementation class ControllerFilter
 */
@WebFilter(dispatcherTypes = { DispatcherType.REQUEST, DispatcherType.ERROR }, urlPatterns = { "*.jsp" })
public class ControllerFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public ControllerFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;

		String path = req.getServletPath();
		path = path.substring(1);

		// ��ʱPathInfo��request����servlet֮ǰ��û�б�����������ֻ���ֹ�����
		// path = req.getRequestURI();
		// String[] ss = path.split("[?]");
		// ss = ss[0].split("/");
		// path = ss[ss.length - 1];

		// �ɷ�ҵ���߼���action��
		if ("index.jsp".equals(path)) {

			Log4jUtil.info("ת����ҳAction����");
			IndexAction action = new IndexAction();
			Log4jUtil.info("ת��JSPҳ��ʹ�õ����ö���");
			action.setRequest(req);
			action.setSession(req.getSession());
			// action.setApplication(this.getServletContext());
			action.setParams(req.getParameterMap());
			Log4jUtil.info("����ҵ�����ݼ��߼�����");
			String result = action.handle();
			if ("success".equals(result)) {

				Log4jUtil.info("ת��JSPҳ��ʾ");

				request.getRequestDispatcher(path).forward(request, response);

			} else if ("fail".equals(result)) {

			}

		}

		if("category.jsp".equals(path)){
			
			ActionContext ctx=new ActionContext();
			ctx.setRequest(req);
			ctx.setSession(req.getSession());
			
			CategoryAction action = new CategoryAction();
			
			action.setActionContext(ctx);

			Log4jUtil.info("ת����ҳAction����");
			Log4jUtil.info("ת��JSPҳ��ʹ�õ����ö���");
			
			// action.setApplication(this.getServletContext());

			// ���ʹ�ÿ�ܣ���һ����ʹ�÷����Զ��ؽ������������Action���������
			String s = req.getParameter("id");

			action.setId(Integer.parseInt(s));

			Log4jUtil.info("����ҵ�����ݼ��߼�����");
			String result = action.handle();
			if ("success".equals(result)) {

				Log4jUtil.info("ת��JSPҳ��ʾ");

				request.getRequestDispatcher(path).forward(request, response);

			} else if ("fail".equals(result)) {

			}
			
		}
		
		if ("subcategory.jsp".equals(path)) {

			SubcategoryAction action = new SubcategoryAction();

			Log4jUtil.info("ת����ҳAction����");
			Log4jUtil.info("ת��JSPҳ��ʹ�õ����ö���");
			action.setRequest(req);
			action.setSession(req.getSession());
			// action.setApplication(this.getServletContext());

			// ���ʹ�ÿ�ܣ���һ����ʹ�÷����Զ��ؽ������������Action���������
			String s = req.getParameter("id");

			action.setId(Integer.parseInt(s));

			s = req.getParameter("currentPage");

			action.setCurrentPage(s == null ? 1 : Integer.parseInt(s));

			Log4jUtil.info("����ҵ�����ݼ��߼�����");
			String result = action.handle();
			if ("success".equals(result)) {

				Log4jUtil.info("ת��JSPҳ��ʾ");

				request.getRequestDispatcher(path).forward(request, response);

			} else if ("fail".equals(result)) {

			}
		}

		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
