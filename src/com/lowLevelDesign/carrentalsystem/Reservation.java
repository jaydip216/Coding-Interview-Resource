package com.lowLevelDesign.carrentalsystem;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

public class Reservation {
    private String reservationId;
    private User user;
    private Car car;
    private LocalDate startDate;
    private LocalDate endDate;
    private BigDecimal amount;

    public Reservation(User user, Car car, LocalDate startDate, LocalDate endDate) {
        this.reservationId = generateId();
        this.user = user;
        this.car = car;
        this.startDate = startDate;
        this.endDate = endDate;
        long days = ChronoUnit.DAYS.between(startDate,endDate);
        this.amount = car.getRentPerDay().multiply(BigDecimal.valueOf(days));
    }

    private String generateId(){
        return UUID.randomUUID().toString();
    }

    public BigDecimal getAmount(){
        return this.amount;
    }

    public String getReservationId() {
        return reservationId;
    }

    public Car getCar() {
        return car;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public User getUser() {
        return user;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
}
