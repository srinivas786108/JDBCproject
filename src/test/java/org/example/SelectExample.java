package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectExample {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/classicmodels";
        String user = "root";
        String password = "root";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String sql = "SELECT * FROM customers";
            try (PreparedStatement statement = connection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {

                // Process the result set
                while (resultSet.next()) {
                    int customerId = resultSet.getInt("customerNumber");
                    String customerName = resultSet.getString("customerName");
                    String lastName = resultSet.getString("contactLastName");
                    String firstName = resultSet.getString("contactFirstName");
                    String phone = resultSet.getString("phone");

                    System.out.println("ID: " + customerId + ", Name: " + customerName + ", lastName: " + lastName +
                            ", firstName: " + firstName + ", phone:" + phone);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

