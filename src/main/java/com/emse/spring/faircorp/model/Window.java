package com.emse.spring.faircorp.model;

import javax.persistence.*;

@Entity
@Table(name = "RWINDOW")
public class Window {
    @Id// (3)
    @GeneratedValue
    private Long id;

    @Column(nullable = false)// (4)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private WindowStatus windowStatus;

    @ManyToOne(optional = false)
    private Room room;

    public Window() {
    }

    public Window(Room room, String name, WindowStatus status) {
        this.windowStatus = status;
        this.name = name;
        this.room = room;
    }

    public Long getId() {
        return this.id;
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

    public WindowStatus getWindowStatus() {
        return windowStatus;
    }

    public void setWindowStatus(WindowStatus windowStatus) {
        this.windowStatus = windowStatus;
    }

    public Room getRoom() {
        return room;
    }
}