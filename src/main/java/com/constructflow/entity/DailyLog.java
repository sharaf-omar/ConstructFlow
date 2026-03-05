package com.constructflow.entity; // Ensure this matches your package structure

import java.util.Date;
import java.util.Map;

public class DailyLog {


    private int logID; // Primary Key
    private Date date;
    private double hoursWorked;
    private String progressNotes;


    private Task task;

    /**
     * Default constructor
     */
    public DailyLog() {
        System.out.println("[Entity] Default DailyLog created.");
    }

    /**
     * Parameterized constructor using a Map
     * @param details Map containing initialization data
     */
    public DailyLog(Map<String, Object> details) {
        System.out.println("[Entity] DailyLog created using details map.");

        // Minimal dumb implementation to parse the map safely
        if (details != null) {
            if (details.containsKey("logID")) {
                this.logID = (Integer) details.get("logID");
            }
            if (details.containsKey("hoursWorked")) {
                this.hoursWorked = (Double) details.get("hoursWorked");
            }
            if (details.containsKey("progressNotes")) {
                this.progressNotes = (String) details.get("progressNotes");
            }
            if (details.containsKey("date")) {
                this.date = (Date) details.get("date");
            }
        }
    }

    /**
     * Associates this daily log with a specific task.
     * @param task The task to associate
     */
    public void associateWithTask(Task task) {
        this.task = task;
        System.out.println("[Entity] DailyLog " + logID + " successfully associated with a Task.");
    }

    /**
     * Retrieves the resources used during this daily log.
     * @return Resource (or null for this basic implementation)
     */
    public Resource getUsedResources() {
        System.out.println("[Entity] Fetching used resources for DailyLog " + logID + "...");
        // Returning null for now as part of the "dumb" implementation
        return null;
    }

    // --- GETTERS AND SETTERS ---

    public int getLogID() {
        return logID;
    }

    public void setLogID(int logID) {
        this.logID = logID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public String getProgressNotes() {
        return progressNotes;
    }

    public void setProgressNotes(String progressNotes) {
        this.progressNotes = progressNotes;
    }

    public Task getTask() {
        return task;
    }

    @Override
    public String toString() {
        return "DailyLog{" +
                "logID=" + logID +
                ", date=" + date +
                ", hoursWorked=" + hoursWorked +
                ", progressNotes='" + progressNotes + '\'' +
                '}';
    }
}