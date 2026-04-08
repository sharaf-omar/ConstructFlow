package com.constructflow.boundary.notifications.bridge;

/**
 * BRIDGE PATTERN - Concrete Implementation
 * Implements email-based delivery mechanism.
 */
public class EmailDelivery implements NotificationDelivery {
    
    @Override
    public void send(String subject, String message, String recipient) {
        System.out.println("[EmailDelivery] Sending email to: " + recipient);
        System.out.println("  Subject: " + subject);
        System.out.println("  Body: " + message);
        System.out.println("[EmailDelivery] Email delivered successfully!");
    }
    
    @Override
    public String getDeliveryType() {
        return "EMAIL";
    }
}
