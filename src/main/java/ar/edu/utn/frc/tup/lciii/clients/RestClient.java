package ar.edu.utn.frc.tup.lciii.clients;

import ar.edu.utn.frc.tup.lciii.models.Location;
import ar.edu.utn.frc.tup.lciii.utils.dtos.air.AirDto;
import ar.edu.utn.frc.tup.lciii.utils.dtos.cloud.CloudDto;
import ar.edu.utn.frc.tup.lciii.utils.dtos.temp.TempDto;
import ar.edu.utn.frc.tup.lciii.utils.dtos.wind.WindDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
public class RestClient {

    @Autowired
    private RestTemplate restTemplate;

    private static final String HOST = "https://my-json-server.typicode.com/LCIV-2023/fake-weather";

    public ResponseEntity<List<Location>> getLocations() {
        Location[] locations = restTemplate.getForObject(HOST+"/location", Location[].class);

        return ResponseEntity.ok(Arrays.asList(locations));
    }

    public ResponseEntity<Location> getLocation(Long id) {
        Location location = restTemplate.getForObject(HOST+"/location/"+id, Location.class);

        return ResponseEntity.ok(location);
    }

    public ResponseEntity<WindDto> getWind(Long id, String date) {
        WindDto[] windDtos = restTemplate.getForObject(HOST+"/wind?location_id="+id+"&created_at="+date, WindDto[].class);
        WindDto windDto = windDtos[0];
        return ResponseEntity.ok(windDto);
    }

    public ResponseEntity<AirDto> getAir(Long id, String date) {
        AirDto[] airDtos = restTemplate.getForObject(HOST+"/air_quality?location_id="+id+"&created_at="+date, AirDto[].class);
        AirDto airDto = airDtos[0];

        return ResponseEntity.ok(airDto);
    }

    public ResponseEntity<TempDto> getTemperature(Long id, String date) {
        TempDto[] tempDtos = restTemplate.getForObject(HOST+"/temperature?location_id="+id+"&created_at="+date, TempDto[].class);
        TempDto tempDto = tempDtos[0];
        return ResponseEntity.ok(tempDto);
    }

    public ResponseEntity<CloudDto> getCloud(Long id, String date) {
        CloudDto[] cloudDtos = restTemplate.getForObject(HOST+"/cloudiness?location_id="+id+"&created_at="+date, CloudDto[].class);
        CloudDto cloudDto = cloudDtos[0];
        return ResponseEntity.ok(cloudDto);
    }

}
