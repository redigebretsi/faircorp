package com.emse.spring.faircorp.model;


import javax.persistence.*;
import java.util.Set;

//Master
@Entity
@Table(name = "ROOM")
public class Room {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "Floor",nullable = false)
    private Integer floor;

    @Column(nullable = false)
    private String name;

    @Column(name = "Current_Temperature")
    private Double currentTemperature;

    @Column(name = "target_Temperature")
    private Double targetTemperature;


    @OneToMany(mappedBy = "room")
    private Set<Window> window;

    @OneToMany(mappedBy = "room")
    private Set<Heater> heater;

    @ManyToOne(optional = false)
    private Building building;


    public Room() {

    }

    public Room(Integer floor, String name) {
        this.floor = floor;
        this.name = name;
    }
    public Room(int floor, String name, Double current_temperature, Double target_temperature, Building building) {
        this.floor = floor;
        this.name = name;
        this.currentTemperature = current_temperature;
        this.targetTemperature = target_temperature;
        this.building = building;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCurrentTemperature() {
        return currentTemperature;
    }

    public void setCurrentTemperature(Double currentTemperature) {
        this.currentTemperature = currentTemperature;
    }

    public Double getTargetTemperature() {
        return targetTemperature;
    }

    public void setTargetTemperature(Double targetTemperature) {
        this.targetTemperature = targetTemperature;
    }
    public Building getBuilding() { return building; }

    public void setBuilding(Building building) { this.building=building; }
}


