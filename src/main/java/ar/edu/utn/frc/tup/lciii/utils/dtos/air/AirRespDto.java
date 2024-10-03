package ar.edu.utn.frc.tup.lciii.utils.dtos.air;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AirRespDto {
    
    @JsonProperty("index")
    private Integer index;

    @JsonProperty("description")
    private String description;
}
