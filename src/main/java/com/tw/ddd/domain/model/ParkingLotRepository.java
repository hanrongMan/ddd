package com.tw.ddd.domain.model;

import java.util.UUID;

public interface ParkingLotRepository {
    ParkingLot findById(UUID id);
    void save(ParkingLot parkingLot);
}
