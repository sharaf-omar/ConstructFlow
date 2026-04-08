package com.constructflow.boundary.notifications.bridge;

/**
 * BRIDGE PATTERN - Concrete Implementation
 * Implements push-based delivery mechanism (mobile/app notifications).
 */
public class PushDelivery implements NotificationDelivery {
    
    @Override
    public void send(String subject, String message, String recipient) {
        System.out.println("[PushDelivery] Sending push notification to user: " + recipient);
        System.out.println("  Title: " + subject);
        System.out.println("  Message: " + message);
        System.out.println("[PushDelivery] Push notification delivered to device!");
    }
    
    @Override
    public String getDeliveryType() {
        return "PUSH";
    }
}
