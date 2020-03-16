package com.tw.ddd.application.impl;

import com.tw.ddd.application.ParkingBoyService;
import com.tw.ddd.domain.ParkingBoyFactory;
import com.tw.ddd.domain.model.ParkingBoyConfig;
import com.tw.ddd.domain.model.ParkingBoyConfigRepository;
import com.tw.ddd.domain.model.ParkingLot;
import com.tw.ddd.domain.service.FindParkingLotService;
import com.tw.ddd.domain.valueobject.Car;
import com.tw.ddd.domain.valueobject.ParkingBoy;
import com.tw.ddd.domain.valueobject.Ticket;

import java.util.UUID;

public class ParkingBoyServiceImpl implements ParkingBoyService {

    private ParkingBoyConfigRepository parkingBoyConfigRepository;
    private FindParkingLotService findParkingLotService;

    public ParkingBoyServiceImpl(ParkingBoyConfigRepository parkingBoyConfigRepository,
                                 FindParkingLotService findParkingLotService) {
        this.parkingBoyConfigRepository = parkingBoyConfigRepository;
        this.findParkingLotService = findParkingLotService;
    }

    @Override
    public Ticket parkingCar(String parkingBoyId, Car car) {
        ParkingBoyConfig parkingBoyConfig = parkingBoyConfigRepository.findById(UUID.fromString(parkingBoyId));
        ParkingBoy parkingBoy = ParkingBoyFactory.toParkingBoy(parkingBoyConfig);
        ParkingLot parkingLot = findParkingLotService.findParkingLot(parkingBoy);
        return parkingLot.park(car);
    }
}
