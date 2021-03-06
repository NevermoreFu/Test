package com.spring.tx;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class SpringTransactionTest {

	private ApplicationContext ctx =null;
	private BookShopDao bookShopDao = null;
	private BookShopService bookShopService;
	private Cashier cashier =null;
	{
		ctx = new FileSystemXmlApplicationContext("src/applicationContext.xml");
		bookShopDao = ctx.getBean(BookShopDao.class);
		bookShopService = ctx.getBean(BookShopService.class);
		cashier = ctx.getBean(Cashier.class);
	}
	
	@Test
	public void testTransactionalPropagation(){
		cashier.Checkout("AA", Arrays.asList("1001","1002"));
	}
	
	
//	@Test
//	public void testBookShopService(){
//		bookShopService.purchase("AA", "1001");
//		
//	}
	
//	@Test
//	public void testBookShopDaoUpdateUserAccount(){
//		bookShopDao.updateUserAccount("AA", 200);
//		
//	}
//	
//	
//	
//	@Test
//	public void testBookShopDaoUpdateBookStock(){
//		bookShopDao.updateBookStock("1001");
//	}
//	
//	
//	
//	@Test
//	public void testBookShopDaoFindPriceByIsbn() {
//		System.out.println(bookShopDao.findBookPriceByIsbn("1001"));
//			
//	
//	}

}
