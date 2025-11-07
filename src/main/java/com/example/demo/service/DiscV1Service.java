package com.example.demo.service;

import com.example.demo.controller.dto.DiscDTO;
import com.example.demo.persistence.entity.DiscEntity;
import com.example.demo.persistence.repository.DiscRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("discV1Service")
public class DiscV1Service implements DiscService {
    @Autowired
    DiscRepository discRepository;

    public List<DiscDTO> getDiscsByBrand(String brand) {
        List<DiscDTO> discDTOS = new ArrayList<>();

        for(DiscEntity entity : discRepository.getDiscsByBrand(brand)) {
            discDTOS.add(mapDiscFromRepo(entity));
        }

        return discDTOS;
    }

    public List<DiscDTO> getAllDiscs() {
        List<DiscDTO> discDTOS = new ArrayList<>();

        for(DiscEntity entity : discRepository.findAll()) {
            discDTOS.add(mapDiscFromRepo(entity));
        }
        return discDTOS;
    }
    private DiscDTO mapDiscFromRepo(DiscEntity discEntity) {
        return new DiscDTO(discEntity.getBrand(),discEntity.getName(), discEntity.getSpeed(), discEntity.getGlide(), discEntity.getStability(),discEntity.getFade());
    }
}
