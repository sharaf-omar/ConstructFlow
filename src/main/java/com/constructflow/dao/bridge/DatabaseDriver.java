package com.constructflow.dao.bridge;

import java.sql.Connection;

/**
 * BRIDGE PATTERN - Implementation Abstraction
 * Defines the interface for database driver implementations.
 * This allows swapping database vendors without changing business logic.
 */
public interface DatabaseDriver {
    /**
     * Establishes a connection to the database.
     */
    Connection connect();
    
    /**
     * Tests the database connection.
     */
    boolean testConnection(Connection conn);
    
    /**
     * Gets the driver type name.
     */
    String getDriverType();
    
    /**
     * Closes the connection properly.
     */
    void disconnect(Connection conn);
}
