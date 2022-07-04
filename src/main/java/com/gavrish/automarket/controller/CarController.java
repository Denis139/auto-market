package com.gavrish.automarket.controller;

import com.gavrish.automarket.model.dto.request.CarAddRequest;
import com.gavrish.automarket.model.dto.request.CarUpdateRequest;
import com.gavrish.automarket.model.dto.view.CarView;
import com.gavrish.automarket.model.entity.Brand;
import com.gavrish.automarket.model.entity.EngineTypeEnum;
import com.gavrish.automarket.model.entity.TransmissionTypeEnum;
import com.gavrish.automarket.service.CarService.CarServiceImpl.CarServiceImpl;
import com.gavrish.automarket.service.domain.CarDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
import static com.gavrish.automarket.util.Constant.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
public class CarController {

    private final CarDomainService carDomainService;

    private final CarServiceImpl carService;

    @PostMapping(value = ADD_CAR, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public UUID add (@RequestBody @Valid CarAddRequest request) {
        return carDomainService.add(request);
    }

    @GetMapping(value = GET_CAR)
    public CarView get(@PathVariable UUID id) {
        return carDomainService.get(id);
    }
    @GetMapping(value = GET_ALL_CAR)
    public List<CarView> getAll() {
        return carDomainService.getAll();
    }
    @PatchMapping(value = UPDATE_CAR, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public CarView update(@PathVariable UUID id, @RequestBody @Valid CarUpdateRequest request) {
        return carDomainService.update(id, request);
    }
    @DeleteMapping(value = DELETE_CAR)
    public Boolean delete(@PathVariable UUID id) {
        return carDomainService.delete(id);
    }

    @GetMapping(value = GET_ALL_CAR_BY_PARAMS)
    public List<CarView> getAllByParams(@RequestParam(value = "brand") Brand brand,
                                        @RequestParam(value = "modelName") String modelName,
                                        @RequestParam(value = "yearOfIssueMin", required = false) Integer yearOfIssueMin,
                                        @RequestParam(value = "yearOfIssueMax", required = false) Integer yearOfIssueMax,
                                        @RequestParam(value = "engineType", required = false) EngineTypeEnum engineType,
                                        @RequestParam(value = "enginePowerMin", required = false) Integer enginePowerMin,
                                        @RequestParam(value = "enginePowerMax", required = false) Integer enginePowerMax,
                                        @RequestParam(value = "engineVolumeMin", required = false) Double engineVolumeMin,
                                        @RequestParam(value = "engineVolumeMax", required = false) Double engineVolumeMax,
                                        @RequestParam(value = "transmissionType", required = false) TransmissionTypeEnum transmissionType) {
        return carService.getAllByParams(brand, modelName, yearOfIssueMin, yearOfIssueMax, engineType, enginePowerMin,
                                         enginePowerMax, engineVolumeMin, engineVolumeMax, transmissionType);
    }
}

