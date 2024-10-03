package ar.edu.utn.frc.tup.lciii.services.impl;

import ar.edu.utn.frc.tup.lciii.clients.RestClient;
import ar.edu.utn.frc.tup.lciii.entities.UserEntity;
import ar.edu.utn.frc.tup.lciii.models.Location;
import ar.edu.utn.frc.tup.lciii.repositores.UserRepository;
import ar.edu.utn.frc.tup.lciii.services.WeatherService;
import ar.edu.utn.frc.tup.lciii.utils.dtos.LocationDto;
import ar.edu.utn.frc.tup.lciii.utils.dtos.WeatherRespDto;
import ar.edu.utn.frc.tup.lciii.utils.dtos.air.AirDto;
import ar.edu.utn.frc.tup.lciii.utils.dtos.air.AirRespDto;
import ar.edu.utn.frc.tup.lciii.utils.dtos.cloud.CloudDto;
import ar.edu.utn.frc.tup.lciii.utils.dtos.cloud.CloudRespDto;
import ar.edu.utn.frc.tup.lciii.utils.dtos.temp.TempDto;
import ar.edu.utn.frc.tup.lciii.utils.dtos.temp.TempRespDto;
import ar.edu.utn.frc.tup.lciii.utils.dtos.user.UserPostDto;
import ar.edu.utn.frc.tup.lciii.utils.dtos.user.UserResponseDto;
import ar.edu.utn.frc.tup.lciii.utils.dtos.wind.WindDto;
import ar.edu.utn.frc.tup.lciii.utils.dtos.wind.WindRespDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherServiceImpl implements WeatherService {

    @Autowired
    private RestClient restClient;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Location getLocation(Long id) {
        Location location = restClient.getLocation(id).getBody();

        return location;
    }

    @Override
    public List<Location> getLocations() {
        List<Location> locations = restClient.getLocations().getBody();

        return locations;

    }

    @Override
    public UserResponseDto postUser(UserPostDto userPostDto) {
        UserEntity userEntity = new UserEntity();

        String secretStr = "e58ed763-928c-4155-bee9-fdbaaadc15f3";

        userEntity.setEmail(userPostDto.getEmail());
        userEntity.setTemperatureUnit(userPostDto.getTemperatureUnit());
        userEntity.setSecret(secretStr);

        UserEntity userSaved = userRepository.save(userEntity);

        UserResponseDto userResponseDto = new UserResponseDto(userSaved.getId(), userSaved.getSecret());
        return userResponseDto;
    }

    @Override
    public WeatherRespDto getWeather(Long id, String date) {

        Location location = restClient.getLocation(id).getBody();
        LocationDto locationDto = new LocationDto(location.getId(), location.getName());

        AirDto airDto = restClient.getAir(id, date).getBody();
        CloudDto cloudDto = restClient.getCloud(id, date).getBody();
        TempDto tempDto = restClient.getTemperature(id, date).getBody();
        WindDto windDto = restClient.getWind(id, date).getBody();

        WindRespDto windRespDto = new WindRespDto(windDirection(windDto.getSpeed(), windDto.getDirection()));
        TempRespDto tempRespDto = new TempRespDto(tempDto.getTemperature(), tempDto.getUnit());
        CloudRespDto cloudRespDto = new CloudRespDto(cloudDto.getCloudiness(), getCloudinessDesc(cloudDto.getCloudiness()));
        AirRespDto airRespDto = new AirRespDto(airDto.getQuality(), getAirDesc(airDto.getQuality()));

        WeatherRespDto weatherRespDto = new WeatherRespDto(locationDto, tempRespDto, windRespDto, airRespDto, cloudRespDto);

        return weatherRespDto;
    }

    private String windDirection(Integer speed, Integer dir) {
        String result = speed + " Km/h from ";
        if(dir == 0 || dir == 360) {
            result += "South"; // viento sur hacia el norte
        } else if (dir == 90) {
            result += "West"; // viento oeste hacia este
        } else if (dir == 180) {
            result += "North"; // viento norte hacia sur
        } else if (dir == 270) {
            result += "East"; // viento este hacia oeste
        }
        return result;
    }

    private String getCloudinessDesc(Integer index) {
        String result = "";
        if(index == 0) {
            result = "Clear Sky";
        } else if (index >= 1 && index <=3) {
            result = "Few Clouds";
        } else if (index >= 4 && index <=6) {
            result = "Sky half cludy";
        } else if (index >= 7 && index <=8) {
            result = "Sky completely cludy";
        }
        return result;
    }

    private String getAirDesc(Integer index) {
        String result = "";
        if(index >= 0 && index <=50) {
            result = "Good";
        } else if (index >= 51 && index <= 100) {
            result = "Moderate";
        } else if (index >= 101 && index <= 150) {
            result = "Unhealthy for Sensitive Groups";
        } else if (index >= 151 && index <= 200) {
            result = "Unhealthy";
        } else if (index >= 201 && index <= 300) {
            result = "Very Unhealthy";
        } else if (index >= 301 && index <= 500) {
            result = "Hazardous";
        }
        return result;
    }
}
