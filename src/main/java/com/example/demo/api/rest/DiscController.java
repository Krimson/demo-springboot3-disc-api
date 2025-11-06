package com.example.demo.api.rest;


import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// http://localhost:8080/swagger-ui/index.html
@RestController
@RequestMapping("disc-api")
public class DiscController {

    @PostConstruct
    void init() {
        System.out.println("DiscController has been registered.");
    }
    @GetMapping("echo")
    public String echoController() {
        return "Endpoint OK";
    }


}
