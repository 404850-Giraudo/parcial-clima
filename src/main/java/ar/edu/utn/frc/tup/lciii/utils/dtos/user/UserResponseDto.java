package ar.edu.utn.frc.tup.lciii.utils.dtos.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {
    @JsonProperty("client_id")
    @NotNull
    private Long id;

    @JsonProperty("secret")
    @NotNull
    private String secret;

}
