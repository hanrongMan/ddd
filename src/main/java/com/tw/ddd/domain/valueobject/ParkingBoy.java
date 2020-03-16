package com.tw.ddd.domain.valueobject;

import com.tw.ddd.domain.model.ParkingLot;
import com.tw.ddd.domain.strategy.FindParkingLotStrategy;

import java.util.List;
import java.util.UUID;

public class ParkingBoy {
    UUID id;
    String name;
    private List<ParkingLot> parkingLots;
    private FindParkingLotStrategy findParkingLotStrategy;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public List<ParkingLot> getParkingLots() {
        return parkingLots;
    }

    public void setParkingLots(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public FindParkingLotStrategy getFindParkingLotStrategy() {
        return findParkingLotStrategy;
    }

    public void setFindParkingLotStrategy(FindParkingLotStrategy findParkingLotStrategy) {
        this.findParkingLotStrategy = findParkingLotStrategy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
