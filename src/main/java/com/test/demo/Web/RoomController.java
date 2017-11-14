package com.test.demo.Web;

import com.test.demo.DAO.RoomDao;
import com.test.demo.Models.Room;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@Transactional
public class RoomController {

    private final RoomDao roomDao;


    public RoomController(RoomDao roomDao) {
        this.roomDao = roomDao;
    }

    @RequestMapping(value = "/api/rooms")
    public List<RoomDto> list() {
        return roomDao.findAll().stream().map(RoomDto::new).collect(Collectors.toList());
    }

    @GetMapping(value = "/api/rooms/{id}")
    @ResponseBody
    public RoomDto getRoomByID(@PathVariable Long id) {
        return new RoomDto(roomDao.getOne(id));
    }

}