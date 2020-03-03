package com.tw.ddd.domain;

import com.tw.ddd.valueobject.Car;
import com.tw.ddd.valueobject.Ticket;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class ParkingLot {
    private AtomicInteger capacity;
    private Map<Ticket, Car> parkedCars = new HashMap<Ticket, Car>() ;

    public ParkingLot(AtomicInteger capacity) {
        this.capacity = capacity;
    }


    public Ticket park(Car car) {
        if (capacity.decrementAndGet() >= 0) {
            Ticket ticket = new Ticket();
            parkedCars.put(ticket, car);
            return ticket;
        }
        return null;
    }

    public Car take(Ticket ticket) {
        if (ticket.validate()) {
            return parkedCars.get(parkedCars.keySet().stream()
                    .filter(ticketOne -> ticketOne.equals(ticket))
                    .findFirst()
                    .get());
        }
        return null;
    }
}
