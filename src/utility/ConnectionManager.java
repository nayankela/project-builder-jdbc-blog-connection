package utility;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {

	public static Connection getConnection() throws IOException, ClassNotFoundException, SQLException {

		Properties properties = loadPropertiesFile();
		String driver = properties.getProperty("driver");
		String url = properties.getProperty("url");
		String userName = properties.getProperty("username");
		String password = properties.getProperty("password");

		Connection connection = null;
		Class.forName(driver);
		connection = DriverManager.getConnection(url, userName, password);

		return connection;

	}

	public static Properties loadPropertiesFile() throws IOException {
		Properties prop = new Properties();
		InputStream in = ConnectionManager.class.getClassLoader().getResourceAsStream("jdbc.properties");
		prop.load(in);
		in.close();
		return prop;
	}
}
