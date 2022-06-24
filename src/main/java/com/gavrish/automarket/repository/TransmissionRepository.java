package com.gavrish.automarket.repository;

import com.gavrish.automarket.model.entity.Transmission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface TransmissionRepository extends JpaRepository<Transmission, UUID> {
}
