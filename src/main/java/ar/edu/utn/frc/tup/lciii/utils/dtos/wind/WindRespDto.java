package ar.edu.utn.frc.tup.lciii.utils.dtos.wind;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WindRespDto {
    @JsonProperty("wind")
    private String wind;
}
