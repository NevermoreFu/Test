package com.spring.jdbc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
public class JDBCTest {

		private ApplicationContext ctx = null;
		private JdbcTemplate jdbcTemplate = null;
		{
			ctx = new FileSystemXmlApplicationContext("src/applicationContext.xml");
			jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
		}
		
		@Test
		public void testQueryForObject(){
			String sql = "select * from student where name =?";
			//需要的类型  实体类-   -
			RowMapper<Student> rowMapper = new BeanPropertyRowMapper<>(Student.class);
			Student stu = jdbcTemplate.queryForObject(sql, rowMapper,"王黎");
			System.out.println(stu);
		}
		
		
		
		
/*		@Test
		public void testBatchInsert(){
			String sql = "insert into student value(?,?,?)";
			List<Object[]> batchArgs = new ArrayList<>();
			batchArgs.add(new Object[]{"李思怡","002",23});
			batchArgs.add(new Object[]{"蒋力","003",23});
			batchArgs.add(new Object[]{"吕凌霄","004",23});
			
			jdbcTemplate.batchUpdate(sql, batchArgs);
			
		}*/
		
		
/*		@Test
		public void testUpdate(){
			String sql = "update Student set name = ? where name =?";
			jdbcTemplate.update(sql,"王黎","李德华");
		}*/
		
		
		
		/*@Test
		public void testDataSource() throws SQLException{
			DataSource dataSource = ctx.getBean(DataSource.class);
			System.out.println(dataSource.getConnection());
		}*/
		
}
