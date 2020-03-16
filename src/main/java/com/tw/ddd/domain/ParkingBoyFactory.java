package com.tw.ddd.domain;

import com.tw.ddd.domain.model.ParkingBoyConfig;
import com.tw.ddd.domain.valueobject.ParkingBoy;


public class ParkingBoyFactory {

    public static ParkingBoy toParkingBoy(ParkingBoyConfig parkingBoyConfig) {
        return new ParkingBoy();
    }
}
