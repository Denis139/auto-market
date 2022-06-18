package com.gavrish.automarket.repository;

import com.gavrish.automarket.model.entity.Engine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface EngineRepository extends JpaRepository<Engine, UUID> {

    boolean existsByName(String name);
}
