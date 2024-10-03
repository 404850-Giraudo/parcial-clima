package ar.edu.utn.frc.tup.lciii.utils.dtos.temp;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TempDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("location_id")
    private Long locationId;

    @JsonProperty("temperature")
    private Integer temperature;

    @JsonProperty("unit")
    private String unit;

    @JsonProperty("created_at")
    private ZonedDateTime createdAt;
}