
package com.test.demo.Models;
import com.test.demo.Models.Room;

import javax.persistence.*;
import java.util.List;

@Entity

public class Building {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;


    /**
     * The Rooms of a Building
     */
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Room> rooms;


    @SuppressWarnings("unused")
    public Building() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Room> getRooms() { return rooms;}

    public void setRooms(List<Room> room) {
        this.rooms = room;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
