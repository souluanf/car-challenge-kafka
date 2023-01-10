package dev.luanfernandes.cars.api.v1.controller;



import dev.luanfernandes.cars.api.v1.openapi.CarControllerOpenApi;
import dev.luanfernandes.cars.domain.dto.CarDto;
import dev.luanfernandes.cars.domain.service.CarApiClient;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping(value = "/api/v1/cars", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CarController implements CarControllerOpenApi {
    private final CarApiClient carApiClient;

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    @Override
    public List<CarDto> getAll() {
        return carApiClient.getAll();
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    @Override
    public CarDto getById(@PathVariable String id) {
        return carApiClient.getById(id);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Override
    public void delete(@PathVariable String id) {
        carApiClient.delete(id);
    }

//    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseStatus(value = HttpStatus.CREATED)
//    @Override
//    public CarResponse createCar(@RequestBody CarRequest carRequest) {
//        return clientService.create(carRequest);
//    }
}