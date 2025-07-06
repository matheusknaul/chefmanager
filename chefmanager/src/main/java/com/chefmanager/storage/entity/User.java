package com.chefmanager.storage.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.Objects;

/**
 * Represents a User
 * */

@Entity
@Table(name = "Users", uniqueConstraints = {
        @UniqueConstraint(name = "Unique email", columnNames = {"email"})
})
@Inheritance(strategy = InheritanceType.JOINED)
public class User  extends BaseEntity{

    @Id
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "accountId")
    private Account account;

    @ManyToOne
    @JoinColumn(name = "kitchenId")
    private Kitchen kitchen;

    @Column(nullable = false, insertable = false, updatable = false)
    private String kitchenId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    /**
     * Registration key
     * */

    @Column(nullable = false)
    private String regKey;

    @UpdateTimestamp
    private Instant updatedAt;

    protected User(){

    }

    protected User(Kitchen kitchen, String name, String email){
        this.setKitchen(kitchen);
        this.setName(name);
        this.setEmail(email);
        this.generateNewRegistrationKey();
    }

    public Integer getId() {
        return id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public String getKitchenId() {
        return kitchenId;
    }

    public Kitchen getKitchen(){
        return kitchen;
    }

    public void setKitchen(Kitchen kitchen){
        this.kitchen = kitchen;
        this.kitchenId = kitchen.getId();
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRegKey() {
        return regKey;
    }

    public void setRegKey(String regKey) {
        this.regKey = regKey;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void generateNewRegistrationKey(){
        this.setRegKey(generateNewRegistrationKey());
    }

    private String generateRegistrationKey(){

        /***
         * TODO: Create an class String Helper to
         * encrypt the registration key.
         */
        /

        String uniqueId = this.email + '%' + this.kitchen.getId();

        return uniqueId;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        } else if (this == other) {
            return true;
        } else if (this.getClass() == other.getClass()) {
            User otherUser = (User) other;
            return Objects.equals(this.getId(), otherUser.getId());
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return this.getId().hashCode();
    }

    public boolean isRegistered(){
        return this.account != null;
    }
}
