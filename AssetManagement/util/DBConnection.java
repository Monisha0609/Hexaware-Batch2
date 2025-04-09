package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection != null)
            return connection;

        try {
            // Use absolute path as you mentioned:
            FileInputStream fis = new FileInputStream("C:\\Users\\ELCOT\\Desktop\\Monisha\\java\\Java Task\\CaseStudy\\src\\db.properties");
            Properties prop = new Properties();
            prop.load(fis);

            String driver = prop.getProperty("db.driver");
            String url = prop.getProperty("db.url");
            String user = prop.getProperty("db.username");
            String password = prop.getProperty("db.password");

            // Load driver explicitly
            Class.forName(driver);
            System.out.println("Driver loaded.");

            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Database connected successfully.");
        } catch (IOException | SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        return connection;
    }
}
