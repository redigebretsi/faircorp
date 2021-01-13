package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Heater;
import com.emse.spring.faircorp.model.Room;
import com.emse.spring.faircorp.model.Window;

import java.util.List;

public interface RoomDaoCustom {
    List<Room> findName(String name);
    List<Heater> findRoomHeaters(Long id);
    List<Window> findRoomWindows(Long id);
}
