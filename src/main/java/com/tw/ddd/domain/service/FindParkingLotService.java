package com.tw.ddd.domain.service;

import com.tw.ddd.domain.model.ParkingBoy;
import com.tw.ddd.domain.model.ParkingLot;
import com.tw.ddd.domain.strategy.FindParkingLotStrategy;

public class FindParkingLotService {
    public ParkingLot findParkingLot(ParkingBoy parkingBoy) {
        FindParkingLotStrategy findParkingLotStrategy = parkingBoy.getFindParkingLotStrategy();
        return findParkingLotStrategy.find(parkingBoy.getParkingLots());
    }
}
