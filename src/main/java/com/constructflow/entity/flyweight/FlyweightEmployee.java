package com.constructflow.entity.flyweight;

/**
 * FLYWEIGHT PATTERN - Flyweight Employee
 * Immutable flyweight employee object.
 * Represents a shared employee instance to reduce memory usage.
 */
public class FlyweightEmployee {
    private final int employeeID;
    private final String name;
    private final String role;
 
    public FlyweightEmployee(int employeeID, String name, String role) {
        this.employeeID = employeeID;
        this.name = name;
        this.role = role;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return name + " (" + role + ")";
    }
    public void assignToTask(String taskId, String site, int hours) {
        System.out.println(name + " assigned to " + taskId + " at " + site + " for " + hours + " hours");
    }
}