package conectBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * Class Connection
 * @author pablo
 *
 */
public class DB_Connection {
	private String[] credentials = { "jdbc:mysql://localhost:3306/pruebas", "root", "root" };

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(credentials[0], credentials[1],
				credentials[2]);
	}
}
