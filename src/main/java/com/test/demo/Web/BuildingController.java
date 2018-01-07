package com.test.demo.Web;


import com.test.demo.DAO.BuildingDao;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@Transactional
public class BuildingController {

    private final BuildingDao buildingDao;


    public BuildingController(BuildingDao buildingDao) {
        this.buildingDao = buildingDao;

    }

    @GetMapping(value = "/api/buildings")
    public List<BuildingDto> list() {
        return buildingDao.findAll().stream().map(BuildingDto::new).collect(Collectors.toList());
    }

}
