package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcDeleteExample {

    public static void main(String[] args) {
        // Establish a connection
        String url = "jdbc:mysql://localhost:3306/employee";
        String user = "root";
        String password = "root";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            // Specify the SQL DELETE query
            String sql = "DELETE FROM department WHERE dept_no = ?";

            // Create a PreparedStatement with the SQL query
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                // Set the parameter values for the WHERE clause
                preparedStatement.setInt(1, 101);

                // Execute the DELETE statement
                int rowsAffected = preparedStatement.executeUpdate();

                // Check the number of rows affected
                if (rowsAffected > 0) {
                    System.out.println(rowsAffected + " row(s) deleted successfully.");
                } else {
                    System.out.println("No rows deleted. The specified condition might not match any records.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
