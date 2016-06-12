package com.framework;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class SpringApp {

	public static void main(String[] args) throws SQLException {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config/messageApp.xml");
		BasicAndJDBCAppImpl messageApp = applicationContext.getBean("messageApp", BasicAndJDBCAppImpl.class);
		
		JdbcTemplate jdbcTemplate = messageApp.getJdbcTemplate();
		System.out.println(jdbcTemplate.queryForObject("Select COUNT(*) from Countries", Integer.class));

		List<String> list = jdbcTemplate.queryForList("Select COUNTRY_NAME from Countries ", String.class);
		System.out.println(list);

		List<Country> countries = jdbcTemplate.query("Select * from Countries", new RowMapper<Country>() {

			@Override
			public Country mapRow(ResultSet arg0, int arg1) throws SQLException {
				Country country = new Country();
				country.setCountryID(arg0.getString("COUNTRY_NAME"));
				country.setRegionID("REGION_ID");

				return country;
			}

		});

		String Parameter_SQL = "Select count(*) from Countries where region_id = :regionID";
		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource("regionID", 1);

		NamedParameterJdbcTemplate jdbcTemplate2 = messageApp.getNamedParameterJdbcTemplate();
		int count = jdbcTemplate2.queryForObject(Parameter_SQL, mapSqlParameterSource, Integer.class);
		System.out.println("Named 0" + count);

		try (Connection connection = messageApp.getDataSource().getConnection()) {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("Select COUNTRY_NAME from Countries ");
			while (resultSet.next()) {
				System.out.println(resultSet.getString("COUNTRY_NAME"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(messageApp.getMessage());

		// Hibernate

		HibernateApp hibernateApp = applicationContext.getBean("hibernateApp", HibernateApp.class);
//		List<Country> countries2 = hibernateApp.loadCountriesByRegion("0");
	}

}

class Country {
	private String countryID;
	private String regionID;

	public String getCountryID() {
		return countryID;
	}

	public void setCountryID(String countryID) {
		this.countryID = countryID;
	}

	public String getRegionID() {
		return regionID;
	}

	public void setRegionID(String regionID) {
		this.regionID = regionID;
	}
}
