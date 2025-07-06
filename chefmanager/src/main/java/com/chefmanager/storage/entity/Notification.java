package com.chefmanager.storage.entity;

import com.chefmanager.common.datatransfer.NotificationStyle;
import com.chefmanager.common.datatransfer.NotificationTargetUser;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Represents a unique notification in the system.
 * */

@Entity
@Table(name = "Notifications")
public class Notification extends BaseEntity{

    @Id
    private Integer id;

    @Column(nullable = false)
    private Instant startTime;

    @Column(nullable = false)

    private Instant endTime;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private NotificationStyle style;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private NotificationTargetUser targetUser;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String message;

    @Column(nullable = false)
    private boolean shown;

    @UpdateTimestamp
    private Instant updatedAt;

    @OneToMany(mappedBy = "notification", cascade = CascadeType.REMOVE)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<ReadNotification> readNotifications = new ArrayList<>();


    /**
     * Instantiates a new notification
     * */
    public Notification(Instant startTime, Instant endTime, NotificationStyle style,
                        NotificationTargetUser targetUser, String title, String message){
        this.setStartTime(startTime);
        this.setEndTime(endTime);
        this.setStyle(style);
        this.setTargetUser(targetUser);
        this.setTitle(title);
        this.setMessage(message);
    }

    protected Notification(){

    }

    public Integer getId() {
        return id;
    }

    public Instant getStartTime() {
        return startTime;
    }

    public void setStartTime(Instant startTime) {
        this.startTime = startTime;
    }

    public Instant getEndTime() {
        return endTime;
    }

    public void setEndTime(Instant endTime) {
        this.endTime = endTime;
    }

    public NotificationStyle getStyle() {
        return style;
    }

    public void setStyle(NotificationStyle style) {
        this.style = style;
    }

    public NotificationTargetUser getTargetUser() {
        return targetUser;
    }

    public void setTargetUser(NotificationTargetUser targetUser) {
        this.targetUser = targetUser;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isShown() {
        return shown;
    }

    public void setShown(boolean shown) {
        this.shown = shown;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public List<ReadNotification> getReadNotifications() {
        return readNotifications;
    }

    public void setReadNotifications(List<ReadNotification> readNotifications) {
        this.readNotifications = readNotifications;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "id=" + id +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", style=" + style +
                ", targetUser=" + targetUser +
                ", title='" + title + '\'' +
                ", message='" + message + '\'' +
                ", shown=" + shown +
                ", updatedAt=" + updatedAt +
                ", readNotifications=" + readNotifications +
                '}';
    }

    @Override
    public int hashCode() {
        return this.getId().hashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        } else if (this == other) {
            return true;
        } else if (this.getClass() == other.getClass()) {
            Notification otherNotification = (Notification) other;
            return Objects.equals(this.getId(), otherNotification.getId());
        } else {
            return false;
        }
    }

}
