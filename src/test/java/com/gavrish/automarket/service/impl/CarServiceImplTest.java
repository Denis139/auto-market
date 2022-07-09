package com.gavrish.automarket.service.impl;

import com.gavrish.automarket.mapper.impl.CarMapperImpl;
import com.gavrish.automarket.model.entity.*;
import com.gavrish.automarket.repository.CarRepository;
import com.gavrish.automarket.repository.EngineRepository;
import com.gavrish.automarket.repository.FactoryRepository;
import com.gavrish.automarket.repository.ModelRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CarServiceImplTest {

    @InjectMocks
    private CarServiceImpl carService;

    @Mock
    private CarRepository carRepository;

    @Mock
    private ModelRepository modelRepository;

    @Mock
    private FactoryRepository factoryRepository;

    @Mock
    private EngineRepository engineRepository;

    @BeforeEach
    void init() {
        var carMapper = new CarMapperImpl();
        carService = new CarServiceImpl(carRepository, modelRepository, factoryRepository, engineRepository, carMapper);
    }

    @Test
    void testGetAllByParams() {
        when(modelRepository.findByName(anyString())).thenReturn(new Model());
        when(carRepository.findAllByBrandAndModel(any(), any())).thenReturn(cars());

        var result = carService.getAllByParams(Brand.VOLKSWAGEN,
                "Tiguan",
                2017,
                2020,
                EngineTypeEnum.GASOLINE,
                null,
                null,
                null,
                null,
                TransmissionTypeEnum.ROBOT);
        assertNotNull(result);
        assertEquals(1, result.size());            // указана размерность массива

        verify(modelRepository).findByName(anyString());
        verifyNoMoreInteractions(modelRepository);
        verify(carRepository).findAllByBrandAndModel(any(), any());
        verifyNoMoreInteractions(carRepository);
    }

    private List<Car> cars() {
        return List.of(
                new Car()
                        .setYearOfIssue(2017)
                        .setModel(new Model()
                                .setEngine(new Engine()
                                        .setPower(105)
                                        .setVolume(6.0)
                                        .setEngineType(EngineTypeEnum.GASOLINE))
                                .setTransmission(new Transmission()
                                        .setTransmissionType(TransmissionTypeEnum.ROBOT))),
                new Car()
                        .setYearOfIssue(2019)
                        .setModel(new Model()
                                .setEngine(new Engine()
                                        .setPower(190)
                                        .setVolume(2.0)
                                        .setEngineType(EngineTypeEnum.DIESEL))
                                .setTransmission(new Transmission()
                                        .setTransmissionType(TransmissionTypeEnum.AUTOMATIC))),
                new Car()
                        .setYearOfIssue(2022)
                        .setModel(new Model()
                                .setEngine(new Engine()
                                        .setPower(520)
                                        .setVolume(1.2)
                                        .setEngineType(EngineTypeEnum.GASOLINE))
                                .setTransmission(new Transmission()
                                        .setTransmissionType(TransmissionTypeEnum.CVT))));

    }

    @Test
    void testGetAllByCarParams() {
        when(factoryRepository.findByFactoryName(anyString())).thenReturn(factory());
        var result = carService.getAllByCarParams("Germany Factory");
        assertEquals(5, result.size());
    }

    private Factory factory() {
        return new Factory()
                .setModelFactories(List.of(
                        new ModelFactory()
                                .setModel(new Model()
                                        .setCars(List.of(
                                                new Car().setModel(new Model()),
                                                new Car().setModel(new Model())))),
                        new ModelFactory()
                                .setModel(new Model()
                                        .setCars(List.of(
                                                new Car().setModel(new Model())))),
                        new ModelFactory()
                                .setModel(new Model()
                                        .setCars(List.of(
                                                new Car().setModel(new Model()),
                                                new Car().setModel(new Model()))))));
    }

    @Test
    void getAllByEngineParams() {

        when(engineRepository.findByName(anyString())).thenReturn(engine());
        var result = carService.getAllByEngineParams("Engine");
        assertNotNull(result);

    }

    private Engine engine() {
        return new Engine()
                .setModels(List.of(
                        new Model()
                                .setCars(List.of(
                                        new Car().setModel(new Model()))),
                        new Model()
                                .setCars(List.of(
                                        new Car().setModel(new Model()),
                                        new Car().setModel(new Model()))),
                        new Model()
                                .setCars(List.of(
                                        new Car().setModel(new Model()),
                                        new Car().setModel(new Model()),
                                        new Car().setModel(new Model())))));
    }
}