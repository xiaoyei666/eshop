package com.csxh.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.csxh.model.Category;
import com.csxh.model.Pager;
import com.csxh.model.Product;
import com.csxh.model.Review;
import com.csxh.model.SubCategory;
import com.csxh.util.JdbcUtil;

public class ProductAction implements RequestAware {

	private String id;

	public void setId(String id) {
		this.id = id;
	}

	private int currentPage;

	public void setCurrentPage(int currentPage) {
		// TODO Auto-generated method stub
		this.currentPage = currentPage;
	}

	public String handle() {

		String result = "fail";

		String sql = "SELECT [id],[name],[categoryId]," + "[subCategoryId],[supplier],[author],"
				+ "[description],[price],[listPrice]," + "[pubDate],[addDate]," + "[smallImg]," + "[bigImg]"
				+ "FROM [product] WHERE [id]='" + this.id + "'";

		Object[] objects = JdbcUtil.queryForObject(sql);
		Product product = new Product();
		product.setId((String) objects[0]);
		product.setName((String) objects[1]);
		int categoryId = (Integer) objects[2];
		int subCategoryId = (Integer) objects[3];

		product.setSupplier((String) objects[4]);
		product.setAuthor((String) objects[5]);
		product.setDescription((String) objects[6]);
		product.setPrice((java.math.BigDecimal) objects[7]);
		product.setListPrice((java.math.BigDecimal) objects[8]);

		product.setPubDate((java.sql.Timestamp) objects[9]);
		product.setAddDate((java.sql.Timestamp) objects[10]);
		product.setSmallImg((String) objects[11]);
		product.setBigImg((String) objects[12]);

		// dddd
		sql = "select name from category where id=" + categoryId;
		objects = JdbcUtil.queryForObject(sql);
		Category c = new Category();
		c.setId(categoryId);
		c.setName((String) objects[0]);
		product.setCategory(c);

		sql = "select name from subCategory where id=" + subCategoryId;
		objects = JdbcUtil.queryForObject(sql);
		SubCategory sub = new SubCategory();
		sub.setId(categoryId);
		sub.setName((String) objects[0]);
		product.setSubCategory(sub);

		this.request.setAttribute("product", product);

		// 获取该产品的评论记录
		int totalRows = JdbcUtil.queryTotalRows("review", "id", "productId='" + this.id + "'");
		String s = this.request.getServletContext().getInitParameter("pageRows");
		int pageRows = s == null ? 3 : Integer.parseInt(s);

		Pager pager = new Pager(totalRows, pageRows);
		pager.setCurrentPage(this.currentPage);

		sql = "select top " + pager.getPageRows() + " id,name,email,content,[time] from review where productId='"
				+ this.id + "'" + " and id not in( select top " + pager.getFirstRow()
				+ " id from review where productId='" + this.id + "')";

		List<Review> reviewList = new ArrayList<Review>(pager.getPageRows());
		List<Object[]> objectList = JdbcUtil.queryForObjectList(sql);
		for (Object[] objs : objectList) {
			Review review = new Review();
			review.setId((Integer) objs[0]);
			review.setProductId(this.id);
			review.setName((String) objs[1]);
			review.setEmail((String) objs[2]);
			review.setContent((String) objs[3]);
			review.setTime((java.sql.Timestamp) objs[4]);
			reviewList.add(review);
		}

		this.request.setAttribute("pager", pager);
		this.request.setAttribute("reviewList", reviewList);

		return result;
	}

	HttpServletRequest request;

	@Override
	public void setRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
	}

}
