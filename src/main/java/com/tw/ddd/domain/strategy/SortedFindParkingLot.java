package com.tw.ddd.domain.strategy;

import com.tw.ddd.domain.model.ParkingLot;

import java.util.List;

public class SortedFindParkingLot extends FindParkingLotStrategy {
    @Override
    public ParkingLot find(List<ParkingLot> parkingLots) {
        return parkingLots.stream()
                .filter(ParkingLot::hasSpace)
                .findFirst()
                .get();
    }
}
