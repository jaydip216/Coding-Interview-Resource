package com.recentInterviewQues.phonePe.customerIssuePortal;

import java.util.ArrayList;
import java.util.List;

public class CustomerIssueResolutionApp {

    private static CustomerIssueResolutionApp instance;
    private InMemoryDatabase db;

    private CustomerIssueResolutionApp(){
        db = InMemoryDatabase.getInstance();
    }

    public CustomerIssueResolutionApp getInstance(){
        if(instance==null){
            instance= new CustomerIssueResolutionApp();
        }
        return instance;
    }

    public void addCustomer(String emailId, String name, String mobileNo){
        if(!db.isCustomerExists(emailId)){
            Customer customer = new Customer(emailId, name, mobileNo);
            db.addCustomer(customer);
        }
    }

    public void createIssue(int transactionId, IssueType issueType,
                            String subject, String description, String emailId){
        if(!db.isCustomerExists(emailId)){
            System.out.println("Customer with email: "+emailId+" does not exists in the system.");
        }

        Issue issue = new Issue(issueType,transactionId,subject,description, db.getCustomer(emailId));
        Customer customer = db.getCustomer(emailId);
        customer.addIssueRaised(issue);
        db.addIssue(issue);
    }

    public List<Issue> getIssues(String agentEmailId, String searchEmailId, Integer searchIssueId){
        List<Issue> issues = new ArrayList<>();
        if(db.isAgentExists(agentEmailId)){
            if(searchEmailId!=null){
                Customer customer = db.getCustomer(searchEmailId);
                issues.addAll(customer.getIssuesRaised());
                issues.addAll(customer.getIssuesResolved());
            } else if (searchIssueId != null) {
                Issue issue = db.getIssue(searchIssueId);
                issues.add(issue);
            }
        }
        return issues;
    }

    public void resolveIssue(String agentEmail, int issueId, String resolution){

    }

    public void assignIssue(int issueId){
        Issue issue= db.getIssue(issueId);
        IssueAssignService issueAssignService = new IssueAssignService(new MostNumberOfIssueResolvedStrategy());
        issueAssignService.assignIssue(issue);
    }

    public void  updateIssue(int issueId, IssueStatus status, String resolution){

    }

    public void addAgent(String agentEmail, String agentName, String agentMobileNo, List<IssueType> issueTypes){
        if(!db.isAgentExists(agentEmail)){
            Agent agent = new Agent(agentEmail, agentName, agentMobileNo,issueTypes);
            db.addAgent(agent);
        }
    }

    public void viewAgentsWorkHistory(){

    }
}
