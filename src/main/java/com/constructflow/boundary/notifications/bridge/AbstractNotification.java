package com.constructflow.boundary.notifications.bridge;

/**
 * BRIDGE PATTERN - Abstraction
 * Abstract base class for different notification types.
 * Contains a reference to NotificationDelivery implementation.
 * This is the "Abstraction" side of the Bridge pattern.
 */
public abstract class AbstractNotification {
    protected NotificationDelivery delivery;
    protected String recipient;
    
    public AbstractNotification(NotificationDelivery delivery, String recipient) {
        this.delivery = delivery;
        this.recipient = recipient;
    }
    
    /**
     * Template method - subclasses define subject and message,
     * while delivery mechanism is abstracted away.
     */
    public abstract void send();
    
    /**
     * Change delivery mechanism at runtime (key Bridge benefit).
     */
    public void setDelivery(NotificationDelivery delivery) {
        this.delivery = delivery;
    }
    
    public String getDeliveryType() {
        return delivery.getDeliveryType();
    }
}
