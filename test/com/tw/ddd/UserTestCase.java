package com.tw.ddd;

import com.tw.ddd.application.ParkingBoyService;
import com.tw.ddd.application.ParkingManagerService;
import com.tw.ddd.application.impl.ParkingBoyServiceImpl;
import com.tw.ddd.application.impl.ParkingManagerServiceImpl;
import com.tw.ddd.domain.model.ParkingLot;
import com.tw.ddd.domain.service.FindParkingLotService;
import com.tw.ddd.domain.valueobject.Car;
import com.tw.ddd.domain.valueobject.Ticket;
import com.tw.ddd.infrastructure.ParkingBoyConfigRepositoryImpl;
import com.tw.ddd.infrastructure.ParkingManagerRepositoryImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

/**
 * 模拟用户,测试驱动
 */
public class UserTestCase {
    private ParkingManagerService parkingManagerService;
    private ParkingBoyService parkingBoyService;
    private String managerId;
    private Car car;
    private String parkingBoyId;

    @Before
    public void setUp() {
        managerId = UUID.randomUUID().toString();
        parkingBoyId = UUID.randomUUID().toString();
        car = new Car("陕A.88888");
        parkingManagerService = new ParkingManagerServiceImpl(new ParkingManagerRepositoryImpl(),
                new ParkingBoyConfigRepositoryImpl(), new FindParkingLotService());
        parkingBoyService = new ParkingBoyServiceImpl(new ParkingBoyConfigRepositoryImpl(),
                new FindParkingLotService());
    }

    @Test
    public void askManagerToParkCar() {
        Ticket ticket = parkingManagerService.parkingCar(managerId, car);
        System.out.print(ticket.toString());
    }

    @Test
    public void askManagerToGetAvailableParkingLot() {
        ParkingLot availableParkingLot = parkingManagerService.getAvailableParkingLot(managerId);
        System.out.print(availableParkingLot);
    }

    @Test
    public void askParkingBoyToParkCar() {
        Ticket ticket = parkingBoyService.parkingCar(parkingBoyId, car);
        System.out.print(ticket.toString());
    }
}
