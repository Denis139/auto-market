package com.gavrish.automarket.repository;

import com.gavrish.automarket.model.entity.Brand;
import com.gavrish.automarket.model.entity.Car;
import com.gavrish.automarket.model.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CarRepository extends JpaRepository<Car, UUID> {

    List<Car> findAllByBrandAndModel(Brand brand, Model model);
}
