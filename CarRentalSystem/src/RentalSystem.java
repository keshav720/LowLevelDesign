import models.Car;
import models.Customer;
import models.Reservation;
import models.payments.CreditCardProcessor;
import models.payments.PaymentProcessor;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class RentalSystem {
    private static RentalSystem instance;
    private Map<String, Car> cars;
    private Map<String, Reservation> reservations;
    private PaymentProcessor paymentProcessor;

    private RentalSystem() {
        cars = new ConcurrentHashMap<>();
        reservations = new ConcurrentHashMap<>();
        paymentProcessor = new CreditCardProcessor();
    }

    public static RentalSystem getInstance() {
        if (instance == null) {
            instance = new RentalSystem();
        }
        return instance;
    }

    public Map<String, Car> getCars() {
        return cars;
    }

    public Map<String, Reservation> getReservations() {
        return reservations;
    }

    public PaymentProcessor getPaymentProcessor() {
        return paymentProcessor;
    }

    public void addCar(Car car) {
        cars.put(car.getLicensePlate(), car);
    }

    public void removeCar(Car car) {
        cars.remove(car.getLicensePlate());
    }

    public List<Car> searchCars(String make, String model, LocalDate startDate, LocalDate endDate) {
        List<Car> Searchcars = new ArrayList<>();
        for(Car car : cars.values())
        {
            if(car.getMake().equalsIgnoreCase(make) && car.getModel().equalsIgnoreCase(model) && car.isAvailable())
            {
                if(isCarAvaliable(car, startDate, endDate))
                Searchcars.add(car);
            }
        }
        return Searchcars;
    }

    private boolean isCarAvaliable(Car car, LocalDate startDate, LocalDate endDate) {
        for(Reservation reservation : reservations.values())
        {
            if(reservation.getCar().equals(car))
            {
                if(!(startDate.isAfter(reservation.getEndDate()) && endDate.isBefore(reservation.getStartDate())))
                    return false;
            }
        }
        return true;
    }

    public synchronized Reservation addReservation(Customer customer, Car car, LocalDate startDate, LocalDate endDate) {
        if(isCarAvaliable(car, startDate, endDate))
        {
            String reservationId = genrateReservationId();
            Reservation reservation = new Reservation(reservationId, customer, car, startDate, endDate);
            reservations.put(reservationId, reservation);
            car.setAvailable(false);
            return reservation;
        }
        return null;
    }

    public synchronized void cancelReservation(Reservation reservation) {
        Reservation removed = reservations.remove(reservation.getReservationID());
        if(removed != null){
            reservation.getCar().setAvailable(true);
        }
    }

    public boolean processPayment(Reservation reservation) {
        return paymentProcessor.processPayment(reservation.getTotalPrice());
    }

    private String genrateReservationId() {
        return "RES" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }



}
