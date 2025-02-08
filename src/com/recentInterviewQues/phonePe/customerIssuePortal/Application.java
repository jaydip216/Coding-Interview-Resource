package com.recentInterviewQues.phonePe.customerIssuePortal;

/*
The solution should incorporate the following features:
Customers can log a complaint against any unsuccessful transaction.
Customer Service Agents can search for customer issues with issue ID or customer details (email).
Agents can view their assigned issues and mark them resolved once they are resolved.
System should assign the issue to agents based on an assigning strategy.
System should allow the admin to onboard new agents.
System should allow the admin to view the agent's work history.
Implementation requirements
Your solution should implement the following functions.
Feel free to use the representation for objects you deem fit for the problem and
the provided use cases.
The functions are ordered in the decreasing order of importance (highest to lowest).
We understand that you may not be able to complete the implementation for all the functions
listed here.
So try to implement them in the order in which they are declared down below.



createIssue(transactionId, issueType, subject, description, email)
addAgent(agentEmail, agentName ,List<issueType>)
assignIssue(issueId) // -> Issue can be assigned to the agents based on different strategies. For now, assign to any one of the free agents.
getIssues(filter) // -> issues against the provided filter
updateIssue(issueId, status, resolution)
resolveIssue(issueId, resolution)
viewAgentsWorkHistory() // -> a list of issue which agents worked on
 */
public class Application {
}
