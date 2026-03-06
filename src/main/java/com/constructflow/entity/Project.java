package com.constructflow.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Project {

    private String projectID; // Changed from int to String for UUID/GUID
    private String projectName;
    private Date endDate;
    private String location;
    private Date startDate;
    private String status;
    private List<Task> tasks;
    private Budget budget;

    public Project() {
        this.tasks = new ArrayList<>();
        this.status = "Draft";
        System.out.println("[Entity] Default Project created.");
    }

    public Project(Map<String, Object> details) {
        this();
        System.out.println("[Entity] Project created with details map.");
        if (details != null) {
            this.projectID = (String) details.getOrDefault("projectID", null);
            this.projectName = (String) details.getOrDefault("projectName", "Untitled Project");
            this.location = (String) details.getOrDefault("location", "N/A");
            this.startDate = (Date) details.getOrDefault("startDate", new Date());
            this.status = (String) details.getOrDefault("status", "Draft");
        }
    }

    public String getProjectID() {
        return projectID;
    }

    public void setProjectID(String projectID) {
        this.projectID = projectID;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectID='" + projectID + '\'' +
                ", projectName='" + projectName + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}