package com.constructflow.boundary.notifications;

public class EmailAlert implements LowStockAlert {
    public void send() { System.out.println("[Email] Sending Low Stock Alert to Outlook..."); }
}