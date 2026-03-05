package com.constructflow.controller;

import com.constructflow.entity.Task;
import com.constructflow.entity.Resource;
import com.constructflow.entity.ProjectManager;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class NotificationService {

    public NotificationService() {
        System.out.println("[Controller] Default NotificationService created.");
    }

    public void sendReminder(Task task) {
        System.out.println("[Controller] sendReminder called with task: " + task);
    }

    public void sendLowStockAlert(Resource resource, ProjectManager recipient) {
        System.out.println("[Controller] sendLowStockAlert called with resource: " + resource + ", recipient: " + recipient);
    }
}