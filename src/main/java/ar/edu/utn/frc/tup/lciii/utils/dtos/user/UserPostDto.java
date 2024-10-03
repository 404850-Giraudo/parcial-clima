package ar.edu.utn.frc.tup.lciii.utils.dtos.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPostDto {
    @JsonProperty("email")
    @NotNull
    private String email;

    @JsonProperty("temperature_unit")
    @NotNull
    private String temperatureUnit;

}
