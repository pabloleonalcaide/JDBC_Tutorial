package conectBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * 
 * @author pablo
 *
 */
public class Edit_JDBC {
	protected static String[] credentials = { "jdbc:mysql://localhost:3306/pruebas", "root", "root" };

	public static void main(String[] args) {
		// insertProduct();
		// updateProduct();
		// deleteProduct();
	}
	
	private static void get_all() {
		
		try {
			// create conection
			Connection myConnection = getConnection();			
			// create object statement
			Statement myStatement = myConnection.createStatement();
			// SQL Query - The ResulSet object creates a table on memory
			ResultSet resultSet = myStatement.executeQuery("SELECT * from productos");			
			// Iterate the resulset object
			while (resultSet.next()) {
				System.out.println(resultSet.getString("nombre")+ " " + resultSet.getString("seccion"));
			}
		} catch (Exception e) {
			System.out.println("Connection Error");
			System.out.println(e.getMessage());
		}
	}

	private static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(credentials[0], credentials[1],
				credentials[2]);
	}
	private static void insertProduct() {
		try {
			Connection myConnection = getConnection();
			Statement myStatement = myConnection.createStatement();
			String query = "INSERT INTO productos(seccion, nombre, precio, pais) VALUES ('fontaneria','tuberia', 12, 'Francia')";
			myStatement.executeUpdate(query);
			System.out.println("Insert done");
		} catch (Exception e) {
			System.out.println("Connection Error");
			System.out.println(e.getMessage());
		}
	}

	private static void updateProduct() {
		try {
			Connection myConnection = getConnection();
			Statement myStatement = myConnection.createStatement();
			String query = "UPDATE productos set precio=precio*2 where nombre='tuberia'";
			myStatement.executeUpdate(query);
			System.out.println("Update done");
		} catch (Exception e) {
			System.out.println("Connection Error");
			System.out.println(e.getMessage());
		}
	}
	private static void deleteProduct() {
		try {
			Connection myConnection = getConnection();
			Statement myStatement = myConnection.createStatement();
			String query = "delete from productos where nombre='tuberia'";
			myStatement.executeUpdate(query);
			System.out.println("Delete done");
		} catch (Exception e) {
			System.out.println("Connection Error");
			System.out.println(e.getMessage());
		}
	}

}
