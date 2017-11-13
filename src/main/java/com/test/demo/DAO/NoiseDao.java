package com.test.demo.DAO;

import com.test.demo.Models.Noise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoiseDao extends JpaRepository<Noise, Long> {
}