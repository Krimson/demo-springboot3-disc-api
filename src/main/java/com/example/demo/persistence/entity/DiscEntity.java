package com.example.demo.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "discs")
public class DiscEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private String name;
    private int speed;
    private int glide;
    private int stability;
    private int fade;

    public DiscEntity() {}

    public DiscEntity(String brand, String name, int speed, int glide, int stability, int fade) {
        this.brand = brand;
        this.name = name;
        this.speed = speed;
        this.glide = glide;
        this.stability = stability;
        this.fade = fade;
    }

    public String getBrand() {
        return this.brand;
    }
    public String getName() {
        return this.name;
    }

    public int getSpeed() {
        return this.speed;
    }

    public int getGlide() { return this.glide; }

    public int getStability() {
        return this.stability;
    }

    public int getFade() {
        return this.fade;
    }

}
