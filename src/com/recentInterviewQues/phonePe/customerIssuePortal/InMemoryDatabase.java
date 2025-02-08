package com.recentInterviewQues.phonePe.customerIssuePortal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryDatabase {

    private static InMemoryDatabase instance = null;
    private Map<String, Agent> agents;
    private Map<String, Customer> customers;
    private Map<Integer, Issue> issues;

    private InMemoryDatabase(){
        customers = new ConcurrentHashMap<>();
        agents = new ConcurrentHashMap<>();
        issues = new ConcurrentHashMap<>();
    }

    public static InMemoryDatabase getInstance(){
        if(instance==null){
            instance = new InMemoryDatabase();
        }
        return instance;
    }

    public boolean isCustomerExists(String emailId){
        return customers.containsKey(emailId);
    }

    public void addCustomer(Customer user){
        customers.put(user.getEmail(), user);
    }

    public Customer getCustomer(String emailId){
        return customers.get(emailId);
    }

    public void addIssue(Issue issue){
        issues.put(issue.getIssueId(), issue);
    }

    public boolean isAgentExists(String emailId){
        return agents.containsKey(emailId);
    }

    public void addAgent(Agent user){
        agents.put(user.getEmail(), user);
    }

    public Agent getAgent(String emailId){
        return agents.get(emailId);
    }

    public Issue getIssue(int issueId){
        return issues.get(issueId);
    }

    public List<Agent> findAvailableAgentsByIssueType(IssueType issueType){
        List<Agent> agentsList = new ArrayList<>();
        for(Agent agent : agents.values()){
            if(agent.isAvailable() && agent.getIssueTypes().contains(issueType)){
                agentsList.add(agent);
            }
        }
        return agentsList;
    }
}
