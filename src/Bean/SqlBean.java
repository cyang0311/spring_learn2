package Bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SqlBean {
    public Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            String DRIVER_URL = "jdbc:mysql://localhost:3306/spring_mvctest";
            String USERNAME = "root";
            String PASSWORD = "123456";
            Connection conn = DriverManager.getConnection(DRIVER_URL,USERNAME,PASSWORD);

            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
