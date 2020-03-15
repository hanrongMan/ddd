package com.tw.ddd.infrastructure;

import com.tw.ddd.domain.model.ParkingBoyConfig;
import com.tw.ddd.domain.model.ParkingBoyConfigRepository;

import java.util.UUID;

public class ParkingBoyConfigRepositoryImpl implements ParkingBoyConfigRepository {
    @Override
    public ParkingBoyConfig findById(UUID Id) {
        return null;
    }

    @Override
    public void save(ParkingBoyConfig parkingBoyConfig) {

    }
}
