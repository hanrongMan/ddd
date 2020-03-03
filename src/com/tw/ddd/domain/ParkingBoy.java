package com.tw.ddd.domain;

import com.tw.ddd.valueobject.Car;
import com.tw.ddd.valueobject.Ticket;

import java.util.List;
import java.util.Optional;

public class ParkingBoy {
    private List<ParkingLot> parkingLots;

    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Ticket park(Car car) {
        return parkingLots.stream()
                .filter(parkingLot -> Optional.ofNullable(parkingLot.park(car))
                        .isPresent())
                .findFirst()
                .get()
                .park(car);
    }

    public Car take(Ticket ticket) {
        Car takeCar = parkingLots.stream()
                .filter(parkingLot -> Optional.ofNullable(parkingLot.take(ticket)).isPresent())
                .findFirst()
                .get()
                .take(ticket);
        if (Optional.ofNullable(takeCar).isPresent()) {
            ticket.invalidTicket();
        }
        return takeCar;
    }

    public void setParkingLots(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public List<ParkingLot> getParkingLots() {
        return parkingLots;
    }
}
