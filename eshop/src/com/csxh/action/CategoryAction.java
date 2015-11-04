package com.csxh.action;

import java.util.ArrayList;
import java.util.List;

import com.csxh.model.Category;
import com.csxh.model.Product;
import com.csxh.model.SubCategory;
import com.csxh.util.JdbcUtil;
import com.csxh.util.Log4jUtil;
import com.opensymphony.xwork2.ActionContext;

public class CategoryAction {

	private int id;
	public void setId(int id) {
		// TODO Auto-generated method stub
		this.id=id;
		
	}
	public String handle() {
		
		Log4jUtil.info("进入大类处理");
		String result="fail";
		
		String top="top 5";
		String sql="select name from category where id=" + this.id;
		
		Category category=JdbcUtil.queryForObject(Category.class,"id="+this.id);
		
		List<SubCategory> subCategoryList=JdbcUtil.queryForObjectList(SubCategory.class, "categoryId="+this.id);
		category.setChildren(subCategoryList);
		
		ActionContext.getContext().put("category", category);
		
		List<Object[]> objectList=new ArrayList<Object[]>();
		sql="select "+top+" id,name,author,description,smallImg from product where categoryId="+this.id+" order by addDate desc";
		objectList=JdbcUtil.queryForObjectList(sql);

		List<Product>newProductList=new ArrayList<Product>();
		for(Object[] objects:objectList){
			Product p=new Product();
			p.setId((String)objects[0]);
			p.setName((String)objects[1]);
			p.setAuthor((String)objects[2]);
			p.setDescription((String)objects[3]);
			p.setSmallImg((String)objects[4]);
			newProductList.add(p);
			result="success";
		}
		
		ActionContext.getContext().put("newProductList", newProductList);
		sql="select "+top+" id,name,author,description,smallImg from product where commend=1 and categoryId="+this.id;
		objectList=JdbcUtil.queryForObjectList(sql);
		List<Product>commendProductList=new ArrayList<Product>();
		for(Object[] objects:objectList){
			Product p=new Product();
			p.setId((String)objects[0]);
			p.setName((String)objects[1]);
			p.setAuthor((String)objects[2]);
			p.setDescription((String)objects[3]);
			p.setSmallImg((String)objects[4]);
			commendProductList.add(p);
			
			result="success";
		}
		
		ActionContext.getContext().put("commendProductList", commendProductList);
		
		sql="select "+top+" id,name,author,description,price,listPrice,smallImg from product where hotDeal=1 and categoryId="+this.id;
		objectList=JdbcUtil.queryForObjectList(sql);
		
		List<Product>discountProductList=new ArrayList<Product>();
		
		for(Object[] objects:objectList){
			Product p=new Product();
			p.setId((String)objects[0]);
			p.setName((String)objects[1]);
			p.setAuthor((String)objects[2]);
			p.setDescription((String)objects[3]);
			p.setPrice((java.math.BigDecimal)objects[4]);
			p.setListPrice((java.math.BigDecimal)objects[5]);
			p.setSmallImg((String)objects[6]);
			discountProductList.add(p);
			
			result="success";
		}
		
		ActionContext.getContext().put("discountProductList", discountProductList);

		sql="select "+top+" id,name,author,description,smallImg from product where categoryId="+this.id +"order by sell desc";
		objectList=JdbcUtil.queryForObjectList(sql);
		
		List<Product>bestSellProductList=new ArrayList<Product>();
		
		for(Object[] objects:objectList){
			Product p=new Product();
			p.setId((String)objects[0]);
			p.setName((String)objects[1]);
			p.setAuthor((String)objects[2]);
			p.setDescription((String)objects[3]);
			p.setSmallImg((String)objects[4]);
			bestSellProductList.add(p);
			
			result="success";
		}
		
		ActionContext.getContext().put("bestSellProductList", bestSellProductList);
		
		return result;
	}
	
}
