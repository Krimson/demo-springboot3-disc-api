package com.example.demo.persistence.repository;

import com.example.demo.persistence.entity.DiscEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Repository
public interface DiscRepository extends JpaRepository<DiscEntity, Long>{
    @Query("SELECT d FROM DiscEntity d WHERE d.brand = ?1")
    List<DiscEntity> getDiscsByBrand(String brand);

}
