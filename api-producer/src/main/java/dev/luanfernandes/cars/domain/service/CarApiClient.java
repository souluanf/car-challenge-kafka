package dev.luanfernandes.cars.domain.service;//package br.com.hinc.extractor.client.client;


import dev.luanfernandes.cars.domain.dto.CarDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;


@FeignClient(name = "car-api", url = "${api.client.url}")
public interface CarApiClient {
    @GetMapping(value = "/")
    List<CarDto> getAll();

    @GetMapping(value = "/{id}")
    CarDto getById(@PathVariable String id);

    @DeleteMapping(value = "/{id}")
    CarDto delete(@PathVariable String id);
}