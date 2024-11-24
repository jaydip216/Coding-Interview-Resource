package com.designPatterns.mediator;

public class UserImpl extends User {
    public UserImpl(ChatMediator mediator, String name) {
        super(mediator, name);
    }

    @Override
    public void send(String message) {
        System.out.println(this.getName() + " sending message: " + message);
        getMediator().sendMessage(message, this);
    }

    @Override
    public void receive(String message) {
        System.out.println(this.getName() + " received message: " + message);
    }
}
