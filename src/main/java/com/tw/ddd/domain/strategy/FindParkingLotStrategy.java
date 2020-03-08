package com.tw.ddd.domain.strategy;

import com.tw.ddd.domain.model.ParkingLot;

import java.util.List;

public abstract class FindParkingLotStrategy {
   public abstract ParkingLot find(List<ParkingLot> parkingLots);
}
