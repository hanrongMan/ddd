package com.tw.ddd.application.impl;

import com.tw.ddd.application.ParkingManagerService;
import com.tw.ddd.domain.model.ParkingLot;
import com.tw.ddd.domain.valueobject.Car;
import com.tw.ddd.domain.valueobject.Ticket;

public class ParkingManagerServiceImpl implements ParkingManagerService {
    @Override
    public Ticket parkingCar(Car car) {
        return null;
    }

    @Override
    public ParkingLot getAvailableParkingLot() {
        return null;
    }
}
