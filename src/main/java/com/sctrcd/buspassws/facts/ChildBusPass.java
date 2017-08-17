package com.sctrcd.buspassws.facts;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode(callSuper=true)
public class ChildBusPass extends BusPass {

    public ChildBusPass(Person person) {
        super(person);
    }

}