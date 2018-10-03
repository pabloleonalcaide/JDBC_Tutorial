package model;

import java.sql.*;

public class ExecuteQueries {
	private String text;
	private DBConnection dbConnection;
	private ResultSet rSet;
	private PreparedStatement statementSection;
	private PreparedStatement statementCountry;
	private PreparedStatement statementAll;
	private final String querySection = "SELECT nombre, seccion, precio, pais FROM productos WHERE seccion = ?";
	private final String queryCountry = "SELECT nombre, seccion, precio, pais FROM productos WHERE pais = ?";
	private final String queryAll ="SELECT nombre, seccion, precio, pais FROM productos WHERE pais = ? and seccion = ?";
	public ExecuteQueries() {
		dbConnection= new DBConnection();
	}
	public ResultSet filterDB(String section, String country) {
		
		Connection connection = dbConnection.getConnection();
		
		rSet = null;
		try {
			if(!section.equals("Todos") && country.equals("Todos")) {
				statementSection = connection.prepareStatement(querySection);
				statementSection.setString(1, section);
				rSet = statementSection.executeQuery();
			}else if(section.equals("Todos") && !country.equals("Todos")) {
				statementCountry = connection.prepareStatement(queryCountry);
				statementCountry.setString(1, country);
				rSet = statementCountry.executeQuery();
			}else {
				statementAll = connection.prepareStatement(queryAll);
				statementAll.setString(1, country);
				statementAll.setString(2, section);
				rSet = statementAll.executeQuery();
			}
		} catch (SQLException e) {
			System.out.println("Error on ExecuteQueries");
			System.out.println(e.getMessage());
		}
		return rSet;
	}
}
