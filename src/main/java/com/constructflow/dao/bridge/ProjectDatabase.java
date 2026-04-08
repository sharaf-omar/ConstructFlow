package com.constructflow.dao.bridge;

import java.sql.ResultSet;
import java.sql.Statement;

/**
 * BRIDGE PATTERN - Refined Abstraction
 * Concrete implementation for querying project data.
 * Can work with any DatabaseDriver (MSSQL, PostgreSQL, etc.)
 */
public class ProjectDatabase extends AbstractDatabase {
    
    public ProjectDatabase(DatabaseDriver driver) {
        super(driver);
    }
    
    @Override
    public void performQuery() {
        if (connection == null) {
            System.out.println("[ProjectDatabase] No connection established!");
            return;
        }
        
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT TOP 5 * FROM Projects");
            
            System.out.println("[ProjectDatabase] Connected via: " + driver.getDriverType());
            System.out.println("[ProjectDatabase] Retrieved projects:");
            
            int count = 0;
            while (rs.next() && count < 5) {
                System.out.println("  - Project ID: " + rs.getString("projectID") + 
                                 ", Name: " + rs.getString("projectName"));
                count++;
            }
            
            if (count == 0) {
                System.out.println("[ProjectDatabase] No projects found.");
            }
            
            rs.close();
            stmt.close();
        } catch (Exception e) {
            System.err.println("[ProjectDatabase] Query failed: " + e.getMessage());
        }
    }
    
    /**
     * Gets project count from database.
     */
    public int getProjectCount() {
        if (connection == null) {
            return 0;
        }
        
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) as count FROM Projects");
            
            if (rs.next()) {
                int count = rs.getInt("count");
                rs.close();
                stmt.close();
                return count;
            }
        } catch (Exception e) {
            System.err.println("[ProjectDatabase] Count query failed: " + e.getMessage());
        }
        
        return 0;
    }
}
