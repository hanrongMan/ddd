package com.tw.ddd.domain.model;

import java.util.UUID;

public interface ParkingManagerRepository {
    ParkingManager findById(UUID id);

    void save(ParkingManager parkingManager);
}
