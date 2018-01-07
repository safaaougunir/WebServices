package com.test.demo.Web;

import com.test.demo.Models.*;

import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BuildingDto {

    private final Long id;
    private final String name;
    private final Set<RoomDto> rooms;
    public final int nb;
    public final int nbOnlight;
    public final int nbOnRinger;



    public BuildingDto(Building building) {
        this.id = building.getId();
        this.name = building.getName();
        this.rooms = building.getRooms().stream().map(room -> (room == null) ? null : new RoomDto(room)).collect(Collectors.toSet());
        this.nb=building.getRooms().size();
        this.nbOnlight=building.getRooms().stream().filter(p -> (p.getLight().getStatus())==Status.ON).collect(Collectors.toList()).size();
        this.nbOnRinger=building.getRooms().stream().filter(p -> (p.getNoise().getStatus())==Status.ON).collect(Collectors.toList()).size();

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<RoomDto> getRooms() {
        return rooms;
    }
}
