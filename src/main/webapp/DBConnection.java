import java.sql.*;

public class DBConnection {
    public static Connection getConnection() {
        Connection connection = null;
        try {
            // Replace with your database credentials
            String url = "jdbc:mysql://localhost:3306/Library";
            String username = "root";
            String password = "@jayRadhekrishna123";

            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
