package com.lowLevelDesign.carrentalsystem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class RentalSystem {
    private static RentalSystem instance=null;

    private Map<String, Reservation> reservations;
    private Map<String, Car> cars;
    private List<User> users;

    public static synchronized RentalSystem getInstance(){
        if(instance==null){
            instance = new RentalSystem();
        }
        return instance;
    }

    private RentalSystem(){
        reservations=new ConcurrentHashMap<>();
        cars=new ConcurrentHashMap<>();
        users=new CopyOnWriteArrayList<>();
    }

    public void addUser(User user){
        users.add(user);
    }

    public void removeCar(String licensePlate) {
        cars.remove(licensePlate);
    }

    public void addCar(Car car){
        cars.putIfAbsent(car.getLicencePlateNo(), car);
    }

    public List<Car> searchCars(String make, String model, LocalDate startDate, LocalDate endDate) {
        List<Car> availableCars = new ArrayList<>();
        for (Car car : cars.values()) {
            if (car.getMake().equalsIgnoreCase(make) && car.getModel().equalsIgnoreCase(model)) {
                if (isCarAvailable(car, startDate, endDate)) {
                    availableCars.add(car);
                }
            }
        }
        return availableCars;
    }

    private boolean isCarAvailable(Car car, LocalDate startDate, LocalDate endDate) {
        for (Reservation reservation : reservations.values()) {
            if (reservation.getCar().equals(car)) {
                if (startDate.isBefore(reservation.getEndDate()) && endDate.isAfter(reservation.getStartDate())) {
                    return false;
                }
            }
        }
        return true;
    }

    public synchronized String reserveCar(User user, Car car, LocalDate startDate, LocalDate endDate, PaymentProcessor paymentProcessor){
        if(isUserExists(user) && isCarAvailable(car,startDate,endDate)){
            Reservation reservation = new Reservation(user, car, startDate, endDate);
            reservations.put(reservation.getReservationId(), reservation);
            return reservation.getReservationId();
        } else {
            return null;
        }
    }

    public synchronized void cancelReservation(String reservationId) {
        Reservation reservation = reservations.remove(reservationId);
    }

    private boolean isUserExists(User user){
        return users.contains(user);
    }

    public boolean processPayment(PaymentProcessor paymentProcessor,String reservationId) {
        return paymentProcessor.processPayment(reservations.get(reservationId).getAmount());
    }

}
