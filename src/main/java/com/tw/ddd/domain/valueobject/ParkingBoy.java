package com.tw.ddd.domain.valueobject;

import com.tw.ddd.domain.model.ParkingLot;
import com.tw.ddd.domain.strategy.FindParkingLotStrategy;
import com.tw.ddd.domain.valueobject.Car;
import com.tw.ddd.domain.valueobject.Ticket;

import java.util.List;
import java.util.Optional;

public class ParkingBoy {
    private List<ParkingLot> parkingLots;
    private FindParkingLotStrategy findParkingLotStrategy;

    public ParkingBoy(List<ParkingLot> parkingLots, FindParkingLotStrategy findParkingLotStrategy) {
        this.parkingLots = parkingLots;
        this.findParkingLotStrategy = findParkingLotStrategy;
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

    public FindParkingLotStrategy getFindParkingLotStrategy() {
        return findParkingLotStrategy;
    }

    public void setFindParkingLotStrategy(FindParkingLotStrategy findParkingLotStrategy) {
        this.findParkingLotStrategy = findParkingLotStrategy;
    }
}
