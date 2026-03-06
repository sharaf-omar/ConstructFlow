package com.constructflow.boundary.notifications;

public class EmailChannelFactory implements NotificationChannelFactory {
    public TaskReminder createTaskReminder() { return new EmailReminder(); }
    public LowStockAlert createLowStockAlert() { return new EmailAlert(); }
}