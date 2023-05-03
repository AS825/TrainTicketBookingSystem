package com.alen.logic;

import com.alen.data.Booking;
import com.alen.data.Passenger;
import com.alen.data.Train;
import com.alen.data.TrainTypes;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TrainTicketSystem {
    private final List<Train> trains;
    private final List<Passenger> passengers;
    private final List<Booking> bookings;

    public TrainTicketSystem(List<Train> trains, List<Passenger> passengers, List<Booking> bookings) {
        this.trains = trains;
        this.passengers = passengers;
        this.bookings = bookings;
    }

    public List<Train> getTrains() {
        return trains;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public List<Booking> getBookings() {
        return bookings;
    }



    public List<String> getTrainsByTicketPrice(double ticketPriceMax) {
        return trains.stream()
                .filter(train -> !train.getTrainType().equals(TrainTypes.FREIGHT))
                .filter(train -> train.getPrice() <= ticketPriceMax)
                .map(train -> train.getName() + " - $" + train.getPrice())
                .toList();
    }


    public Map<String, Integer> getBookingsForTrains() {
        Map<String, Integer> trainMap = new HashMap<>();
         for (Train train : trains) {
             trainMap.put(train.getName(), getBookingForTrain(train));
        }
        return trainMap;
    }

    private int getBookingForTrain(Train train) {
        return bookings.stream()
                .filter(booking -> booking.getTrain().getId() == train.getId())
                .mapToInt(Booking::getNumberOfTickets)
                .sum();
    }


    public Optional<Passenger> getPassengerWithMostBookings() {
        List<Integer> passengerIdList = getIdsOfPassengers();
        Integer mostFrequentId = getMostFrequentId(passengerIdList);
        return getPassengerId(mostFrequentId);
    }

    private Optional<Passenger> getPassengerId(Integer passengerIdMax) {
        return getPassengers().stream()
                .filter(passenger -> passenger.id() == passengerIdMax)
                .findFirst();
    }

    private Integer getMostFrequentId(List<Integer> integerList) {
        return integerList.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .get().getKey();
    }

    private List<Integer> getIdsOfPassengers() {
       return bookings.stream()
                .map(booking -> booking.getPassenger().id())
                .sorted()
                .collect(Collectors.toList());
    }


    public Optional<Train> getMostBookedTrain() {
        List<Integer> trainIdList = trainIdList();
        Integer mostFrequentId = getMostFrequentId(trainIdList);
        return getTrainId(mostFrequentId);
    }

    private Optional<Train> getTrainId(Integer mostFrequentId) {
        return getTrains().stream()
                .filter(train -> train.getId() == mostFrequentId)
                .findFirst();
    }

    private List<Integer> trainIdList() {
       return bookings.stream()
                .map(booking -> booking.getTrain().getId())
                .sorted()
                .collect(Collectors.toList());
    }
}
