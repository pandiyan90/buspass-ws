package com.sctrcd.buspassws.facts;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
@AllArgsConstructor
public class Person {

    private String name;
    private int age;

}
