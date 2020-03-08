package com.tw.ddd;

import com.tw.ddd.domain.model.ParkingBoy;
import com.tw.ddd.domain.model.ParkingLot;
import com.tw.ddd.domain.service.FindParkingLotService;
import com.tw.ddd.domain.service.ParkCarService;
import com.tw.ddd.domain.strategy.SortedFindParkingLot;
import com.tw.ddd.domain.strategy.SpaceMaxFindParkingLot;
import com.tw.ddd.domain.valueobject.Car;
import com.tw.ddd.domain.valueobject.Ticket;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Manager {
    public static void main(String[] args) {
        FindParkingLotService findParkingLotService = new FindParkingLotService();
        ParkCarService parkCarService = new ParkCarService();

        // 1. 修建parking Lot
        ParkingLot parkingLot1 = new ParkingLot(new AtomicInteger(100));
        ParkingLot parkingLot2 = new ParkingLot(new AtomicInteger(200));
        ParkingLot parkingLot3 = new ParkingLot(new AtomicInteger(200));
        ParkingLot parkingLot4 = new ParkingLot(new AtomicInteger(300));
        List<ParkingLot> parkingLots1 = new ArrayList<>();
        parkingLots1.add(parkingLot1);
        parkingLots1.add(parkingLot2);
        List<ParkingLot> parkingLots2 = new ArrayList<>();
        parkingLots2.add(parkingLot3);
        parkingLots2.add(parkingLot4);

        // 2. 招聘2名 parking boy 并分配parkingLot
        ParkingBoy juniorBoy = new ParkingBoy(parkingLots1, new SortedFindParkingLot());
        ParkingBoy seniorBoy = new ParkingBoy(parkingLots2, new SpaceMaxFindParkingLot());

        // 3. 停车
        Car car1 = new Car("陕A.66666");
        ParkingLot foundParkingLot1 = findParkingLotService.findParkingLot(juniorBoy);
        Ticket ticket1 = parkCarService.parkCar(foundParkingLot1, car1);
        System.out.println("car1 = " + car1 + "停车成功，ticket1 = " + ticket1);

        Car car2 = new Car("陕A.88888");
        ParkingLot foundParkingLot2 = findParkingLotService.findParkingLot(seniorBoy);
        Ticket ticket2 = parkCarService.parkCar(foundParkingLot2, car2);
        System.out.println("car2 = " + car2 + "停车成功，ticket2 = " + ticket2);

        // 4. 取车
        Car myCar1 = juniorBoy.take(ticket1);
        System.out.println("ticket1 = " + ticket1 + "取车成功，car1=" + myCar1);

        Car myCar2 = seniorBoy.take(ticket2);
        System.out.println("ticket2 = " + ticket2 + "取车成功，car2=" + myCar2);
    }
}
