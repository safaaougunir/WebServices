package com.test.demo.DAO;

import com.test.demo.Models.Building;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BuildingDao extends JpaRepository<Building, Long> {
}

