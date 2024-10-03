package ar.edu.utn.frc.tup.lciii.utils.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LocationDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;
}
