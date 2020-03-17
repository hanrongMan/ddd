package com.tw.ddd.domain;

import com.tw.ddd.domain.model.ParkingBoyConfig;
import com.tw.ddd.domain.strategy.FindParkingLotStrategy;
import com.tw.ddd.domain.valueobject.ParkingBoy;


public class ParkingBoyFactory {

    public static ParkingBoy toParkingBoy(ParkingBoyConfig parkingBoyConfig) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ParkingBoy parkingBoy = new ParkingBoy();
        parkingBoy.setId(parkingBoyConfig.getId());
        parkingBoy.setName(parkingBoyConfig.getName());
        Class<?> clz = Class.forName(parkingBoyConfig.getFindParkingLotStrategyClassName());
        parkingBoy.setFindParkingLotStrategy((FindParkingLotStrategy) clz.newInstance());
        return parkingBoy ;
    }
}
