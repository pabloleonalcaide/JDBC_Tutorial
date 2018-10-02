package conectBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * Prepared statements for sql queries
 * @author pablo
 *
 */
public class PreparedStatements {
	protected static String[] credentials = { "jdbc:mysql://localhost:3306/pruebas", "root", "root" };
	public static DB_Connection db = new DB_Connection();
	public static void main(String[] args) {
		select("ferreteria","Grecia");
	}
	
	private static void select(String seccion, String pais) {
		try {
			Connection myConnection = db.getConnection();
			PreparedStatement preparedStatements = myConnection.prepareStatement("SELECT * from productos where seccion=? and pais=?");
			
			preparedStatements.setString(1, seccion); // define parameters for the query
			preparedStatements.setString(2, pais);
			
			ResultSet rSet = preparedStatements.executeQuery();
			while (rSet.next()) {
				System.out.println(rSet.getString("nombre"));
				
			}
			rSet.close(); // Clear memory
			
		} catch (SQLException e) {
			System.out.println("Connection Error");
			System.out.println(e.getMessage());
		}

	}
}
