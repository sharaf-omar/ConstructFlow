package com.constructflow.boundary.notifications;

public class PushAlert implements LowStockAlert {
    public void send() { System.out.println("[Push] Sending Alert to Mobile App..."); }
}
