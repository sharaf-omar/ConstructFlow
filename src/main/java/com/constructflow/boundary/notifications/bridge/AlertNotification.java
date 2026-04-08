package com.constructflow.boundary.notifications.bridge;

/**
 * BRIDGE PATTERN - Refined Abstraction
 * Concrete notification type for system alerts (e.g., low stock).
 * Can use any NotificationDelivery implementation.
 */
public class AlertNotification extends AbstractNotification {
    private String alertType;
    private String severity;
    
    public AlertNotification(NotificationDelivery delivery, String recipient, 
                            String alertType, String severity) {
        super(delivery, recipient);
        this.alertType = alertType;
        this.severity = severity;
    }
    
    @Override
    public void send() {
        String subject = "[" + severity.toUpperCase() + "] " + alertType;
        String message = "Alert: " + alertType + " - Immediate attention required!";
        delivery.send(subject, message, recipient);
    }
    
    public void setAlertDetails(String alertType, String severity) {
        this.alertType = alertType;
        this.severity = severity;
    }
}
