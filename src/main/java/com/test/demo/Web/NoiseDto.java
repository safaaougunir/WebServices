package com.test.demo.Web;


import com.test.demo.Models.Noise;
import com.test.demo.Models.Status;

public class NoiseDto {

    private final Long id;
    private final Integer level;
    private final Status status;

    public NoiseDto(Noise noise) {
        this.id = noise.getId();
        this.level = noise.getLevel();
        this.status = noise.getStatus();
    }

    public Long getId() {
        return id;
    }

    public Integer getLevel() {
        return level;
    }

    public Status getStatus() {
        return status;
    }
}
