package com.spring.book;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	private ApplicationContext act = null;
	private BookShopDAO bookShop = null;
	private BookShopService bookShopService = null;
	private BookShopMul bookShopMul = null;

	{
		act = new ClassPathXmlApplicationContext("applicationContext.xml");
		bookShop = (BookShopDAO) act.getBean("bookShopDAO");
		bookShopService = (BookShopService) act.getBean("bookShopService");
		bookShopMul = (BookShopMul) act.getBean("bookShopMul");
	}

	// ���Ը���bookid��ѯprince
	@Test
	public void testFindBookPrinceBybookId() {
		System.out.println(bookShop.findBookPrinceBybookId(1002));
	}

	// ��������ÿ��ִ�м�һ
	@Test
	public void testUpdateBookStock() {

		bookShop.updateBookStock(1001);
	}

	// �����˻�������
	@Test
	public void testUpdateAccount() {
		bookShop.updateAccount(1, 10);
	}

	// ���Թ������
	@Test
	public void testPurchase() {
		bookShopService.purcharceBook(1, 1001);
	}

	// ���Թ���౾��
	@Test
	public void testPurchaseMul() {
		List<Integer> bookList = new ArrayList<>();
		bookList.add(1001);
		bookList.add(1002);
		bookShopMul.buyMulBook(1, bookList);
	}

}
