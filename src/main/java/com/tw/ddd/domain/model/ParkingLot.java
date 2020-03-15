package com.tw.ddd.domain.model;

import com.tw.ddd.domain.valueobject.Car;
import com.tw.ddd.domain.valueobject.Ticket;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class ParkingLot {
    UUID id;
    private AtomicInteger capacity;
    private Map<Ticket, Car> parkedCars = new HashMap<Ticket, Car>();

    public ParkingLot(AtomicInteger capacity) {
        this.capacity = capacity;
    }

    public boolean hasSpace() {
        return capacity.get() > 0;
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
                    .orElse(null));
        }
        return null;
    }

    public int getCapacity() {
        return capacity.get();
    }
}
