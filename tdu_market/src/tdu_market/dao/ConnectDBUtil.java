package tdu_market.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectDBUtil {

	private final static boolean IS_CONNECT_DOCKER_DB = false;

	private final static String DB_NAME = "tutorial";
	private final static String USER = "postgres";
	private final static String PASSWORD = "password";
	private final static String SQL_HOST_NAME_LOCAL = "localhost";
	private final static String SQL_HOST_NAME_DOCKER = "localhost";
	private final static String URL_LOCAL = "jdbc:postgresql://" + SQL_HOST_NAME_LOCAL + "/" + DB_NAME;
	private final static String URL_DOCKER = "jdbc:postgresql://" + SQL_HOST_NAME_DOCKER + "/" + DB_NAME;
	private final static String DRIVER_CLASS_NAME = "org.postgresql.Driver";

	public static Connection getConnection() throws SQLException, ClassNotFoundException {

		String url = IS_CONNECT_DOCKER_DB ? URL_DOCKER : URL_LOCAL;
		Class.forName(DRIVER_CLASS_NAME);
		return DriverManager.getConnection(url, USER, PASSWORD);
	}
}
