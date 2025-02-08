package com.recentInterviewQues.phonePe.hackathon;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryDatabase {
    private static InMemoryDatabase instance;
    private final Map<Integer, Problem> problems = new ConcurrentHashMap<>();
    private final Map<Integer, User> users = new ConcurrentHashMap<>();

    public void addProblem(Problem problem) {
        problems.put(problem.getId(), problem);
    }

    public void addUser(User user) {
        users.put(user.getId(), user);
    }

    public List<Problem> fetchProblems(String difficulty, String tag, Comparator<Problem> comparator) {
        List<Problem> result = new ArrayList<>();
        for (Problem problem : problems.values()) {
            if ((difficulty == null || problem.getDifficulty().equals(difficulty)) &&
                    (tag == null || problem.getTag().equals(tag))) {
                result.add(problem);
            }
        }
        result.sort(comparator);
        return result;
    }

    public void solveProblem(int userId, int problemId, long timeTaken) {
        User user = users.get(userId);
        Problem problem = problems.get(problemId);
        if (user != null && problem != null) {
            user.solveProblem(problemId);
            problem.solve(timeTaken);
        }
    }

    public List<Problem> fetchSolvedProblems(int userId) {
        User user = users.get(userId);
        List<Problem> result = new ArrayList<>();
        if (user != null) {
            for (int problemId : user.getSolvedProblems()) {
                result.add(problems.get(problemId));
            }
        }
        return result;
    }

    public User getLeader() {
        User leader = null;
        int maxSolved = 0;
        for (User user : users.values()) {
            if (user.getSolvedProblems().size() > maxSolved) {
                maxSolved = user.getSolvedProblems().size();
                leader = user;
            }
        }
        return leader;
    }

    public List<Problem> getTopNProblems(String tag, int n) {
        List<Problem> result = new ArrayList<>();
        for (Problem problem : problems.values()) {
            if (problem.getTag().equals(tag)) {
                result.add(problem);
            }
        }
        result.sort((p1, p2) -> Integer.compare(p2.getSolvedCount(), p1.getSolvedCount()));
        return result.subList(0, Math.min(n, result.size()));
    }
}
