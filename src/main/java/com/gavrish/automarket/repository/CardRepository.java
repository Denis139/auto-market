package com.gavrish.automarket.repository;

import com.gavrish.automarket.model.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CardRepository extends JpaRepository<Card, UUID> {
}
