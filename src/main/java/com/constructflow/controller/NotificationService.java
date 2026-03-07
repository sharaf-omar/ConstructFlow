package com.constructflow.controller;

import com.constructflow.boundary.notifications.LowStockAlert;
import com.constructflow.boundary.notifications.NotificationChannelFactory;
import com.constructflow.boundary.notifications.TaskReminder;
import com.constructflow.entity.ProjectManager;
import com.constructflow.entity.Resource;
import com.constructflow.entity.Task;

public class NotificationService {


    private static NotificationService instance;


    private NotificationService() {
        System.out.println("[Singleton] NotificationService initialized. Central dispatcher ready.");
    }


    public static synchronized NotificationService getInstance() {
        if (instance == null) {
            instance = new NotificationService();
        }
        return instance;
    }

    /**
     * Sends a task reminder using the specified channel factory (Email or Push).
     * @param task The task to remind about.
     * @param factory The Abstract Factory determining the platform (Email/Push).
     */
    public void sendReminder(Task task, NotificationChannelFactory factory) {
        System.out.println("[NotificationService] Dispatching reminder for Task: " + task.getTaskName());

        // Use the Abstract Factory to create the correct product family
        TaskReminder reminder = factory.createTaskReminder();
        reminder.send(); // Polymorphic call (EmailReminder or PushReminder)
    }

    /**
     * Sends a low stock alert using the specified channel factory.
     * @param resource The resource running low.
     * @param recipient The manager to notify.
     * @param factory The Abstract Factory determining the platform.
     */
    public void sendLowStockAlert(Resource resource, ProjectManager recipient, NotificationChannelFactory factory) {
        System.out.println("[NotificationService] Dispatching Low Stock Alert for: " + resource.getName() +
                " to Manager: " + recipient.getFirstName());


        LowStockAlert alert = factory.createLowStockAlert();
        alert.send();
    }


}