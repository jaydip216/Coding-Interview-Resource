package com.recentInterviewQues.phonePe.customerIssuePortal;

import java.util.List;

public class Customer extends User{

    private List<Issue> issuesRaised;
    private List<Issue> issuesResolved;

    public Customer(String email, String name, String mobileNo) {
        super(email, name, mobileNo, UserRole.CUSTOMER);
    }

    public List<Issue> getIssuesRaised() {
        return issuesRaised;
    }

    public List<Issue> getIssuesResolved() {
        return issuesResolved;
    }

    public void addIssueRaised(Issue issue){
        issuesRaised.add(issue);
    }
}
