package com.sctrcd.buspassws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sctrcd.buspassws.facts.BusPass;
import com.sctrcd.buspassws.facts.Person;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class BusPassController {

    @Autowired
    private BusPassService busPassService;

    @GetMapping("/buspass")
    public BusPass getQuestions(
            @RequestParam(required = true) String name,
            @RequestParam(required = true) int age) {

        Person person = new Person(name, age);
        log.info("Bus pass request received for: " + person);
        return busPassService.getBusPass(person);
    }

}