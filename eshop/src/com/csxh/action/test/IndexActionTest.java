package com.csxh.action.test;

import org.junit.Before;
import org.junit.Test;

import com.csxh.util.JdbcUtil;

public class IndexActionTest {

	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void testHandle() {
		//IndexAction action=new IndexAction();
		
		//Assert.assertEquals("success", action.handle());
		
		String sql="SELECT [unitWeight] FROM [orderDetail] ";
		
		Object[] objects=JdbcUtil.queryForObject(sql);
					
			System.out.println(objects);
		
	}

}
