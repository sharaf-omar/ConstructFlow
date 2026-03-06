package com.constructflow.boundary.notifications;

public class EmailReminder implements TaskReminder {
    public void send() { System.out.println("[Email] Sending Task Reminder to Outlook..."); }
}
