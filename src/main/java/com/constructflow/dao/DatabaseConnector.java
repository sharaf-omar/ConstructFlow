package com.constructflow.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.constructflow.config.ConfigLoader;

public class DatabaseConnector {

    private static DatabaseConnector instance;
    private Connection connection;

    private final String url = ConfigLoader.get("db.url");
    private final String user = ConfigLoader.get("db.user");
    private final String password = ConfigLoader.get("db.password");


    private DatabaseConnector() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("[Singleton] Attempting connection to MS SQL Server...");
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("[Singleton] Connection Successful!");
        } catch (SQLException e) {
            System.err.println("[Singleton] Connection Failed: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("[Singleton] JDBC Driver not found: " + e.getMessage());
        }
    }

    public static synchronized DatabaseConnector getInstance() {
        if (instance == null) {
            instance = new DatabaseConnector();
        }
        return instance;
    }

    public Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            } catch (ClassNotFoundException e) {
                throw new SQLException("JDBC Driver not found", e);
            }
            connection = DriverManager.getConnection(url, user, password);
        }
        return connection;
    }
}