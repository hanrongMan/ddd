package com.tw.ddd.domain.service;

import com.tw.ddd.domain.model.ParkingManager;

import java.util.List;

public class FindParkingManagerService {
    public ParkingManager findParkingManager(List<ParkingManager> parkingManagers) {
        return parkingManagers.stream().findAny().get();
    }
}
