package com.constructflow.boundary.notifications.bridge;

/**
 * BRIDGE PATTERN - Refined Abstraction
 * Concrete notification type for task reminders.
 * Can use any NotificationDelivery implementation (Email, Push, SMS, etc.)
 */
public class TaskNotification extends AbstractNotification {
    private String taskName;
    private String taskDescription;
    
    public TaskNotification(NotificationDelivery delivery, String recipient, 
                           String taskName, String taskDescription) {
        super(delivery, recipient);
        this.taskName = taskName;
        this.taskDescription = taskDescription;
    }
    
    @Override
    public void send() {
        String subject = "Task Reminder: " + taskName;
        String message = "You have a task: " + taskDescription;
        delivery.send(subject, message, recipient);
    }
    
    public void setTaskDetails(String taskName, String taskDescription) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
    }
}
