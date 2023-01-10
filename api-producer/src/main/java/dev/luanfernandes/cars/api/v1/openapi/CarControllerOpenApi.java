package dev.luanfernandes.cars.api.v1.openapi;



import dev.luanfernandes.cars.domain.dto.CarDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;


@Api(tags = "Cars")
public interface CarControllerOpenApi {

    @ApiResponses({@ApiResponse(code = 200, message = "sucesso", response = CarDto.class, responseContainer = "List")})
    List<CarDto> getAll();

    @ApiResponses({@ApiResponse(code = 200, message = "sucesso", response = CarDto.class)})
    CarDto getById(@PathVariable String id);

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    void delete(@PathVariable String id);

//    @ApiResponses({@ApiResponse(code = 201, message = "sucesso", response = CarDto.class)})
//    CarDto createCar(CarDto carRequest);
}
