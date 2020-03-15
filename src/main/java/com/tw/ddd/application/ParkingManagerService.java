package com.tw.ddd.application;

import com.tw.ddd.domain.model.ParkingLot;
import com.tw.ddd.domain.valueobject.Car;
import com.tw.ddd.domain.valueobject.Ticket;

public interface ParkingManagerService {
    Ticket parkingCar(Car car);
    ParkingLot getAvailableParkingLot();
}
