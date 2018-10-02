package model;

import java.sql.*;

public class DBConnection {
	private String[] credentials = { "jdbc:mysql://localhost:3306/pruebas", "root", "root" };

	public DBConnection() {
		
	}
	public Connection getConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(credentials[0], credentials[1],
					credentials[2]);
		} catch (SQLException e) {
			System.out.println("Error Connection");
			System.out.println(e.getMessage());
		}
		return connection;
	}
}
