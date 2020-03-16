package com.tw.ddd.application;

import com.tw.ddd.domain.valueobject.Car;
import com.tw.ddd.domain.valueobject.Ticket;

public interface ParkingBoyService {
    /**
     * 停车小弟停车
     *
     * @param parkingBoyId
     * @param car
     * @return
     */
    Ticket parkingCar(String parkingBoyId, Car car);
}
