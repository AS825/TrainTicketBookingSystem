package com.alen;

import com.alen.data.Booking;
import com.alen.data.Passenger;
import com.alen.data.Train;
import com.alen.logic.ApplicationServiceBuilder;
import com.alen.logic.TrainTicketSystem;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        ApplicationServiceBuilder serviceBuilder = new ApplicationServiceBuilder();
        List<Train> trains = serviceBuilder.getTrains();
        List<Passenger> passengers = serviceBuilder.getPassengers();
        List<Booking> bookings = serviceBuilder.getBookings();
        TrainTicketSystem trainTicketSystem = new TrainTicketSystem(trains,passengers,bookings);

        Map<String, Integer> bookingsForTrains = trainTicketSystem.getBookingsForTrains();
        System.out.println("bookingsForTrains = " + bookingsForTrains);

        double TicketPriceMax = 30;
        List<String> trainsWithPrice = trainTicketSystem.getTrainsByTicketPrice(TicketPriceMax);
        System.out.println("trainsWithPrice = " + trainsWithPrice);

        Optional<Passenger> passengerWithMostBookings = trainTicketSystem.getPassengerWithMostBookings();
        System.out.println("passengerWithMostBookings = " + passengerWithMostBookings);

        Optional<Train> mostBookedTrain = trainTicketSystem.getMostBookedTrain();
        System.out.println("mostBookedTrain = " + mostBookedTrain);
    }
}