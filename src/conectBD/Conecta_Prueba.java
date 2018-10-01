package conectBD;
import java.io.Console;
import java.sql.*;

public class Conecta_Prueba {

	public static void main(String[] args) {
		String username = "root";
		String psw = "root";
		try {
			// create conection
			Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", username, psw);
			// create object statement
			Statement myStatement = myConnection.createStatement();
			// SQL Query
			ResultSet resultSet = myStatement.executeQuery("SELECT * from productos");
			// The ResulSet object creates a table on memory
			
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
