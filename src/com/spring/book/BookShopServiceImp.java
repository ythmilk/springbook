package com.spring.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * �����û�id����id������
 */
@Service("bookShopService")
public class BookShopServiceImp implements BookShopService {
	@Autowired
	private BookShopDAO bookShopDAO;

	// �����������
	@Transactional
	@Override
	public void purcharceBook(int userId, int bookId) {
		// 1,����bookid��ѯ�۸�
		int prince = bookShopDAO.findBookPrinceBybookId(bookId);
		// 2.����bookid�ÿ���һ
		bookShopDAO.updateBookStock(bookId);
		// 3.�����û�id�ͼ۸�����û��˻�
		bookShopDAO.updateAccount(userId, prince);
	}
}
