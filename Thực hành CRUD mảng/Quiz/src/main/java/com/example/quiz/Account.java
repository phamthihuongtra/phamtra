package com.example.quiz;

import java.sql.Date;
import java.sql.Timestamp;

public class Account {
    private int id;
    private String email;
    private String displayName;
    private String createdAt;
    private String lastAccess;
    private String status;

    public Account(int id,String email, String displayName, Date createdAt, Timestamp lastAccess , String status) {
        this.email = email;
        this.displayName = displayName;
        this.createdAt = String.valueOf(createdAt);
        this.lastAccess = String.valueOf(lastAccess);
        this.status = status;
        this.id = id;
    }

    public Account() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getLastAccess() {
        return lastAccess;
    }

    public void setLastAccess(String lastAccess) {
        this.lastAccess = lastAccess;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
