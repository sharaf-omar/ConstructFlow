package com.constructflow.entity.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * FLYWEIGHT PATTERN - Object Pool
 * Factory for creating and caching Employee objects.
 * Ensures that each unique employee is represented by only one instance,
 * reducing memory consumption and improving performance.
 */
public class EmployeeFlyweightFactory {
    private static EmployeeFlyweightFactory instance;
    private Map<Integer, FlyweightEmployee> employeePool = new HashMap<>();
    
    public static synchronized EmployeeFlyweightFactory getInstance() {
        if (instance == null) {
            instance = new EmployeeFlyweightFactory();
        }
        return instance;
    }
    
    /**
     * Gets or creates an employee from the pool.
     * If the employee already exists, returns the cached instance.
     * If not, creates it and caches it for future use.
     */
    public FlyweightEmployee getEmployee(int employeeID, String name, String role) {
        if (!employeePool.containsKey(employeeID)) {
            System.out.println("[EmployeeFlyweightFactory] Creating new employee instance: " + name);
            FlyweightEmployee employee = new FlyweightEmployee(employeeID, name, role);
            employeePool.put(employeeID, employee);
        } else {
            System.out.println("[EmployeeFlyweightFactory] Reusing cached employee: " + name);
        }
        return employeePool.get(employeeID);
    }
    
    /**
     * Gets the total number of unique employee instances in the pool.
     */
    public int getPoolSize() {
        return employeePool.size();
    }
    
    /**
     * Gets pool statistics.
     */
    public void printPoolStats() {
        System.out.println("[EmployeeFlyweightFactory] Current pool size: " + employeePool.size() + " unique employees");
    }

}

