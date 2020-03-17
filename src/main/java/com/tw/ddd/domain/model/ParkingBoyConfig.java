package com.tw.ddd.domain.model;

import com.tw.ddd.domain.strategy.FindParkingLotStrategy;

import java.util.List;
import java.util.UUID;

public class ParkingBoyConfig {
    UUID id;
    String name;
    private List<ParkingLot> parkingLots;
    private String findParkingLotStrategyClassName;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ParkingLot> getParkingLots() {
        return parkingLots;
    }

    public void setParkingLots(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public String getFindParkingLotStrategyClassName() {
        return findParkingLotStrategyClassName;
    }

    public void setFindParkingLotStrategyClassName(String findParkingLotStrategyClassName) {
        this.findParkingLotStrategyClassName = findParkingLotStrategyClassName;
    }
}
