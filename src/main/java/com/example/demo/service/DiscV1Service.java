package com.example.demo.service;

import com.example.demo.controller.dto.DiscDTO;
import com.example.demo.controller.dto.DiscraftDiscDTO;
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

    public void printDisc(Object object) {
        if(object instanceof DiscDTO) {
            System.out.println("It's a DiscDTO.");
        }
        else if(object instanceof DiscraftDiscDTO) { // Legacy Discraft discs has a 5th flight number which is their own stability rating
            System.out.println("It's a DiscraftDiscDTO.");
        }
    }

    public String getDiscType(Object object) {
        return switch(object) {
            case DiscDTO(String brand, String name, int speed, int glide, int stability, int fade) -> STR."Disc \{name} is a DiscDTO";
            case DiscraftDiscDTO(String brand, String name, int speed, int glide, int stability, int fade, float stabilityRating) -> STR."Disc \{name} is a DiscraftDiscDTO";
            default -> "Unknown Disc";
        };
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
