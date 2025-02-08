package com.recentInterviewQues.phonePe.customerIssuePortal;

import java.util.List;

public class MostNumberOfIssueResolvedStrategy extends IssueAssignStrategy{
    @Override
    public void assignIssue(Issue issue) {
        List<Agent> agents = getDb().findAvailableAgentsByIssueType(issue.getIssueType());
        agents.sort((a, b) -> Integer.compare(b.getIssuesResolved().size(), a.getIssuesResolved().size()));
        agents.get(0).assignIssue(issue);
    }
}
