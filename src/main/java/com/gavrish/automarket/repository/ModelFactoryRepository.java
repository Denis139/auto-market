package com.gavrish.automarket.repository;

import com.gavrish.automarket.model.entity.Car;
import com.gavrish.automarket.model.entity.Factory;
import com.gavrish.automarket.model.entity.ModelFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ModelFactoryRepository extends JpaRepository<ModelFactory, UUID> {

    List<ModelFactory> findAllByFactory(Factory factory);

}
