package com.recentInterviewQues.phonePe.customerIssuePortal;

public abstract class IssueAssignStrategy {

    private InMemoryDatabase db;

    public IssueAssignStrategy(){
        db = InMemoryDatabase.getInstance();
    }

    public InMemoryDatabase getDb(){
        return db;
    }

    abstract public void assignIssue(Issue issue);
}
