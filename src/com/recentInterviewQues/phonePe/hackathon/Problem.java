package com.recentInterviewQues.phonePe.hackathon;

import java.util.concurrent.atomic.AtomicInteger;

public class Problem {
    private static final AtomicInteger count = new AtomicInteger(0);
    private final int id;
    private String description;
    private String tag;
    private String difficulty;
    private int score;
    private int solvedCount;
    private long totalTimeTaken;

    public Problem(String description, String tag, String difficulty, int score) {
        this.id = count.incrementAndGet();
        this.description = description;
        this.tag = tag;
        this.difficulty = difficulty;
        this.score = score;
        this.solvedCount = 0;
        this.totalTimeTaken = 0;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getTag() {
        return tag;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public int getScore() {
        return score;
    }

    public int getSolvedCount() {
        return solvedCount;
    }

    public long getTotalTimeTaken() {
        return totalTimeTaken;
    }

    public void solve(long timeTaken) {
        this.solvedCount++;
        this.totalTimeTaken += timeTaken;
    }

    public double getAverageTimeTaken() {
        return solvedCount == 0 ? 0 : (double) totalTimeTaken / solvedCount;
    }
}
