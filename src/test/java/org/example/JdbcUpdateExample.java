package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcUpdateExample {

    public static void main(String[] args) {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection
            String url = "jdbc:mysql://localhost:3306/employee";
            String user = "root";
            String password = "root";
            Connection connection = DriverManager.getConnection(url, user, password);

            // Prepare an UPDATE statement
            String updateSql = "UPDATE department SET dept_name = ? WHERE dept_no = ?";
            try (PreparedStatement updateStatement = connection.prepareStatement(updateSql)) {
                // Set values for the placeholders
                updateStatement.setString(1, "SOFTWARE");
                updateStatement.setInt(2, 101);

                // Execute the UPDATE statement
                int rowsAffected = updateStatement.executeUpdate();

                System.out.println(rowsAffected + " row(s) updated successfully.");
            }

            // Close resources
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
