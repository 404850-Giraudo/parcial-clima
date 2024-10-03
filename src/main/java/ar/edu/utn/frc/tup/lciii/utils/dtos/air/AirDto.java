package ar.edu.utn.frc.tup.lciii.utils.dtos.air;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AirDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("location_id")
    private Long locationId;

    @JsonProperty("quality")
    private Integer quality;

    @JsonProperty("created_at")
    private ZonedDateTime createdAt;
}