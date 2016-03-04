package com.spring.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository("bookShopDAO")
public class BookShopDAOImp implements BookShopDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int findBookPrinceBybookId(int bookId) {
		String sql = "SELECT prince FROM book WHERE bookid=?";
		return jdbcTemplate.queryForObject(sql, Integer.class, bookId);
	}

	@Override
	public void updateBookStock(int bookId) {
		String sql2="SELECT stock FROM bookstock WHERE bookid=?";
		int stock=jdbcTemplate.queryForObject(sql2, Integer.class,1001);
		if (stock==0) {
			throw new BookStockException("¿â´æ²»×ã");
		}
		String sql = "UPDATE bookstock SET stock =stock-1 WHERE bookid=?";
		jdbcTemplate.update(sql, bookId);
	}

	@Override
	public void updateAccount(int userId, int prince) {
		// TODO Auto-generated method stub
		String sql2="SELECT balance FROM account WHERE userid=?";
		int balance=jdbcTemplate.queryForObject(sql2, Integer.class,1);
		if (balance<prince) {
			throw new UserAccountexception("Óà¶î²»×ã");
		}
		String sql = "UPDATE account SET balance=balance-? WHERE userid=?";
		jdbcTemplate.update(sql, prince, userId);
	}

}
