package com.emse.spring.faircorp.model;

import javax.persistence.*;

@Entity // (1).
@Table(name = "Window") // (2).
public class Window {
    @Id
    @GeneratedValue
    private Long id;
    //Master
    @OneToOne(mappedBy = "window")
    private Room room;

    @Column(nullable = false)// (4)
    private String name;

    @Enumerated(EnumType.STRING)// (5)
    private WindowStatus windowStatus;

    public Window() {
    }

    public Window(String name, WindowStatus status,Room room) {
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
}
