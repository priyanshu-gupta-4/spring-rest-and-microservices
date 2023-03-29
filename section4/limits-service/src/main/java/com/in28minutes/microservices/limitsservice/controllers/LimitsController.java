package com.in28minutes.microservices.limitsservice.controllers;

import com.in28minutes.microservices.limitsservice.beans.Limits;
import com.in28minutes.microservices.limitsservice.configuration.ConfigProps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsController {
    @Autowired
    ConfigProps configProps;
    @GetMapping(path = "/limits")
    public Limits getLimits(){
        return new Limits(configProps.getMinimum(),configProps.getMaximum());
    }
}
