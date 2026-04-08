package com.constructflow.dao.bridge;

import java.sql.Connection;

/**
 * BRIDGE PATTERN - Abstraction
 * Abstract database connector that delegates to a DatabaseDriver implementation.
 * This is the "Abstraction" side of the Bridge pattern.
 */
public abstract class AbstractDatabase {
    protected DatabaseDriver driver;
    protected Connection connection;
    
    public AbstractDatabase(DatabaseDriver driver) {
        this.driver = driver;
        this.connection = null;
    }
    
    /**
     * Establishes connection using the configured driver.
     */
    public boolean connect() {
        this.connection = driver.connect();
        return driver.testConnection(connection);
    }
    
    /**
     * Template method for database operations.
     */
    public abstract void performQuery();
    
    /**
     * Switches database driver at runtime (key Bridge benefit).
     */
    public void switchDriver(DatabaseDriver newDriver) {
        if (connection != null) {
            driver.disconnect(connection);
        }
        this.driver = newDriver;
        System.out.println("[AbstractDatabase] Switched to driver: " + driver.getDriverType());
    }
    
    /**
     * Closes the connection.
     */
    public void disconnect() {
        if (connection != null) {
            driver.disconnect(connection);
        }
    }
    
    /**
     * Gets the current driver type.
     */
    public String getDriverType() {
        return driver.getDriverType();
    }
    
    /**
     * Gets the current connection.
     */
    public Connection getConnection() {
        return connection;
    }
}
