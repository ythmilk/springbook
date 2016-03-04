package com.spring.book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("bookShopMul")
public class BookShopMulImp implements BookShopMul {
	@Autowired
	private BookShopService bookShopService;

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void buyMulBook(int userId, List<Integer> bookIdList) {
		for (int booId : bookIdList) {
			bookShopService.purcharceBook(userId, booId);
		}
	}

}
