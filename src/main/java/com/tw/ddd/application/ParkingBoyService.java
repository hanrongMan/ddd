package com.tw.ddd.application;

import com.tw.ddd.domain.valueobject.Car;
import com.tw.ddd.domain.valueobject.Ticket;

public interface ParkingBoyService {
    Ticket parkingCar(Car car);
}
