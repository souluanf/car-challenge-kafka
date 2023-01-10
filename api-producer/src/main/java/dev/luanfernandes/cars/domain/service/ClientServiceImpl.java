//package dev.luanfernandes.cars.infrastructure.implementation;
//
//
//import com.fasterxml.jackson.core.type.TypeReference;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import dev.luanfernandes.cars.domain.dto.CarDto;
//import dev.luanfernandes.cars.domain.service.ClientService;
//import dev.luanfernandes.cars.domain.service.LogService;
//import lombok.AllArgsConstructor;
//import lombok.SneakyThrows;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.Collections;
//import java.util.List;
//
//@Slf4j
//@Service
//@AllArgsConstructor(onConstructor = @__(@Autowired))
//public class ClientServiceImpl implements ClientService {
//    private final RestTemplate restTemplate;
//    private final ObjectMapper mapper;
//    private final LogService logService;
//
//    @Override
//    public CarDto create(CarDto carRequest) {
//        return null;
//    }
//
//    @Override
//    public List<CarDto> getAll() {
//        return null;
//    }
//
////    @SneakyThrows
////    @Override
////    public Ca create(CarRequest carRequest) {
////        HttpHeaders headers = new HttpHeaders();
////        headers.setContentType(MediaType.APPLICATION_JSON);
////        headers.setAccept(Collections.singletonList(MediaType.ALL));
////        HttpEntity<CarRequest> requestEntity = new HttpEntity<>(carRequest, headers);
////        var jsonString = restTemplate.postForEntity(properties.getUri(), requestEntity, String.class).getBody();
////        var response = mapper.readValue(jsonString, CarResponse.class);
////        logService.createLog(response);
////        return response;
////    }
////
////    @SneakyThrows
////    @Override
////    public List<CarResponse> getAll() {
////        var jsonString = restTemplate.getForObject(properties.getUri(), String.class);
////        return mapper.readValue(jsonString, new TypeReference<>() {});
////    }
//}
