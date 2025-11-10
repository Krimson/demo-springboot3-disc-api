package com.example.demo.controller.rest;

import com.example.demo.controller.dto.DiscDTO;
import com.example.demo.service.DiscService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DiscControllerTest {
    DiscController discController = new DiscController();

    @Mock
    DiscService discService;

    @BeforeAll
    public void setup() {
        MockitoAnnotations.openMocks(this);
        discController.discService = discService;
    }

    @Test
    public void echoControllerTest() {
        String expectedResponse = "Endpoint OK";
        String response = discController.echoController();
        Assertions.assertEquals(expectedResponse, response);
    }

    @Test
    public void getDiscsByBrandTest() {
        DiscDTO destroyer = new DiscDTO("Innova", "Halo Star Destroyer", 12, 5, -1, 3);
        Mockito.when(discService.getDiscsByBrand("Innova")).thenReturn(List.of(destroyer));
        //Mockito.when(discService.getDiscsByBrand("incorrect")).thenReturn(new ArrayList<>());

        Assertions.assertEquals(List.of(destroyer), discController.getDiscsByBrand("Innova"));
        Assertions.assertEquals(new ArrayList<>(), discController.getDiscsByBrand("incorrect"));
    }
}
