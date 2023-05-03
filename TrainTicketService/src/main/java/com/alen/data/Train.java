package com.alen.data;

import java.time.LocalTime;

public class Train {
    private final int id;
    private final String name;
    private final TrainTypes trainType;
    private final LocalTime departure;
    private final LocalTime arrival;
    private final Destinations originStation;
    private final Destinations destinationStation;
    private double price;

    public Train(int id, String name, TrainTypes trainType, LocalTime departure, LocalTime arrival, Destinations originStation, Destinations destinationStation, double price) {
        this.id = id;
        this.name = name;
        this.trainType = trainType;
        this.departure = departure;
        this.arrival = arrival;
        this.originStation = originStation;
        this.destinationStation = destinationStation;
        this.price = price;
        validateTrainType(trainType);
    }

    private void validateTrainType(TrainTypes trainType) {
        if (trainType.equals(TrainTypes.FREIGHT)) {
            this.price = 0;
        } else {
            this.price = price;
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public TrainTypes getTrainType() {
        return trainType;
    }

    public LocalTime getDeparture() {
        return departure;
    }

    public LocalTime getArrival() {
        return arrival;
    }

    public Destinations getOriginStation() {
        return originStation;
    }

    public Destinations getDestinationStation() {
        return destinationStation;
    }


    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Train{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", trainType=" + trainType +
               ", departure=" + departure +
               ", arrival=" + arrival +
               ", originStation=" + originStation +
               ", destinationStation=" + destinationStation +
               ", price=" + price +
               '}';
    }
}
