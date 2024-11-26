package com.lowLevelDesign.carrentalsystem;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        RentalSystem rentalSystem = RentalSystem.getInstance();

        // Add cars to the rental system
        rentalSystem.addCar(new Car("Toyota", "Camry", CarType.HACHBACK, BigDecimal.valueOf(400),"ABC123"));
        rentalSystem.addCar(new Car("Honda", "Civic", CarType.SEDAN, BigDecimal.valueOf(500),"XYZ789" ));
        rentalSystem.addCar(new Car("Honda", "Elevate", CarType.HACHBACK, BigDecimal.valueOf(300),"DEF456"));

        // Create customers
        User customer1 = new User("John Doe", "9106964526", "DL1234");
        rentalSystem.addUser(customer1);

        // Make reservations
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = startDate.plusDays(3);
        List<Car> availableCars = rentalSystem.searchCars("Toyota", "Camry", startDate, endDate);
        if (!availableCars.isEmpty()) {
            Car selectedCar = availableCars.get(0);
            String reservationId = rentalSystem.reserveCar(customer1, selectedCar, startDate, endDate, new CardPaymentProcessor());
            if (reservationId != null) {
                boolean paymentSuccess = rentalSystem.processPayment(new CardPaymentProcessor(),reservationId);
                if (paymentSuccess) {
                    System.out.println("Reservation successful. Reservation ID: " + reservationId);
                } else {
                    System.out.println("Payment failed. Reservation canceled.");
                    rentalSystem.cancelReservation(reservationId);
                }
            } else {
                System.out.println("Selected car is not available for the given dates.");
            }
        } else {
            System.out.println("No available cars found for the given criteria.");
        }
    }
}
