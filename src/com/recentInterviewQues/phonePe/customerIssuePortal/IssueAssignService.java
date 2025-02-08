package com.recentInterviewQues.phonePe.customerIssuePortal;

public class IssueAssignService {

    public IssueAssignStrategy issueAssignStrategy;

    public IssueAssignService(IssueAssignStrategy issueAssignStrategy){
        this.issueAssignStrategy = issueAssignStrategy;
    }

    public void assignIssue(Issue issue){
        issueAssignStrategy.assignIssue(issue);
    }

}
