package com.tw.ddd.domain.strategy;

import com.tw.ddd.domain.model.ParkingLot;

import java.util.Comparator;
import java.util.List;

public class SpaceMaxFindParkingLot extends FindParkingLotStrategy {

    @Override
    public ParkingLot find(List<ParkingLot> parkingLots) {
        return parkingLots.stream()
                .filter(ParkingLot::hasSpace)
                .sorted(Comparator.comparingInt(ParkingLot::getCapacity).reversed())
                .findFirst()
                .get();
    }
}
