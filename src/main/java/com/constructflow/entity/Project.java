package com.constructflow.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Project {

    private int projectID;
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
        this(); // Call default constructor to initialize list
        System.out.println("[Entity] Project created with details map.");
        if (details != null) {
            this.projectID = (int) details.getOrDefault("projectID", 0);
            this.projectName = (String) details.getOrDefault("projectName", "Untitled Project");
            this.location = (String) details.getOrDefault("location", "N/A");
            this.startDate = (Date) details.getOrDefault("startDate", new Date());
            this.status = (String) details.getOrDefault("status", "Draft");
        }
    }

    public Task findTaskInProject(int taskID) {
        System.out.println("[Entity] Searching for Task ID " + taskID + " in project '" + this.projectName + "'...");
        for (Task task : tasks) {
            if (task.getTaskID() == taskID) {
                System.out.println("[Entity] Task found.");
                return task;
            }
        }
        System.out.println("[Entity] Task not found.");
        return null;
    }

    public void archive() {
        if (canBeArchived()) {
            this.status = "Archived";
            System.out.println("[Entity] Project '" + this.projectName + "' has been archived.");
        } else {
            System.out.println("[Entity] Project '" + this.projectName + "' cannot be archived. Not all tasks are completed.");
        }
    }

    public boolean canBeArchived() {
        for (Task task : tasks) {
            if (!Objects.equals(task.getStatus(), "Completed")) {
                return false;
            }
        }
        return true;
    }

    public void setBudget(Budget budget) {
        this.budget = budget;
        System.out.println("[Entity] Budget has been set for project '" + this.projectName + "'.");
    }

    public void addTask(Task task) {
        this.tasks.add(task);
        System.out.println("[Entity] Task '" + task.getTaskName() + "' added to project '" + this.projectName + "'.");
    }

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
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

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public Budget getBudget() {
        return budget;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectID=" + projectID +
                ", projectName='" + projectName + '\'' +
                ", status='" + status + '\'' +
                ", taskCount=" + tasks.size() +
                '}';
    }
}