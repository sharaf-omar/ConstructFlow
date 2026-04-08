package com.constructflow.dao.bridge;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * BRIDGE PATTERN - Concrete Implementation
 * PostgreSQL driver implementation.
 * Can be swapped in at runtime without changing other code.
 */
public class PostgreSQLDriver implements DatabaseDriver {
    
    private final String url;
    private final String user;
    private final String password;
    
    public PostgreSQLDriver(String host, int port, String database, String user, String password) {
        this.url = "jdbc:postgresql://" + host + ":" + port + "/" + database;
        this.user = user;
        this.password = password;
    }
    
    @Override
    public Connection connect() {
        try {
            System.out.println("[PostgreSQLDriver] Connecting to PostgreSQL...");
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("[PostgreSQLDriver] Connection successful!");
            return conn;
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("[PostgreSQLDriver] Connection failed: " + e.getMessage());
            return null;
        }
    }
    
    @Override
    public boolean testConnection(Connection conn) {
        try {
            return conn != null && !conn.isClosed();
        } catch (SQLException e) {
            System.err.println("[PostgreSQLDriver] Connection test failed: " + e.getMessage());
            return false;
        }
    }
    
    @Override
    public String getDriverType() {
        return "PostgreSQL";
    }
    
    @Override
    public void disconnect(Connection conn) {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("[PostgreSQLDriver] Connection closed.");
            }
        } catch (SQLException e) {
            System.err.println("[PostgreSQLDriver] Error closing connection: " + e.getMessage());
        }
    }
}
