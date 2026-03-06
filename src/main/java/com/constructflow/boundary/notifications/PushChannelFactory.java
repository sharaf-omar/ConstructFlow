package com.constructflow.boundary.notifications;

public class PushChannelFactory implements NotificationChannelFactory {
    public TaskReminder createTaskReminder() { return new PushReminder(); }
    public LowStockAlert createLowStockAlert() { return new PushAlert(); }
}