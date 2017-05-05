package com.spring.tx;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("cashier")
public class CashierImpl implements Cashier {

	@Autowired
	private BookShopService bookShopService;
	
	@Transactional
	@Override
	public void Checkout(String username, List<String> isbns) {
		for(String isbn:isbns){
			//调用了以前的事务 该怎么调用呢？ 
			bookShopService.purchase(username, isbn);
		}
		
	}

}
