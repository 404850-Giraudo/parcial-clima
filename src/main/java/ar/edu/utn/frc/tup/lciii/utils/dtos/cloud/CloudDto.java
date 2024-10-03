package ar.edu.utn.frc.tup.lciii.utils.dtos.cloud;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CloudDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("location_id")
    private Long locationId;

    @JsonProperty("cloudiness")
    private Integer cloudiness;

    @JsonProperty("created_at")
    private ZonedDateTime createdAt;
}
