package com.tw.ddd.domain.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ParkingManager {
    List<ParkingBoy> parkingBoys = new ArrayList<>();

    public ParkingBoy findParkingBoy(){
       return parkingBoys.stream().findAny().get();
    }

    public void recruitParkingBoy(ParkingBoy parkingBoy){
      Optional.ofNullable(parkingBoy).map(parkingBoys::add);
    }

    public List<ParkingBoy> getParkingBoys() {
        return parkingBoys;
    }
}
