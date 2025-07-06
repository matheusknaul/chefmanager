package com.chefmanager.storage.entity;

import com.chefmanager.common.datatransfer.NotificationStyle;
import jakarta.persistence.*;

import java.time.Instant;

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
}
