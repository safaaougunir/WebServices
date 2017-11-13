package com.test.demo.Web;

import com.test.demo.Models.*;

public class RoomDto {

    private final Long id;
    private final Light Light;
    private final Noise Noise;

    public RoomDto(Room room) {
        this.id = room.getId();
        this.Light = room.getLevel();
        this.Noise = room.getStatus();
    }

    public Long getId() {
        return id;
    }

    public Light getLevel() {
        return Light;
    }

    public Noise getStatus() {
        return Noise;
    }
}