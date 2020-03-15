package com.tw.ddd.domain.model;

import java.util.UUID;

public interface ParkingBoyConfigRepository {
    ParkingBoyConfig findById(UUID Id);
    void save(ParkingBoyConfig parkingBoyConfig);
}
