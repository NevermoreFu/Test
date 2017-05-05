package com.spring.tx;

import java.util.List;

public interface Cashier {
	
	public void Checkout(String username, List<String> isbns);
	
}
