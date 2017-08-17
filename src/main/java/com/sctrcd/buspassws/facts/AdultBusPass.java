package com.sctrcd.buspassws.facts;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode(callSuper=true)
public class AdultBusPass extends BusPass {

    public AdultBusPass(Person person) {
        super(person);
    }
    
}