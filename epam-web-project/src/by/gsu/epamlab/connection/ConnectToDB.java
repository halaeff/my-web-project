package by.gsu.epamlab.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectToDB {
	private static final Logger LOGGER = Logger.getLogger(ConnectToDB.class.getName());
	final static String DB_URL = "jdbc:mysql://localhost/epam-web-project";
	final static String USER = "admin-web";
	final static String PASSWORD = "jee";
	final static String CLASS_NAME = "com.mysql.jdbc.Driver";
	private static Connection cn = null;
	static Statement st = null;

	public static Connection getConnection() {
		try {
			Class.forName(CLASS_NAME);
			cn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			LOGGER.log(Level.SEVERE, e.toString(), e);
		}
		return cn;
	}
	public static void close(Connection cn, ResultSet rs, Statement st, PreparedStatement ps) {
		try {
			if (cn != null) {
				cn.close();
			}
			if (rs != null) {
				rs.close();
			}
			if (st != null) {
				st.close();
			}
			if (ps != null) {
				ps.close();
			}
		} catch (SQLException e) {
			LOGGER.log(Level.SEVERE, e.toString(), e);
		}
	}
	
}
