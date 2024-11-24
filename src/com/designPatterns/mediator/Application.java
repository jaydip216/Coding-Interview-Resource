package com.designPatterns.mediator;

public class Application {

    public static void main(String[] args) {
        ChatMediator mediator1 = new ChatMediatorImpl();
        ChatMediator mediator2 = new ChatMediatorImpl();
        User user1 = new UserImpl(mediator1, "User 1");
        User user2 = new UserImpl(mediator1, "User 2");
        User user3 = new UserImpl(mediator2, "User 3");
        User user4 = new UserImpl(mediator2, "User 4");
        mediator1.addUser(user1);
        mediator1.addUser(user2);
        mediator2.addUser(user3);
        mediator2.addUser(user4);
        user1.send("Hello everyone! 1");
        user3.send("Hello everyone! 2");
    }
}
