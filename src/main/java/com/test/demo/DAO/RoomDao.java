package com.test.demo.DAO;

import com.test.demo.Models.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomDao extends JpaRepository<Room, Long> {
}