package com.gavrish.automarket.repository;

import com.gavrish.automarket.model.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ModelRepository extends JpaRepository<Model, UUID> {

    Model findByName(String name);

    Optional<Model> findById(UUID uuid);
}
