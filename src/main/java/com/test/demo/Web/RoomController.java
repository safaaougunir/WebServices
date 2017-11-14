package com.test.demo.Web;

<<<<<<< HEAD
import com.test.demo.DAO.LightDao;
import com.test.demo.DAO.*;
import com.test.demo.DAO.RoomDaoCustom;
import com.test.demo.Models.Light;
import com.test.demo.Models.Room;
import com.test.demo.Models.Status;
=======
import com.test.demo.DAO.RoomDao;
import com.test.demo.Models.Room;
>>>>>>> 3586408b27708840d7aef8fd0df388c5931a2724
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@Transactional
public class RoomController {

    private final RoomDao roomDao;
    private final RoomDaoCustom roomDaocustum;


    public RoomController(RoomDao roomDao,RoomDaoCustom roomDaocustum) {
        this.roomDao = roomDao;
        this.roomDaocustum=roomDaocustum;

    }

    @RequestMapping(value = "/api/rooms")
    public List<RoomDto> list() {
        return roomDao.findAll().stream().map(RoomDto::new).collect(Collectors.toList());
    }

<<<<<<< HEAD
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

=======
    @GetMapping(value = "/api/rooms/{id}")
    @ResponseBody
    public RoomDto getRoomByID(@PathVariable Long id) {
        return new RoomDto(roomDao.getOne(id));
>>>>>>> 3586408b27708840d7aef8fd0df388c5931a2724
    }

}