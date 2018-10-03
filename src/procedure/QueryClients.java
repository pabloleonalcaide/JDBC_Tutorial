package procedure;

import java.sql.*;
import conectBD.DB_Connection;

/**
 * An Example of how works on JDBC  with Procedures
 * @author pablo
 */
public class QueryClients {
	static DB_Connection db_Connection = new DB_Connection();	
	public static void main(String[] args) {
		try {
			Connection connection = db_Connection.getConnection();
			// we call to our procedure, saved on the database
			CallableStatement sentence = connection.prepareCall("{call SHOW_CLIENTS}");
			
			ResultSet rSet = sentence.executeQuery();
			while (rSet.next()) {
				System.out.println(rSet.getString(1) + ", "+ rSet.getString(2) + ", " + rSet.getString(3));
			}
			rSet.close(); 
		} catch (SQLException e) {
			System.out.println("QueryClient Error: \n" +e.getMessage());
		}
	}
}
