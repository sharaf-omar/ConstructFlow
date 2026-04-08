package com.constructflow.boundary.notifications.bridge;

/**
 * BRIDGE PATTERN - Implementation Abstraction
 * Defines the interface for delivery mechanisms.
 * This is the "Implementation" side of the Bridge pattern.
 * Allows decoupling of notification types from delivery channels.
 */
public interface NotificationDelivery {
    /**
     * Sends a notification message through the specific delivery mechanism.
     * @param subject The subject/title of the notification
     * @param message The content message
     * @param recipient The recipient identifier (email address, user ID, etc.)
     */
    void send(String subject, String message, String recipient);
    
    /**
     * Gets a description of this delivery mechanism.
     */
    String getDeliveryType();
}
