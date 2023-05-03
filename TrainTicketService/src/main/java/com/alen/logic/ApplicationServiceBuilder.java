package com.alen.logic;

import com.alen.data.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ApplicationServiceBuilder {

    public List<Train> getTrains() {
        return List.of(
                new Train(1, "Express Train", TrainTypes.PASSENGER, LocalTime.of(8, 0), LocalTime.of(11, 30), Destinations.VIENNA, Destinations.SALZBURG, 25.50),
                new Train(2, "Freight Train", TrainTypes.FREIGHT, LocalTime.of(12, 0), LocalTime.of(15, 30), Destinations.INNSBRUCK, Destinations.GRAZ, 0),
                new Train(3, "High Speed Train", TrainTypes.HIGH_SPEED, LocalTime.of(16, 0), LocalTime.of(19, 30), Destinations.KLAGENFURT, Destinations.LINZ, 35.00),
                new Train(4, "Regional Train", TrainTypes.PASSENGER, LocalTime.of(9, 0), LocalTime.of(12, 15), Destinations.EISENSTADT, Destinations.VILLACH, 10.50),
                new Train(5, "InterCity Train", TrainTypes.PASSENGER, LocalTime.of(13, 0), LocalTime.of(17, 45), Destinations.SALZBURG, Destinations.GRAZ, 28.75)
        );
    }

    public List<Passenger> getPassengers() {
        return List.of(
                new Passenger(1, "Anna Mayer", "Vienna, Austria", "anna.mayer@gmail.com", "+43660325478"),
                new Passenger(2, "Maximilian Huber", "Salzburg, Austria", "maximilian.huber@gmail.com", "+43660234567"),
                new Passenger(3, "Sophie Berger", "Innsbruck, Austria", "sophie.berger@gmail.com", "+43664123456"),
                new Passenger(4, "David Bauer", "Linz, Austria", "david.bauer@gmail.com", "+43660345678"),
                new Passenger(5, "Lisa König", "Graz, Austria", "lisa.koenig@gmail.com", "+43660234567"),
                new Passenger(6, "Julian Wolf", "Klagenfurt, Austria", "julian.wolf@gmail.com", "+43664123456"),
                new Passenger(7, "Tina Hofmann", "Wels, Austria", "tina.hofmann@gmail.com", "+43660345678"),
                new Passenger(8, "Sebastian Lehner", "Villach, Austria", "sebastian.lehner@gmail.com", "+43660234567"),
                new Passenger(9, "Hannah Winkler", "Dornbirn, Austria", "hannah.winkler@gmail.com", "+43664123456"),
                new Passenger(10, "Jakob Mayer", "St. Pölten, Austria", "jakob.mayer@gmail.com", "+43660345678")
        );
    }

    public List<Booking> getBookings() {
        List<Train> trains = getTrains();
        List<Passenger> passengers = getPassengers();
        List<Booking> bookings = new ArrayList<>();
        bookings.add(new Booking(1, LocalDate.of(2023, 5, 3), trains.get(0), passengers.get(0), 2));
        bookings.add(new Booking(2, LocalDate.of(2023, 5, 5), trains.get(0), passengers.get(1), 1));
        bookings.add(new Booking(3, LocalDate.of(2023, 5, 7), trains.get(2), passengers.get(2), 4));
        bookings.add(new Booking(4, LocalDate.of(2023, 5, 8), trains.get(3), passengers.get(3), 3));
        bookings.add(new Booking(5, LocalDate.of(2023, 5, 10), trains.get(4), passengers.get(4), 2));
        bookings.add(new Booking(6, LocalDate.of(2023, 5, 12), trains.get(0), passengers.get(5), 1));
        bookings.add(new Booking(7, LocalDate.of(2023, 5, 14), trains.get(3), passengers.get(0), 2));
        bookings.add(new Booking(8, LocalDate.of(2023, 5, 16), trains.get(2), passengers.get(7), 3));
        bookings.add(new Booking(9, LocalDate.of(2023, 5, 18), trains.get(3), passengers.get(8), 2));
        bookings.add(new Booking(10, LocalDate.of(2023, 5, 20), trains.get(4), passengers.get(9), 1));
        return bookings;
    }
}
