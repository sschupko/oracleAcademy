package shop.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcDatabaseConnector {
	public static Connection getConnection() {
		try {
			Class.forName("org.h2.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:h2:mem:./db/shop", "sa", "");
			return con;
		} catch (Exception ex) {
			System.out.println("Database.getConnection() Error -->"
					+ ex.getMessage());
			return null;
		}
	}

	public static void close(Connection con) {
		try {
			con.close();
		} catch (Exception ex) {

		}
	}
}
