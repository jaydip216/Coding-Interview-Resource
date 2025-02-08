package com.recentInterviewQues.phonePe.hackathon;

import java.util.Comparator;
import java.util.List;

/*
Mandatory Functionalities

The system should have the capability to add problems to the Questions Library.
Contestants should be able to register themselves with their name and their department name.
A problem should have attributes like description, tag, difficulty level (easy, medium, hard), score.
Contestants should be able to filter problems based on difficulty level or tags and sort them based on score (design should be extensible to other attributes )
A contestant should be able to solve a problem as well as get the list of problems solved by him/her.
A contestant should be able to see the number of users that have solved a given problem and average time taken to solve that problem.
Scoring strategy for a problem could simply be to award the score assigned for the problem or could be something different like a combination of score and time.
Return the current leader of the contest
Users should be able to get curations like Top 10 most liked problems of a certain tag.
        Extension Problem

On solving a problem, users should get a recommendation of top 5 problems based on relevance
The recommendation strategy for problems could simply be similar tags or extensible to include other factors like number of users who have solved a particular problem or a combination of factors ( Design should be extensible).
Capabilities

Below are various functions that should be supported with necessary parameters passed.
These are just suggestions, the signatures can be altered as long as the functionalities are provided.

Registering a problem - addProblem()
Registering a user - addUser()
Fetch the list of problems - fetchProblems() - Should take as input filtering and sorting criterias and return all matching problems in the right order.
The result should contain problem attributes like name, tag, difficulty level, score etc.
Should also display number of users who have solved a problem and the average time taken for that problem
Solve a problem - solve() - Exposed to a contestant to mark a problem as solved

[ For the extension problem, this function should return next 5 recommended problems ]
Fetch solved problems for a user - fetchSolvedProblems() - Fetch the list of solved problems for a user
Get leader - getLeader() - Returns the name and department of the leader
Get top n liked problems of a certain tag - getTopNProblems()
 */
public class Hackathon {
    private final InMemoryDatabase db = new InMemoryDatabase();

    public void addProblem(String description, String tag, String difficulty, int score) {
        db.addProblem(new Problem(description, tag, difficulty, score));
    }

    public void addUser(String name, String department) {
        db.addUser(new User(name, department));
    }

    public List<Problem> fetchProblems(String difficulty, String tag, Comparator<Problem> comparator) {
        return db.fetchProblems(difficulty, tag, comparator);
    }

    public void solveProblem(int userId, int problemId, long timeTaken) {
        db.solveProblem(userId, problemId, timeTaken);
    }

    public List<Problem> fetchSolvedProblems(int userId) {
        return db.fetchSolvedProblems(userId);
    }

    public User getLeader() {
        return db.getLeader();
    }

    public List<Problem> getTopNProblems(String tag, int n) {
        return db.getTopNProblems(tag, n);
    }
}
