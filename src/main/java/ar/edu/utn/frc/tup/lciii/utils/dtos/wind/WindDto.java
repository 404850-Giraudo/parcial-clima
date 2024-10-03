package ar.edu.utn.frc.tup.lciii.utils.dtos.wind;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WindDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("location_id")
    private Long locationId;

    @JsonProperty("speed")
    private Integer speed;

    @JsonProperty("direction")
    private Integer direction;

    @JsonProperty("created_at")
    private ZonedDateTime createdAt;
}
