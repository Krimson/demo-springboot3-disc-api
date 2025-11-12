package com.example.demo.service;

import com.example.demo.controller.dto.DiscDTO;
import com.example.demo.controller.dto.DiscraftDiscDTO;
import org.junit.jupiter.api.Test;

public class DiscV1ServiceTest {
    DiscV1Service discV1Service =  new DiscV1Service();

    @Test
    public void printDiscTest() {
        discV1Service.printDisc(createDiscDTO());
        discV1Service.getDiscType(createDiscDTO());

        discV1Service.printDisc(createDiscraftDiscDTO());
        discV1Service.getDiscType(createDiscraftDiscDTO());
    }

    private DiscDTO createDiscDTO() {
        return new DiscDTO("Innova", "Halo Star Destroyer", 12, 5, -1, 3);
    }

    private DiscraftDiscDTO createDiscraftDiscDTO() {
        return new DiscraftDiscDTO("Discraft", "SP Scorch", 11, 6, -2, 2, 0.5F);
    }
}
