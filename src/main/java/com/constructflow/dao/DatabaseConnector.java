package com.constructflow.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    // !! IMPORTANT !!
    // Replace with your actual server name, username, and password if not using Windows Auth.
    private static final String DATABASE_URL = "jdbc:sqlserver://localhost;databaseName=ConstructFlowDB;integratedSecurity=true;trustServerCertificate=true;";
    
    public static Connection getConnection() throws SQLException {
        try {
            // Ensure the SQL Server JDBC driver is loaded
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection(DATABASE_URL);
        } catch (ClassNotFoundException e) {
            throw new SQLException("SQL Server JDBC Driver not found.", e);
        }
    }
}