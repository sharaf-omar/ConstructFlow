package com.constructflow.dao.bridge;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.constructflow.config.ConfigLoader;

/**
 * BRIDGE PATTERN - Concrete Implementation
 * Microsoft SQL Server driver implementation.
 */
public class MSSQLDriver implements DatabaseDriver {
    
    private final String url = ConfigLoader.get("db.url");
    private final String user = ConfigLoader.get("db.user");
    private final String password = ConfigLoader.get("db.password");
    
    @Override
    public Connection connect() {
        try {
            System.out.println("[MSSQLDriver] Connecting to MS SQL Server...");
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("[MSSQLDriver] Connection successful!");
            return conn;
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("[MSSQLDriver] Connection failed: " + e.getMessage());
            return null;
        }
    }
    
    @Override
    public boolean testConnection(Connection conn) {
        try {
            return conn != null && !conn.isClosed();
        } catch (SQLException e) {
            System.err.println("[MSSQLDriver] Connection test failed: " + e.getMessage());
            return false;
        }
    }
    
    @Override
    public String getDriverType() {
        return "MS SQL Server";
    }
    
    @Override
    public void disconnect(Connection conn) {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("[MSSQLDriver] Connection closed.");
            }
        } catch (SQLException e) {
            System.err.println("[MSSQLDriver] Error closing connection: " + e.getMessage());
        }
    }
}
