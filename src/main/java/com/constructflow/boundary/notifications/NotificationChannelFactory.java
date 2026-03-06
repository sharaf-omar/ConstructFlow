package com.constructflow.boundary.notifications;

public interface NotificationChannelFactory {
    TaskReminder createTaskReminder();
    LowStockAlert createLowStockAlert();
}
