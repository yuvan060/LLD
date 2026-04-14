package splitwise.entity;

import splitwise.enums.NotificationType;
import java.time.LocalDateTime;

public class Notification {
    private String notificationId;
    private User recipient;
    private String message;
    private NotificationType notificationType;
    private LocalDateTime createdAt;
    private boolean isRead;

    public Notification(String notificationId, User recipient, String message, NotificationType notificationType) {
        this.notificationId = notificationId;
        this.recipient = recipient;
        this.message = message;
        this.notificationType = notificationType;
        this.createdAt = LocalDateTime.now();
        this.isRead = false;
    }

    // Getters
    public String getNotificationId() {
        return notificationId;
    }

    public User getRecipient() {
        return recipient;
    }

    public String getMessage() {
        return message;
    }

    public NotificationType getNotificationType() {
        return notificationType;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public boolean isRead() {
        return isRead;
    }

    // Core Methods
    public void markAsRead() {
        this.isRead = true;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "notificationId='" + notificationId + '\'' +
                ", recipient=" + recipient.getName() +
                ", message='" + message + '\'' +
                ", type=" + notificationType +
                '}';
    }
}

