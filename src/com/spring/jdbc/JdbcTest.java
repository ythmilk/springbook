package com.spring.jdbc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class JdbcTest {
	private ApplicationContext act = null;
	private JdbcTemplate jdbcTemplate;

	{
		act = new ClassPathXmlApplicationContext("applicationContext.xml");
		jdbcTemplate = (JdbcTemplate) act.getBean("jdbcTemplate");
	}

	@Test
	public void testDataSource() throws SQLException {
		DataSource dataSource = act.getBean(DataSource.class);
		System.out.println(dataSource.getConnection());
	}

	/**
	 * 更新一条数据
	 */
	@Test
	public void testUpdate() {
		String updateSql = "UPDATE employees SET last_name= ? where id=?";
		jdbcTemplate.update(updateSql, "姚腾辉", 1);
	}

	/**
	 * 执行批量更新:批量的INSERT,UPDATE,DELETE 参数是一个Object数组集合
	 */
	@Test
	public void testInsert() {
		// String insertSql = "INSERT INTO employees
		// (id,last_name,email,dept_id)value(?,?,?,?)";
		// jdbcTemplate.update(insertSql, 4, "刘妍", "ly@ythmilk.com", 3);

		String sql = "INSERT INTO employees(last_name,email,dept_id) value(?,?,?)";
		List<Object[]> batchArgs = new ArrayList<>();
		batchArgs.add(new Object[] { "aa", "aa@ythmilk.com", 3 });
		batchArgs.add(new Object[] { "bb", "bb@ythmilk.com", 2 });
		batchArgs.add(new Object[] { "cc", "cc@ythmilk.com", 3 });
		jdbcTemplate.batchUpdate(sql, batchArgs);
	}

	/**
	 * 查询单行
	 */
	@Test
	public void querySingleLine() {
		String sql = "SELECT id,last_name,email FROM employees where id=?";
		RowMapper<Employees> rowMapper = new BeanPropertyRowMapper<>(Employees.class);
		System.out.println(jdbcTemplate.queryForObject(sql, rowMapper, 2));
	}

	/**
	 * 多行查询
	 */
	@Test
	public void querySeriesLine() {
		String sql = "SELECT id,last_name,email FROM employees where id>?";
		List<Employees> employees = new ArrayList<>();
		RowMapper<Employees> rowMapper = new BeanPropertyRowMapper<>(Employees.class);
		employees = jdbcTemplate.query(sql, rowMapper, 3);
		System.out.println(employees);
	}

	/** 获取单个列的值，或做统计查询 */
	@Test
	public void querySingleValue() {
		String sql = "SELECT count(id) FROM employees";
		int count = jdbcTemplate.queryForObject(sql, Integer.class);
		System.out.println(count);
	}

}
