package com.designPatterns.mediator;

public abstract class User {
    private ChatMediator mediator;
    private String name;

    public User(ChatMediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    public ChatMediator getMediator() {
        return mediator;
    }

    public String getName() {
        return name;
    }

    public abstract  void send(String message);

    public abstract void receive(String message);
}
