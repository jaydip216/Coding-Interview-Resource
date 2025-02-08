package com.recentInterviewQues.phonePe.customerIssuePortal;

import java.util.List;

public class LeastNumberOfAssignedIssuesStrategy extends IssueAssignStrategy{

    @Override
    public void assignIssue(Issue issue) {
        List<Agent> agents = getDb().findAvailableAgentsByIssueType(issue.getIssueType());
        agents.sort((a, b) -> Integer.compare(a.getIssuesAssigned().size(), b.getIssuesAssigned().size()));
        agents.get(0).assignIssue(issue);
    }
}
