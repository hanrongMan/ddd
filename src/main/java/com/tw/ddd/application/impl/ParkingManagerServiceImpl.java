package com.tw.ddd.application.impl;

import com.tw.ddd.application.ParkingManagerService;
import com.tw.ddd.domain.ParkingBoyFactory;
import com.tw.ddd.domain.model.*;
import com.tw.ddd.domain.service.FindParkingLotService;
import com.tw.ddd.domain.valueobject.Car;
import com.tw.ddd.domain.valueobject.ParkingBoy;
import com.tw.ddd.domain.valueobject.Ticket;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

public class ParkingManagerServiceImpl implements ParkingManagerService {

    private ParkingManagerRepository parkingManagerRepository;
    private ParkingBoyConfigRepository parkingBoyConfigRepository;
    private FindParkingLotService findParkingLotService;

    public ParkingManagerServiceImpl(ParkingManagerRepository parkingManagerRepository,
                                     ParkingBoyConfigRepository parkingBoyConfigRepository,
                                     FindParkingLotService findParkingLotService){
        this.parkingBoyConfigRepository = parkingBoyConfigRepository;
        this.parkingManagerRepository = parkingManagerRepository;
        this.findParkingLotService = findParkingLotService;
    }

    @Override
    public Ticket parkingCar(String managerId, Car car) {
        ParkingManager parkingManager = parkingManagerRepository.findById(UUID.fromString(managerId));
        UUID parkingBoyId = parkingManager.findParkingBoy();
        ParkingBoyConfig parkingBoyConfig = parkingBoyConfigRepository.findById(parkingBoyId);
        ParkingBoy parkingBoy = ParkingBoyFactory.toParkingBoy(parkingBoyConfig);
        ParkingLot parkingLot = findParkingLotService.findParkingLot(parkingBoy);
        Ticket ticket = parkingLot.park(car);
        return ticket;
    }

    @Override
    public ParkingLot getAvailableParkingLot(String managerId) {
        ParkingManager parkingManager = parkingManagerRepository.findById(UUID.fromString(managerId));
        List<UUID> parkingBoys = parkingManager.getParkingBoys();
        AtomicReference<ParkingLot> availableParkingLot = null;
        parkingBoys.stream()
                .anyMatch(uuid -> {
                    return ParkingBoyFactory.toParkingBoy(parkingBoyConfigRepository.findById(uuid))
                            .getParkingLots().stream().anyMatch(parkingLot -> {
                                if (parkingLot.hasSpace()) {
                                    availableParkingLot.set(parkingLot);
                                    return true;
                                }
                                return false;
                            });
                });
        return availableParkingLot.get();
    }
}
