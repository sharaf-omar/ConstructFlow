package com.constructflow.entity;

public class Manager extends Employee {

    private String managementLevel;

    public Manager() {
        super();
        System.out.println("[Entity] Default Manager created.");
    }

    public Manager(int employeeID, String firstName, String lastName, String contactInfo, String managementLevel) {
        super(employeeID, firstName, lastName, contactInfo);
        this.managementLevel = managementLevel;
        System.out.println("[Entity] Manager created: " + firstName + " " + lastName);
    }

    public String getManagementLevel() {
        return managementLevel;
    }

    public void setManagementLevel(String managementLevel) {
        this.managementLevel = managementLevel;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "employeeID=" + getEmployeeID() + ", " +
                "firstName='" + getFirstName() + "', " +
                "lastName='" + getLastName() + "', " +
                "managementLevel='" + managementLevel + '\'' +
                '}';
    }
}