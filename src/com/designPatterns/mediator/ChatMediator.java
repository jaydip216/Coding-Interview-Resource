package com.designPatterns.mediator;

public abstract class ChatMediator {
    public abstract void sendMessage(String message, User user);
    public abstract void addUser(User user);
}
