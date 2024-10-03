package ar.edu.utn.frc.tup.lciii.utils.dtos.cloud;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CloudRespDto {

    @JsonProperty("index")
    private Integer index;

    @JsonProperty("description")
    private String description;
}
