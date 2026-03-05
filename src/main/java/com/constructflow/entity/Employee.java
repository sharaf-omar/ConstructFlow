package com.constructflow.entity;

public abstract class Employee {

    private int employeeID;
    private String firstName;
    private String lastName;
    private String contactInfo;

    public Employee() {
        System.out.println("[Entity] Default Abstract Employee created.");
    }

    public Employee(int employeeID, String firstName, String lastName, String contactInfo) {
        this.employeeID = employeeID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactInfo = contactInfo;
        System.out.println("[Entity] Employee created: " + firstName + " " + lastName);
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeID=" + employeeID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", contactInfo='" + contactInfo + '\'' +
                '}';
    }
}