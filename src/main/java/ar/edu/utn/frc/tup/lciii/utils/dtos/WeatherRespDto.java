package ar.edu.utn.frc.tup.lciii.utils.dtos;

import ar.edu.utn.frc.tup.lciii.utils.dtos.air.AirRespDto;
import ar.edu.utn.frc.tup.lciii.utils.dtos.cloud.CloudRespDto;
import ar.edu.utn.frc.tup.lciii.utils.dtos.temp.TempRespDto;
import ar.edu.utn.frc.tup.lciii.utils.dtos.wind.WindRespDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherRespDto {

    @JsonProperty("location")
    private LocationDto location;

    @JsonProperty("temperature")
    private TempRespDto temperature;

    @JsonProperty("wind")
    private WindRespDto wind;

    @JsonProperty("air_quality")
    private AirRespDto airQuality;

    @JsonProperty("cloudiness")
    private CloudRespDto cloudiness;
}
