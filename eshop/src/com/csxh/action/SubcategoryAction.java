package com.csxh.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;

import com.csxh.model.Category;
import com.csxh.model.Pager;
import com.csxh.model.Product;
import com.csxh.model.SubCategory;
import com.csxh.util.JdbcUtil;

public class SubcategoryAction implements RequestAware{

	Map<String, Object> req;//代替request


	@Override
	public void setRequest(Map<String, Object> req) {
		// TODO Auto-generated method stub
		this.req=req;
	}
	
	Map<String, String[]> parameterMap;

	public void setParams(Map<String, String[]> parameterMap) {
		this.parameterMap = parameterMap;

	}

	public String handle() {

		String result = "fail";

		// 根据传过来的id获取子类信息
		SubCategory subCategory = new SubCategory();
		subCategory.setId(this.id);

		// 通过id查询数据库中的subCategory信息
		List<Object[]> objectList = JdbcUtil.queryForObjectList(
				"select name,description,img,style,categoryId from subCategory where id= " + this.id);
		for (Object[] objects : objectList) {

			subCategory.setName((String) objects[0]);
			subCategory.setDescription((String) objects[1]);
			subCategory.setImg((String) objects[2]);
			subCategory.setStyle((String) objects[3]);

			Integer categoryId = (Integer) objects[4];
			// 通过大类别id查询数据库中的category信息
			objectList = JdbcUtil.queryForObjectList(
					"select name,description,bigImg,smallImg,style from category where id= " + categoryId);
			Category category = new Category();
			category.setId(categoryId);
			for (Object[] objs : objectList) {

				category.setName((String) objs[0]);
				category.setDescription((String) objs[1]);
				category.setBigImg((String) objs[2]);
				category.setSmallImg((String) objs[3]);
				category.setStyle((String) objs[4]);

				result = "success";

				break;
			}

			subCategory.setCategory(category);

			break;

		}

		// 将子类别对象保存在JSP的内置对象中，以便在JSP中使用
		this.req.put("subCategory", subCategory);

		// 根据分页条件获取产品的列表信息
		// String sql="select count(id) from product where subCategoryId= "
		// +this.id;
		int totalRows = JdbcUtil.queryTotalRows("product", "id", "subCategoryId =" + this.id);
		
		String pageRows =ServletActionContext.getServletContext().getInitParameter("pageRows");

		Pager pager = new Pager(totalRows, pageRows != null ? Integer.parseInt(pageRows) : 3);

		// 设置当前页号
		pager.setCurrentPage(this.currentPage);

		String sql = "select top " + pager.getPageRows()
				+ " id,name,smallImg,description, price,listPrice,hotDeal from product where subCategoryId=" + this.id
				+ " and id not in( select top " + pager.getFirstRow() + " id from product where subCategoryId="
				+ this.id + ")";

		List<Product> productList = new ArrayList<Product>(pager.getPageRows());
		objectList = JdbcUtil.queryForObjectList(sql);
		for (Object[] objects : objectList) {

			Product p = new Product();

			p.setId((String) objects[0]);
			p.setName((String) objects[1]);
			p.setSmallImg((String) objects[2]);
			p.setDescription((String) objects[3]);
			p.setPrice((java.math.BigDecimal) objects[4]);
			p.setListPrice((java.math.BigDecimal) objects[5]);
			p.setHotDeal((Boolean) objects[6]);

			productList.add(p);
		}

		this.req.put("pager", pager);
		this.req.put("productList", productList);

		// 本类推荐商品
		sql = "select top 10 id,name from product where commend=1 and subCategoryId=" + this.id;
		objectList = JdbcUtil.queryForObjectList(sql);
		List<Product> commendProductList = new ArrayList<Product>();
		for (Object[] objects : objectList) {

			Product p = new Product();
			p.setId((String) objects[0]);
			p.setName((String) objects[1]);
			commendProductList.add(p);
		}
		this.req.put("commendProductList", commendProductList);
		// 本类畅销商品
		sql = "select top 10 id,name from product where subCategoryId=" + this.id +"order by sell desc";
		objectList = JdbcUtil.queryForObjectList(sql);
		List<Product> bestSellProductList = new ArrayList<Product>();
		for (Object[] objects : objectList) {
			
			Product p = new Product();
			p.setId((String) objects[0]);
			p.setName((String) objects[1]);
			bestSellProductList.add(p);
		}
		this.req.put("bestSellProductList", bestSellProductList);

		return result;
	}

	private Integer id;

	// 该方法由过滤器根据传送参数的名称自动被调用
	public void setId(Integer id) {
		this.id = id;
	}

	private Integer currentPage=1;

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage==null ? 1 :currentPage;
		
	}


}
