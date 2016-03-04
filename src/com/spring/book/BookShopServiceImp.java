package com.spring.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 根据用户id和书id来购买
 */
@Service("bookShopService")
public class BookShopServiceImp implements BookShopService {
	@Autowired
	private BookShopDAO bookShopDAO;

	// 添加事物声明
	@Transactional
	@Override
	public void purcharceBook(int userId, int bookId) {
		// 1,根据bookid查询价格
		int prince = bookShopDAO.findBookPrinceBybookId(bookId);
		// 2.根据bookid让库存减一
		bookShopDAO.updateBookStock(bookId);
		// 3.根据用户id和价格更新用户账户
		bookShopDAO.updateAccount(userId, prince);
	}
}
