package com.in28minutes.rest.webservices.restfulwebservices.controllers;

import com.in28minutes.rest.webservices.restfulwebservices.beans.HelloWorldBean;
import org.apache.logging.log4j.message.StringFormattedMessage;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {
    @RequestMapping(path = "/hello-world",method = RequestMethod.GET)
    public String helloWorld(){
        return "Hello World";
    }

    @RequestMapping(path = "/hello-world-bean",method = RequestMethod.GET)
    public HelloWorldBean helloWorldbean(){
        return new HelloWorldBean("Hello world message");
    }

    @GetMapping(path = "/hello-world/{name}")
    public HelloWorldBean helloWorldPath(@PathVariable String name){
        return new HelloWorldBean(String.format("Hello , %s",name));
    }
}
