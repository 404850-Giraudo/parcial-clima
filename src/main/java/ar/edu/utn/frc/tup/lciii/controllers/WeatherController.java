package ar.edu.utn.frc.tup.lciii.controllers;


import ar.edu.utn.frc.tup.lciii.models.Location;
import ar.edu.utn.frc.tup.lciii.services.WeatherService;
import ar.edu.utn.frc.tup.lciii.utils.dtos.WeatherRespDto;
import ar.edu.utn.frc.tup.lciii.utils.dtos.user.UserPostDto;
import ar.edu.utn.frc.tup.lciii.utils.dtos.user.UserResponseDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @PostMapping("/subscribe")
    public ResponseEntity<UserResponseDto> newConsumer(@Valid @RequestBody UserPostDto userPostDto) {

        UserResponseDto userResponseDto = weatherService.postUser(userPostDto);

        return ResponseEntity.ok(userResponseDto);
    }

    @GetMapping("/locations")
    public ResponseEntity<List<Location>> getLocations() {

        List<Location> locations = weatherService.getLocations();

        return ResponseEntity.ok(locations);
    }

    @GetMapping("/locations/{id}")
    public ResponseEntity<Location> getLocation(@PathVariable Long id) {

        Location location = weatherService.getLocation(id);

        return ResponseEntity.ok(location);
    }

    @GetMapping("/location/{id}")
    public ResponseEntity<WeatherRespDto> getWeather(@PathVariable Long id,
                                               @RequestParam(name = "date") String date) {
        System.out.println("HOLAAAAAAAAAAAAAAAAAAAAAAA " + date);
        WeatherRespDto weatherRespDto = weatherService.getWeather(id, date);

        return ResponseEntity.ok(weatherRespDto);
    }
}
