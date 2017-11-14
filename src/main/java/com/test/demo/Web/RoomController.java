package com.test.demo.Web;

import com.test.demo.DAO.LightDao;
import com.test.demo.DAO.*;
import com.test.demo.DAO.RoomDaoCustom;
import com.test.demo.Models.Light;
import com.test.demo.Models.Room;
import com.test.demo.Models.Status;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/rooms")
@Transactional
public class RoomController {

    private final RoomDao roomDao;
    private final RoomDaoCustom roomDaocustum;


    public RoomController(RoomDao roomDao,RoomDaoCustom roomDaocustum) {
        this.roomDao = roomDao;
        this.roomDaocustum=roomDaocustum;

    }

    @GetMapping
    public List<RoomDto> list() {
        return roomDao.findAll().stream().map(RoomDto::new).collect(Collectors.toList());
    }

    @PostMapping(value = "/api/rooms/{id}/switch-light")
    public RoomDto switchLight(@PathVariable Long roomId) {
        Light light = roomDao.getOne(roomId).getLight();
        if (light.getStatus()==Status.ON) {
            light.setStatus(Status.OFF);
        }
            else {
            light.setStatus(Status.ON);

        }
        return getRoomByID(roomId);

    }

}