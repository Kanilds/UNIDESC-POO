package factory;

import java.sql.*;

public class DatabaseConnection {

    private static Connection connection = null;
    private static DatabaseConnection databaseConnection;
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/crud?createDatabaseIfNotExist=true&useSSl=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "root";


    private DatabaseConnection() {
        getConnection();
    }

    public static DatabaseConnection getInstance() {
        if (databaseConnection == null) {
            databaseConnection = new DatabaseConnection();
        }
        return databaseConnection;
    }

    public static Connection getConnection() {
        try {
            if (connection == null) {
                Class.forName(DRIVER);
                connection = DriverManager.getConnection(URL, USER, PASS);
            }
        } catch (ClassNotFoundException | SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public PreparedStatement preparedStatement(String sql, int returnGenerateKeys) throws SQLException{
        return connection.prepareStatement(sql, returnGenerateKeys);
    }
}
