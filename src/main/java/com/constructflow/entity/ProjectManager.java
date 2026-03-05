package com.constructflow.entity;

public class ProjectManager extends Employee {

    private String certificationLevel;

    public ProjectManager() {
        super();
        System.out.println("[Entity] Default ProjectManager created.");
    }

    public ProjectManager(int employeeID, String firstName, String lastName, String contactInfo, String certificationLevel) {
        super(employeeID, firstName, lastName, contactInfo);
        this.certificationLevel = certificationLevel;
        System.out.println("[Entity] ProjectManager created: " + firstName + " " + lastName);
    }

    public String getCertificationLevel() {
        return certificationLevel;
    }

    public void setCertificationLevel(String certificationLevel) {
        this.certificationLevel = certificationLevel;
    }

    @Override
    public String toString() {
        return "ProjectManager{" +
                "employeeID=" + getEmployeeID() + ", " +
                "firstName='" + getFirstName() + "', " +
                "lastName='" + getLastName() + "', " +
                "certificationLevel='" + certificationLevel + '\'' +
                '}';
    }
}