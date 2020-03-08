package com.tw.ddd.domain.service;

import com.tw.ddd.domain.model.ParkingLot;
import com.tw.ddd.domain.valueobject.Car;
import com.tw.ddd.domain.valueobject.Ticket;

public class ParkCarService {
    public Ticket parkCar(ParkingLot parkingLot, Car car) {
        return parkingLot.park(car);
    }
}
