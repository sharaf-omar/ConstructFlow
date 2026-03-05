package com.constructflow.entity;

public class SiteEngineer extends Employee {

    private String fieldSpecialty;

    public SiteEngineer() {
        super();
        System.out.println("[Entity] Default SiteEngineer created.");
    }

    public SiteEngineer(int employeeID, String firstName, String lastName, String contactInfo, String fieldSpecialty) {
        super(employeeID, firstName, lastName, contactInfo);
        this.fieldSpecialty = fieldSpecialty;
        System.out.println("[Entity] SiteEngineer created: " + firstName + " " + lastName + " (Specialty: " + fieldSpecialty + ")");
    }

    public String getFieldSpecialty() {
        return fieldSpecialty;
    }

    public void setFieldSpecialty(String fieldSpecialty) {
        this.fieldSpecialty = fieldSpecialty;
    }

    @Override
    public String toString() {
        return "SiteEngineer{" +
                "employeeID=" + getEmployeeID() + ", " +
                "firstName='" + getFirstName() + "', " +
                "lastName='" + getLastName() + "', " +
                "fieldSpecialty='" + fieldSpecialty + '\'' +
                '}';
    }
}