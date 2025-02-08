package com.recentInterviewQues.phonePe.hackathon;

import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Hackathon hackathon = new Hackathon();

        // Adding problems
        hackathon.addProblem("Problem 1", "Array", "Easy", 10);
        hackathon.addProblem("Problem 2", "String", "Medium", 20);
        hackathon.addProblem("Problem 3", "Graph", "Hard", 30);

        // Adding users
        hackathon.addUser("Alice", "CS");
        hackathon.addUser("Bob", "IT");

        // Fetching problems
        List<Problem> problems = hackathon.fetchProblems("Easy", null, Comparator.comparingInt(Problem::getScore));
        System.out.println("Easy Problems: " + problems);

        // Solving problems
        hackathon.solveProblem(1, 1, 100);
        hackathon.solveProblem(2, 2, 200);

        // Fetching solved problems for a user
        List<Problem> solvedProblems = hackathon.fetchSolvedProblems(1);
        System.out.println("Solved Problems by User 1: " + solvedProblems);

        // Getting the leader
        User leader = hackathon.getLeader();
        System.out.println("Leader: " + leader.getName() + ", Department: " + leader.getDepartment());

        // Getting top N problems of a certain tag
        List<Problem> topProblems = hackathon.getTopNProblems("Array", 1);
        System.out.println("Top Array Problems: " + topProblems);
    }
}
