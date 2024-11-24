package com.designPatterns.facade;

public class ZomatoFacade {
    private Restraunt restraunt;
    private DeliveyTeam deliveyTeam;
    private DeliveyPartner deliveyPartner;

    public ZomatoFacade() {
        restraunt = new Restraunt();
        deliveyTeam = new DeliveyTeam();
        deliveyPartner = new DeliveyPartner();
    }

    public void orderFood() {
        restraunt.prepareFood();
        deliveyTeam.assignDeliveyPartner();
        deliveyPartner.pickupProduct();
        deliveyPartner.deliverProduct();
    }
}
