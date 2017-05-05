package com.spring.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("bookShopService")
public class BookShopServiceImpl implements BookShopService {

	@Autowired
	private BookShopDao bookShopDao;
	
	//添加事务 
	//使用 propagation 制定事务的传播行为，即当前事务方法被另一个事务方法调用时
	//如何使用事务，是用以前的事务，还是新开一个事务，默认取值为，required，即
	//使用调用方法的事务
	@Transactional
	@Override
	public void purchase(String username, String isbn) {
			//获取书的单价
		int price = bookShopDao.findBookPriceByIsbn(isbn);
		
		    //更新书的库存
		bookShopDao.updateBookStock(isbn);
		    //更新用户的账户
		bookShopDao.updateUserAccount(username, price);
	}

}
