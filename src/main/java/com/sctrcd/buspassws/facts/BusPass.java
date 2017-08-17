package com.sctrcd.buspassws.facts;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class BusPass {

    private Person person;

    public BusPass(Person person) {
        this.person = person;
    }

    public String getBusPassType() {
        return this.getClass().getSimpleName();
    }
    
}