package com.example.chattyio.improper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataDriverManager {
    Connection connection;

    public DataDriverManager() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://14.225.255.46:3306/antipattern", "chungnv", "Chung@123");
    }

    public Connection getConnection() {
        return connection;
    }
}
