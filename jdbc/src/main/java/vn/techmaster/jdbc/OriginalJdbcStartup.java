package vn.techmaster.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class OriginalJdbcStartup {

    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/mastering_spring_boot",
            "root",
            "12345678"
        );

        String deleteSQL = "DELETE FROM users WHERE username = 'tvd12'";
        try (PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL)) {
            preparedStatement.executeUpdate();
        }

        String insertSQL = "INSERT INTO users (username, email, password, display_name, status, created_at, updated_at) " +
            "VALUES (?, ?, ?, ?, ?, NOW(), NOW())";

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {
            preparedStatement.setString(1, "tvd12");
            preparedStatement.setString(2, "ta.van.dung@techmaster.vn");
            preparedStatement.setString(3, "12345678");
            preparedStatement.setString(4, "Dzung");
            preparedStatement.setString(5, "ACTIVATED");

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new user was inserted successfully!");
            }
        }
        String fetchSQL = "SELECT * FROM users";

        try (PreparedStatement preparedStatement = connection.prepareStatement(fetchSQL);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String username = resultSet.getString("username");
                String email = resultSet.getString("email");
                String displayName = resultSet.getString("display_name");
                String status = resultSet.getString("status");
                System.out.printf("ID: %d, Username: %s, Email: %s, Display Name: %s, Status: %s%n",
                    id, username, email, displayName, status);
            }
        }
        connection.close();
    }
}
