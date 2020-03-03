package com.tw.ddd.valueobject;

public class Ticket {
    private boolean validFlag = true;

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
                '}';
    }
}
