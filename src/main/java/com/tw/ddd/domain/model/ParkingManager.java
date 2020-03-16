package com.tw.ddd.domain.model;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ParkingManager {
    UUID id = UUID.randomUUID();
    String name;
    List<UUID> parkingBoys = new ArrayList<>();

    public UUID findParkingBoy() {
        return parkingBoys.stream().findAny().get();
    }

    public List<UUID> getParkingBoys() {
        return parkingBoys;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setParkingBoys(List<UUID> parkingBoys) {
        this.parkingBoys = parkingBoys;
    }
}
