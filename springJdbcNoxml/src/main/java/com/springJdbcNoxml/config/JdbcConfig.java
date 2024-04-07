package com.springJdbcNoxml.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.springJdbcNoxml.dao.StudentDaoImpl;

@Configuration
public class JdbcConfig {
	@Bean(name = { "template" })
	public JdbcTemplate getJdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(getdataSource());
		return jdbcTemplate;
	}

	@Bean(name = { "ds" })
	public DataSource getdataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/springJdbc");
		driverManagerDataSource.setPassword("root");
		driverManagerDataSource.setUsername("root");
		return driverManagerDataSource;
	}

	@Bean(name = { "studentDaoImpl" })
	public StudentDaoImpl getStudentDaoimpl() {
		StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
		studentDaoImpl.setJdbcTemplate(getJdbcTemplate());
		return studentDaoImpl;
	}
}
