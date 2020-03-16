package com.tw.ddd.infrastructure;

import com.tw.ddd.domain.model.ParkingManager;
import com.tw.ddd.domain.model.ParkingManagerRepository;

import java.util.UUID;

public class ParkingManagerRepositoryImpl implements ParkingManagerRepository {
    @Override
    public ParkingManager findById(UUID id) {
        return null;
    }

    @Override
    public void save(ParkingManager parkingManager) {

    }
}
