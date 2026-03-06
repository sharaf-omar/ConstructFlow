package com.constructflow.boundary.notifications;

public class PushReminder implements TaskReminder {
    public void send() { System.out.println("[Push] Sending Reminder to Mobile App..."); }
}