package com.user.model;

import java.time.LocalDateTime;

public class SystemLogs {
    private int logId;            // Unique identifier for the log entry
    private int userId;           // ID of the user who performed the action
    private String action;        // Description of the action performed
    private LocalDateTime timestamp; // Timestamp when the action was performed
    private String details;       // Additional details about the action

    // Constructor with all fields
    public SystemLogs(int logId, int userId, String action, LocalDateTime timestamp, String details) {
        this.logId = logId;
        this.userId = userId;
        this.action = action;
        this.timestamp = timestamp;
        this.details = details;
    }

    // Default constructor
    public SystemLogs() {}

    // Getters and Setters
    public int getLogId() {
        return logId;
    }

    public void setLogId(int logId) {
        this.logId = logId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    // Print log details
    @Override
    public String toString() {
        return "SystemLog{" +
                "logId=" + logId +
                ", userId=" + userId +
                ", action='" + action + '\'' +
                ", timestamp=" + timestamp +
                ", details='" + details + '\'' +
                '}';
    }
}
