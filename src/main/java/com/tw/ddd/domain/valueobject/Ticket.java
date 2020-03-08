package com.tw.ddd.domain.valueobject;

import java.util.UUID;

public class Ticket {
    private boolean validFlag = true;
    private String number = UUID.randomUUID().toString();

    public Ticket() {
    }

    public Boolean validate() {
        return validFlag;
    }

    public void invalidTicket() {
        this.validFlag = false;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "validFlag=" + validFlag +
                ", number='" + number + '\'' +
                '}';
    }
}
