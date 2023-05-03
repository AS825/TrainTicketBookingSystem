package com.alen.data;

import java.time.LocalDate;
import java.util.Objects;

public class Booking {
    private final int bookingId;
    private final LocalDate date;
    private Train train;
    private final Passenger passenger;
    private final int numberOfTickets;
    private final double price;

    public Booking(int bookingId, LocalDate date, Train train, Passenger passenger, int numberOfTickets) {
        this.bookingId = bookingId;
        this.date = date;
        validateTrainType(train);
        this.train = train;
        this.passenger = passenger;
        this.numberOfTickets = numberOfTickets;
        this.price = train.getPrice() * numberOfTickets;
    }

    private void validateTrainType(Train train) {
        if (train.getTrainType() == TrainTypes.PASSENGER || train.getTrainType() == TrainTypes.HIGH_SPEED) {
            this.train = train;
        } else {
            throw new IllegalArgumentException("Cannot book train of type " + train.getTrainType());
        }
    }

    public int getBookingId() {
        return bookingId;
    }

    public LocalDate getDate() {
        return date;
    }

    public Train getTrain() {
        return train;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Booking{" +
               "bookingId=" + bookingId +
               ", date=" + date +
               ", train=" + train +
               ", passenger=" + passenger +
               ", numberOfTickets=" + numberOfTickets +
               ", price=" + price +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Booking booking)) return false;
        return getBookingId() == booking.getBookingId() && getNumberOfTickets() == booking.getNumberOfTickets() && Double.compare(booking.getPrice(), getPrice()) == 0 && Objects.equals(getDate(), booking.getDate()) && Objects.equals(getTrain(), booking.getTrain()) && Objects.equals(getPassenger(), booking.getPassenger());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBookingId(), getDate(), getTrain(), getPassenger(), getNumberOfTickets(), getPrice());
    }
}
