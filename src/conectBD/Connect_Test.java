package conectBD;
import java.sql.*;

public class Connect_Test {

	public static void main(String[] args) {
		get_all();
	}

	private static void get_all() {
		String username = "root";
		String psw = "root";
		try {
			// create conection
			Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", username, psw);
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

}
