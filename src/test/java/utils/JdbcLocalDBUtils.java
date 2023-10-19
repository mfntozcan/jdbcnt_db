package utils;

import java.sql.*;


public class JdbcLocalDBUtils {
    static Connection connection;
    static Statement statement;
    public static Connection connectToDatabase(){
        try {
            connection = DriverManager.
                    getConnection("jdbc:postgresql://localhost:5432/jdbcnt_db","techpront","password");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    public static Statement createStatement(){
        try {
            statement = connectToDatabase().createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return statement;
    }


    public static ResultSet executeQuery(String sql){
        ResultSet resultSet = null;
        try {
            resultSet = createStatement().executeQuery(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultSet;
    }

    public static void closeConnection(){
        try {
            connection.close();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}