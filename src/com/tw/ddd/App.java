package com.tw.ddd;

import com.tw.ddd.domain.ParkingBoy;
import com.tw.ddd.domain.ParkingLot;
import com.tw.ddd.valueobject.Car;
import com.tw.ddd.valueobject.Ticket;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class App {
    public static void main(String[] args) {

        // 1. 修建一批parking Lot
        ParkingLot parkingLot1 = new ParkingLot(new AtomicInteger(100));
        ParkingLot parkingLot2 = new ParkingLot(new AtomicInteger(200));
        ParkingLot parkingLot3 = new ParkingLot(new AtomicInteger(300));
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        parkingLots.add(parkingLot3);

        // 2. 招聘一名 parking boy 并给他一批parking lot
        ParkingBoy handsomeBoy = new ParkingBoy(parkingLots);

        // 3. 停车
        Car car = new Car("陕A.88888");
        Ticket ticket = handsomeBoy.park(car);
        System.out.println("ticket=" + ticket);

        // 4. 取车
        Car myCar = handsomeBoy.take(ticket);
        System.out.println("car=" + myCar);

    }
}
