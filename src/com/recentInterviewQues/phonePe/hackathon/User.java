package com.recentInterviewQues.phonePe.hackathon;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.HashSet;
import java.util.Set;

public class User {
    private static final AtomicInteger count = new AtomicInteger(0);
    private final int id;
    private String name;
    private String department;
    private Set<Integer> solvedProblems;

    public User(String name, String department) {
        this.id = count.incrementAndGet();
        this.name = name;
        this.department = department;
        this.solvedProblems = new HashSet<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public Set<Integer> getSolvedProblems() {
        return solvedProblems;
    }

    public void solveProblem(int problemId) {
        solvedProblems.add(problemId);
    }
}