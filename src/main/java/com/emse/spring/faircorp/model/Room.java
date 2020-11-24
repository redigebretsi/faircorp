package com.emse.spring.faircorp.model;

import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToOne;

public class Room {
    @Id
    @GeneratedValue
    private Long id;
   //slave
    @OneToOne()
    private Window window;

    @Column(nullable = false)
    private int floor;

    @Column(nullable = false)
    private String name;

    @Column
    private Double current_temprature;

    @Column
    private Double target_temprature;
    public Room(){

    }
    public Room(int floor,String name){
        this.floor=floor;
        this.name=name;
            }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCurrent_temprature() {
        return current_temprature;
    }

    public void setCurrent_temprature(Double current_temprature) {
        this.current_temprature = current_temprature;
    }

    public Double getTarget_temprature() {
        return target_temprature;
    }

    public void setTarget_temprature(Double target_temprature) {
        this.target_temprature = target_temprature;
    }
}
