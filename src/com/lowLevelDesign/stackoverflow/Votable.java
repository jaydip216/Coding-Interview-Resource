package com.lowLevelDesign.stackoverflow;

public interface Votable {
    void vote(User user, int value);
    int getVoteCount();
}
