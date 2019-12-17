package tdu_market.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectDBUtil {

	private final static boolean IS_CONNECT_DOCKER_DB = true;

	private final static String DB_NAME = "develop";
	private final static String USER = "teamYAMAGAMI";
	private final static String PASSWORD = "6bBZQvc4h5Fb82";
	private final static String SQL_HOST_NAME_LOCAL = "localhost";
	private final static String SQL_HOST_NAME_DOCKER = "pgs_7103";
	private final static String URL_LOCAL = "jdbc:postgresql://" + SQL_HOST_NAME_LOCAL + "/" + DB_NAME;
	private final static String URL_DOCKER = "jdbc:postgresql://" + SQL_HOST_NAME_DOCKER + "/" + DB_NAME;
	private final static String DRIVER_CLASS_NAME = "org.postgresql.Driver";

	public static Connection getConnection() throws SQLException, ClassNotFoundException {

		String url = IS_CONNECT_DOCKER_DB ? URL_DOCKER : URL_LOCAL;
		Class.forName(DRIVER_CLASS_NAME);
		return DriverManager.getConnection(url, USER, PASSWORD);
	}
}
