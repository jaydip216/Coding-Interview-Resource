package com.recentInterviewQues.phonePe.customerIssuePortal;

import java.util.List;

public class Agent extends User{

    private List<Issue> issuesAssigned;
    private List<Issue> issuesResolved;
    private List<IssueType> issueTypes;
    private boolean isAvailable;

    public Agent(String email, String name, String mobileNo, List<IssueType> issueTypes) {
        super(email, name, mobileNo, UserRole.AGENT);
        this.issueTypes = issueTypes;
        this.isAvailable = true;
    }

    public void assignIssue(Issue issue){
        issuesAssigned.add(issue);
        isAvailable=false;
    }

    public void resolveIssue(Issue issue){
        issuesAssigned.remove(issue);
        issuesResolved.add(issue);
        isAvailable=true;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public List<IssueType> getIssueTypes() {
        return issueTypes;
    }

    public List<Issue> getIssuesResolved() {
        return issuesResolved;
    }

    public List<Issue> getIssuesAssigned() {
        return issuesAssigned;
    }

}
