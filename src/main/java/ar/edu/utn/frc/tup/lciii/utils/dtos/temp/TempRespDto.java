package ar.edu.utn.frc.tup.lciii.utils.dtos.temp;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TempRespDto {

    @JsonProperty("value")
    private Integer value;

    @JsonProperty("unit")
    private String unit;
}
