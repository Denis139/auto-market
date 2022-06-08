package com.gavrish.automarket.repository;

import com.gavrish.automarket.model.entity.Wheel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface WheelRepository extends JpaRepository<Wheel, UUID>{
}
