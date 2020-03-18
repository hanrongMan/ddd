package com.tw.ddd.application;

import com.tw.ddd.domain.model.ParkingLot;
import com.tw.ddd.domain.valueobject.Car;
import com.tw.ddd.domain.valueobject.Ticket;

public interface ParkingManagerService {
    /**
     * 停车经理停车
     *
     * @param managerId
     * @param car
     * @return
     */
    Ticket parkingCar(String managerId, Car car) throws IllegalAccessException, InstantiationException, ClassNotFoundException;

    /**
     * 询问停车经理可用停车场
     *
     * @param managerId
     * @return
     */
    ParkingLot getAvailableParkingLot(String managerId);
}
