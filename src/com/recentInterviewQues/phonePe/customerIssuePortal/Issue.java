package com.recentInterviewQues.phonePe.customerIssuePortal;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

public class Issue {
    private int issueId;
    private IssueType issueType;
    private int transactionId;
    private String subject;
    private String description;
    private User assignee;
    private User reportee;
    private boolean isResolved;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String resolution;
    private IssueStatus status;

    private static final AtomicInteger issueIdCounter = new AtomicInteger(0);


    public Issue(IssueType issueType, int transactionId, String subject, String description, User reportee) {
        this.issueType = issueType;
        this.transactionId = transactionId;
        this.subject = subject;
        this.description = description;
        this.reportee = reportee;
        this.issueId = issueIdCounter.incrementAndGet();
        this.isResolved = false;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.resolution = null;
        this.status = IssueStatus.PENDING;
        this.assignee = null;
    }

    public int getIssueId() {
        return issueId;
    }

    public IssueType getIssueType() {
        return issueType;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public String getSubject() {
        return subject;
    }

    public String getDescription() {
        return description;
    }

    public User getAssignee() {
        return assignee;
    }

    public User getReportee() {
        return reportee;
    }

    public boolean isResolved() {
        return isResolved;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public String getResolution() {
        return resolution;
    }

    public IssueStatus getStatus() {
        return status;
    }
}
