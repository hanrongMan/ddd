package com.tw.ddd.domain;

import com.tw.ddd.domain.valueobject.ParkingBoy;
import com.tw.ddd.domain.model.ParkingBoyConfig;

import java.util.UUID;

public class ParkingBoyFactory {
    public static ParkingBoy getParkingBoy(UUID ParkingBoyId) {
        ParkingBoyConfig parkingBoyConfig = repo.findParkingBoy(ParkingBoyId);
        return convert(parkingBoyConfig);
    }

    private static ParkingBoy convert(ParkingBoyConfig parkingBoyConfig) {
        return  new ParkingBoy();
    }
}
