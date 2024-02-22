package com.example.chattyio.improper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonDataDriverManager {
    static SingletonDataDriverManager instance;
    Connection connection;

    private SingletonDataDriverManager() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://14.225.255.46:3306/antipattern", "chungnv", "Chung@123");
    }
    public static synchronized SingletonDataDriverManager getInstance() throws SQLException {
        if (instance == null) {
            instance = new SingletonDataDriverManager();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
