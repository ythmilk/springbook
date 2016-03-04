package com.spring.book;

/** 数据库操作接口 */
public interface BookShopDAO {
	/** 根据书的id获取书的价格 */
	int findBookPrinceBybookId(int bookId);
	/** 更新库存直接减1 */
	void updateBookStock(int bookId);
	/** 更新用户的账户余额 */
	void updateAccount(int userId, int prince);
}
