package com.emse.spring.faircorp.controller;


import com.emse.spring.faircorp.dao.BuildingDao;
import com.emse.spring.faircorp.dao.HeaterDao;
import com.emse.spring.faircorp.dao.RoomDao;
import com.emse.spring.faircorp.dao.WindowDao;
import com.emse.spring.faircorp.dto.HeaterDto;
import com.emse.spring.faircorp.dto.RoomDto;
import com.emse.spring.faircorp.dto.WindowDto;
import com.emse.spring.faircorp.model.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController // (1)
@RequestMapping("/api/rooms") // (2)
@Transactional // (3)
public class RoomController {

    private final RoomDao roomDao;
    private final HeaterDao heaterDao;
    private final WindowDao windowDao;
    private final BuildingDao buildingDao;

    public RoomController(HeaterDao heaterDao, WindowDao windowDao, BuildingDao buildingDao,RoomDao roomDao) {
        this.buildingDao = buildingDao;
        this.heaterDao = heaterDao;
        this.windowDao = windowDao;
        this.roomDao = roomDao;

    }

    @GetMapping
    public List<RoomDto> findAll() {
        return roomDao.findAll().stream().map(RoomDto::new).collect(Collectors.toList());
    }

    @PostMapping
    public RoomDto create(@RequestBody RoomDto dto) {
        Building building = buildingDao.getOne(dto.getBuildingId());
        Room room = null;
        if (dto.getId()==null) {
            room = new Room(dto.getFloor(),dto.getName(),dto.getCurrent_temperature(),dto.getTarget_temperature(), building);
            roomDao.save(room);
        }
        else {
            room = roomDao.getOne(dto.getId());
        }
        return new RoomDto(room);
    }

    @GetMapping(path = "/{id}")
    public RoomDto findById(@PathVariable Long id) {
        return roomDao.findById(id).map(RoomDto::new).orElse(null);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        windowDao.deleteWindowInARoom(id);
        roomDao.deleteById(id);
    }

    @GetMapping(path="/{id}/switchWindows")
    public void switchWindowsStatus(@PathVariable Long id) {
        List<Window> windows = windowDao.findWindowsInARoom(id);
        windows.stream().forEach(window -> window.setWindowStatus(window.getWindowStatus() == WindowStatus.OPEN ? WindowStatus.CLOSED: WindowStatus.OPEN));
    }

    @GetMapping(path="/{id}/switchHeaters")
    public void switchHeatersStatus(@PathVariable Long id) {
        }

    @GetMapping(path="/{id}/heaters")
    public List<HeaterDto> findAllHeaters(@PathVariable Long id) {
        List<Heater> heaters = roomDao.findRoomHeaters(id);
        return heaters.stream().map(HeaterDto::new).collect(Collectors.toList());
    }

    @GetMapping(path="/{id}/windows")
    public List<WindowDto> findAllWindows(@PathVariable Long id) {
        List<Window> windows = roomDao.findRoomWindows(id);
        return windows.stream().map(WindowDto::new).collect(Collectors.toList());
    }

}
