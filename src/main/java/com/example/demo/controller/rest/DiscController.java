package com.example.demo.controller.rest;


import com.example.demo.controller.dto.DiscDTO;
import com.example.demo.service.DiscService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// http://localhost:8080/swagger-ui/index.html
@RestController
@RequestMapping("disc-api")
public class DiscController {

    @Autowired
    @Qualifier("discV1Service")
    DiscService discService;

    @PostConstruct
    void init() {
        System.out.println("DiscController has been registered.");
    }
    @GetMapping("echo")
    public String echoController() {
        return "Endpoint OK";
    }

    @GetMapping("get-discs-by-brand/{brand}")
    public List<DiscDTO> getDiscsByBrand(@PathVariable String brand) {
        return discService.getDiscsByBrand(brand);
        //return List.of(new DiscDTO("Innova", "Destroyer", 12, 5, -1, 3));
    }

    @GetMapping("get-all-discs")
    public List<DiscDTO> getAllDiscs() {
        return discService.getAllDiscs();
    }


}
