package com.example.demo.service;

import com.example.demo.controller.dto.DiscDTO;
import com.example.demo.persistence.entity.DiscEntity;

import java.util.List;

public interface DiscService {
    List<DiscDTO> getAllDiscs();
    List<DiscDTO> getDiscsByBrand(String brand);
}
