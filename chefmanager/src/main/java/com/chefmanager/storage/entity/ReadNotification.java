package com.chefmanager.storage.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ReadNotifications")
public class ReadNotification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Notification notification;

    ReadNotification(){}

}
