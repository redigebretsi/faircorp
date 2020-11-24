package com.emse.spring.faircorp.model;

import javax.persistence.*;

public class Heater {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Long power;

    @Column(nullable = false)
    private String room;

    @Enumerated(EnumType.STRING)
    private HeaterStatus status;

    public Heater(){

    }
    public Heater(String name,Long power,String room,HeaterStatus status){
        this.name=name;
        this.power=power;
        this.room=room;
        this.status=status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPower() {
        return power;
    }

    public void setPower(Long power) {
        this.power = power;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public HeaterStatus getStatus() {
        return status;
    }

    public void setStatus(HeaterStatus status) {
        this.status = status;
    }
}
