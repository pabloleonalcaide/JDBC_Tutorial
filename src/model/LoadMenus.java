package model;

import java.sql.*;

public class LoadMenus {
	DBConnection dbConnection;
	private ResultSet resultSet;
	private ResultSet resultSet2;
	public LoadMenus() {
		dbConnection = new DBConnection();
	}
	
	/*
	 * @return product section
	 */
	public String executeQuery() {
		Product product = null;
		Connection connection = dbConnection.getConnection();
		try {
			Statement sections = connection.createStatement();
			Statement countries = connection.createStatement();
			//get all the distincts sections from products
			resultSet = sections.executeQuery("SELECT DISTINCTROW seccion FROM productos");
			resultSet2 = countries.executeQuery("SELECT DISTINCTROW pais FROM productos");
			resultSet.first();
			resultSet2.first();
			product = new Product();
			product.setSeccion(resultSet.getString(1)); //our query only have one column
			product.setPais(resultSet2.getString(1));

		} catch (SQLException e) {
			System.out.println("Error on Load Menus");
			System.out.println(e.getMessage());
		}
		
		return product.getSeccion();
		
	}
	public ResultSet getResultSet() {
		return resultSet;
	}

	public void setResultSet(ResultSet resultSet) {
		this.resultSet = resultSet;
	}

	public ResultSet getResultSet2() {
		return resultSet2;
	}

	public void setResultSet2(ResultSet resultSet2) {
		this.resultSet2 = resultSet2;
	}


}
