package com.csxh.action;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.csxh.model.Category;
import com.csxh.model.Product;
import com.csxh.model.SubCategory;
import com.csxh.util.JdbcUtil;
import com.opensymphony.xwork2.ActionContext;

public class IndexAction {


	public String handle() {

		//��struts�л�ȡJSP�����ö���
		
		
		// ��ȡindex.jsp����Ҫ��ģ�����ݣ������浽jspҳ�����ö�����

		// ��ȡ�������������б�
		String result = "fail";

		List<Category> categoryList = JdbcUtil.queryForObjectList(Category.class);

		if (categoryList != null && categoryList.size() > 0) {

			for (Category c : categoryList) {
				List<SubCategory> subList = JdbcUtil.queryForObjectList(SubCategory.class, "categoryId=" + c.getId());
				c.setChildren(subList);
			}

			ActionContext.getContext().put("categoryList", categoryList);
			//this.request.setAttribute("categoryList", categoryList);

			result = "success";
		}

		// ��ȡ�����ȵ��Ʒ�б�
		List<Product> hotProductList = new ArrayList<Product>(10);

		List<Object[]> objectList = JdbcUtil
				.queryForObjectList("select top 10 id,name from product order by visits desc");
		for (Object[] o : objectList) {

			Product p = new Product();

			p.setId((String) o[0]);
			p.setName((String) o[1]);

			hotProductList.add(p);

		}

		if (hotProductList.size() > 0) {
			ActionContext.getContext().put("hotProductList", hotProductList);
			//this.request.setAttribute("hotProductList", hotProductList);
			result = "success";
		}

		// ��ȡ���������б�
		List<Product> sellProductList = new ArrayList<Product>(10);

		objectList = JdbcUtil.queryForObjectList("select top 10 id,name from product order by sell desc");
		for (Object[] o : objectList) {

			Product p = new Product();

			p.setId((String) o[0]);
			p.setName((String) o[1]);

			sellProductList.add(p);

		}

		if (sellProductList.size() > 0) {
			
			ActionContext.getContext().put("sellProductList", sellProductList);
			//this.request.setAttribute("sellProductList", sellProductList);
			result = "success";
		}

		// ��ȡ������Ʒ
		List<Product> newProductList = new ArrayList<Product>(10);
		
		objectList = JdbcUtil.queryForObjectList(
				"select top 1 id,name,author,smallImg,description from product order by addDate desc");
		for (Object[] o : objectList) {

			Product p = new Product();

			p.setId((String) o[0]);
			p.setName((String) o[1]);
			p.setAuthor((String) o[2]);
			p.setSmallImg((String) o[3]);
			p.setDescription((String) o[4]);

			newProductList.add(p);
			break;

		}

		if (newProductList.size() > 0) {
			
			ActionContext.getContext().put("newProductList", newProductList);
			
			//this.request.setAttribute("newProductList", newProductList);
			result = "success";
		}

		// ��ȡ�Ƽ���Ʒ
		List<Product> commendProductList = new ArrayList<Product>(10);
		
		objectList = JdbcUtil.queryForObjectList(
				"select top 1 id,name,author,smallImg,description from product where commend=1");
		for (Object[] o : objectList) {
			
			Product p = new Product();
			
			p.setId((String) o[0]);
			p.setName((String) o[1]);
			p.setAuthor((String) o[2]);
			p.setSmallImg((String) o[3]);
			p.setDescription((String) o[4]);
			
			commendProductList.add(p);
			break;
			
		}
		
		if (commendProductList.size() > 0) {
			
			ActionContext.getContext().put("commendProductList", commendProductList);
			//this.request.setAttribute("commendProductList", commendProductList);
			result = "success";
		}

		// ��ȡ�ۿ���Ʒ
		List<Product> discountProductList = new ArrayList<Product>(10);
		
		objectList = JdbcUtil.queryForObjectList(
				"select top 1 id,name,author,smallImg,description,price,listPrice from product order by listPrice desc ");
		for (Object[] o : objectList) {
			
			Product p = new Product();
			
			p.setId((String) o[0]);
			p.setName((String) o[1]);
			p.setAuthor((String) o[2]);
			p.setSmallImg((String) o[3]);
			p.setDescription((String) o[4]);
			p.setPrice((BigDecimal) o[5]);
			p.setListPrice((BigDecimal) o[6]);
			
			discountProductList.add(p);
			break;
			
		}
		
		if (discountProductList.size() > 0) {
			
			ActionContext.getContext().put("discountProductList", discountProductList);
			//this.request.setAttribute("discountProductList", discountProductList);
			result = "success";
		}

		return result;
	}

}
