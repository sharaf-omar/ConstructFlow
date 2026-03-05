package com.constructflow.entity;

import java.util.Date;

public class Task {

    private int taskID;
    private String taskName;
    private String status;
    private Date dueDate;
    private String description;
    private boolean isLocked;

    public Task() {
        System.out.println("[Entity] Default Task created.");
    }

    public Task(int taskID, String taskName, String description, Date dueDate) {
        this.taskID = taskID;
        this.taskName = taskName;
        this.description = description;
        this.dueDate = dueDate;
        this.status = "Pending";
        this.isLocked = false;
        System.out.println("[Entity] Task '" + taskName + "' created.");
    }

    public void cancel() {
        if (canBeCancelled()) {
            this.status = "Cancelled";
            System.out.println("[Entity] Task '" + taskName + "' has been cancelled.");
        } else {
            System.out.println("[Entity] Cannot cancel task '" + taskName + "' because it is locked or completed.");
        }
    }

    public boolean canBeCancelled() {
        return !isLocked && !"Completed".equals(status);
    }

    public void lock() {
        this.isLocked = true;
        System.out.println("[Entity] Task '" + taskName + "' is now locked.");
    }

    public void updateStatus(String newStatus) {
        if (!isLocked) {
            this.status = newStatus;
            System.out.println("[Entity] Task status updated to: " + newStatus);
        } else {
            System.out.println("[Entity] Cannot update status. Task is locked.");
        }
    }

    public int getTaskID() {
        return taskID;
    }

    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isLocked() {
        return isLocked;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskID=" + taskID +
                ", taskName='" + taskName + '\'' +
                ", status='" + status + '\'' +
                ", dueDate=" + dueDate +
                '}';
    }
}