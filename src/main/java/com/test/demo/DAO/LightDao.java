package com.test.demo.DAO;


import com.test.demo.Models.Light;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LightDao extends JpaRepository<Light, Long> , LightDaoCustom{
}