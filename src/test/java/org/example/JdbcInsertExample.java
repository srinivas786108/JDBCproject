package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcInsertExample {

    public static void main(String[] args) {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection

            String url = "jdbc:mysql://localhost:3306/employee";
            String user = "root";
            String password = "root";

            Connection connection = DriverManager.getConnection(url, user, password);

            // Prepare an INSERT statement
            String insertSql = "INSERT INTO employee.department (dept_no, dept_name) VALUES (108, 'HR5')";
            try (PreparedStatement insertStatement = connection.prepareStatement(insertSql)) {

//                // Set values for the placeholders
//                insertStatement.setString(1, "new_value1");
//                insertStatement.setString(2, "some_value");


                // Execute the INSERT statement
                int rowsAffected = insertStatement.executeUpdate(insertSql);

                System.out.println(rowsAffected + " row(s) inserted successfully.");
            }

            // Close resources
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
