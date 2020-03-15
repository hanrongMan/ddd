package com.tw.ddd.domain.model;

import com.tw.ddd.domain.valueobject.ParkingBoy;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ParkingManager {
    UUID id;
    List<ParkingBoy> parkingBoys = new ArrayList<>();

    public ParkingBoy findParkingBoy() {
        return parkingBoys.stream().findAny().get();
    }

    public void recruitParkingBoy(ParkingBoy parkingBoy) {
        Optional.ofNullable(parkingBoy).map(parkingBoys::add);
    }

    public List<ParkingBoy> getParkingBoys() {
        return parkingBoys;
    }
}
