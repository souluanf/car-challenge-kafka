package dev.luanfernandes.cars.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CarDto {
    @JsonProperty("_id")
    private String id;
    private String title;
    private String brand;
    private String price;
    private Long age;
    @JsonProperty("__v")
    private Integer version;
}