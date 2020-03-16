package com.tw.ddd.infrastructure;

import com.tw.ddd.domain.model.ParkingLot;
import com.tw.ddd.domain.model.ParkingLotRepository;

import java.util.UUID;

public class ParkingLotRepositoryImpl implements ParkingLotRepository {
    @Override
    public ParkingLot findById(UUID id) {
        return null;
    }

    @Override
    public void save(ParkingLot parkingLot) {

    }
}
