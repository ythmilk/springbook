package com.spring.book;

/** ���ݿ�����ӿ� */
public interface BookShopDAO {
	/** �������id��ȡ��ļ۸� */
	int findBookPrinceBybookId(int bookId);
	/** ���¿��ֱ�Ӽ�1 */
	void updateBookStock(int bookId);
	/** �����û����˻���� */
	void updateAccount(int userId, int prince);
}
