package com.lowLevelDesign.pubsubsystem;

public interface Subscriber {
    void onMessage(Message message);
}
