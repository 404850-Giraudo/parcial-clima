package ar.edu.utn.frc.tup.lciii.services;

import ar.edu.utn.frc.tup.lciii.models.Location;
import ar.edu.utn.frc.tup.lciii.utils.dtos.WeatherRespDto;
import ar.edu.utn.frc.tup.lciii.utils.dtos.user.UserPostDto;
import ar.edu.utn.frc.tup.lciii.utils.dtos.user.UserResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WeatherService {

    public Location getLocation(Long id);

    public List<Location> getLocations();

    public UserResponseDto postUser(UserPostDto userPostDto);

    public WeatherRespDto getWeather(Long id, String date);

}
