package com.test.demo.Web;

import com.test.demo.DAO.LightDao;
import com.test.demo.DAO.*;
import com.test.demo.DAO.RoomDaoCustom;
import com.test.demo.Models.*;
import com.test.demo.Models.Light;
import com.test.demo.Models.Status;

import com.test.demo.DAO.RoomDao;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@Transactional
public class RoomController {

    private final RoomDao roomDao;


    public RoomController(RoomDao roomDao) {
        this.roomDao = roomDao;

    }

    @GetMapping(value = "/api/rooms")
    public List<RoomDto> list() {
        return roomDao.findAll().stream().map(RoomDto::new).collect(Collectors.toList());
    }

    @PostMapping(value = "/api/rooms/{id}/switch-light")
    public RoomDto switchLight(@PathVariable Long id) {
        Light light = roomDao.getOne(id).getLight();
        if (light.getStatus() == Status.ON) {
            light.setStatus(Status.OFF);
        } else {
            light.setStatus(Status.ON);

        }

        return getRoomByID(id);
    }

    @PostMapping(value = "/api/rooms/{id}/switch-noise")
    public RoomDto switchNoise(@PathVariable Long id) {
        Noise noise = roomDao.getOne(id).getNoise();
        if (noise.getStatus() == Status.ON) {
            noise.setStatus(Status.OFF);
        } else {
            noise.setStatus(Status.ON);

        }
        return getRoomByID(id);
    }

    @GetMapping(value = "/api/rooms/{id}")
    @ResponseBody
    public RoomDto getRoomByID(@PathVariable Long id) {
        return new RoomDto(roomDao.getOne(id));
    }


    @GetMapping(value = "/api/rooms/list_with_on_lights")
    public List<RoomDto> listWithOnLight() {
        return roomDao.findRoomsWithOnLight().stream().map(RoomDto::new).collect(Collectors.toList());
    }

}
