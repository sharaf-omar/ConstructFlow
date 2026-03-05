package com.constructflow.entity;

import java.util.Date;

public class Equipment extends Resource {

    private Date maintenanceSchedule;

    public Equipment() {
        super();
        System.out.println("[Entity] Default Equipment created.");
    }

    public Equipment(int resourceID, String name, Date maintenanceSchedule) {
        super(resourceID, name);
        this.maintenanceSchedule = maintenanceSchedule;
        System.out.println("[Entity] Equipment created: " + name);
    }

    @Override
    public void displayInfo() {
        System.out.println("[Factory Method] Equipment (Reusable) created: " + getName());
    }

    public Date getMaintenanceSchedule() {
        return maintenanceSchedule;
    }

    public void setMaintenanceSchedule(Date maintenanceSchedule) {
        this.maintenanceSchedule = maintenanceSchedule;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "resourceID=" + getResourceID() + ", " +
                "name='" + getName() + "', " +
                "maintenanceSchedule=" + maintenanceSchedule +
                '}';
    }
}