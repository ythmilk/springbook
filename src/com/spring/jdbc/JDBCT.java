package com.spring.jdbc;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JDBCT {

	public static void main(String[] args) throws SQLException {
		ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
		DataSource dataSource = act.getBean(DataSource.class);
		System.out.println(dataSource.getConnection());
	}

}
