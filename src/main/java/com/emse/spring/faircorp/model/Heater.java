package com.emse.spring.faircorp.model;

import javax.persistence.*;

//Slave
@Entity
@Table(name="Heater")
public class Heater {

    @Id
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private Long power;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private HeaterStatus heaterStatus;

    @ManyToOne
    private Room room;

    public Heater(){

    }
    public Heater(String name, Room room){
        this.name = name;
        this.room = room;
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

    public HeaterStatus getHeaterStatus() {
        return heaterStatus;
    }

    public void setHeaterStatus(HeaterStatus heaterStatus) {
        this.heaterStatus = heaterStatus;
    }
}


