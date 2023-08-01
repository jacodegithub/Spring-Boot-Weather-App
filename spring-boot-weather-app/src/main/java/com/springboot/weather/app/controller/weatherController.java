package com.springboot.weather.app.controller;

import com.springboot.weather.app.dto.Coord;
import com.springboot.weather.app.dto.Weather;
import com.springboot.weather.app.dto.WeatherResponse;
import com.springboot.weather.app.service.weatherService;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/weather-app/api/v1/")
public class weatherController {

    @Autowired
    private weatherService wService;

    private Logger logger = LoggerFactory.getLogger(weatherService.class);

    @GetMapping("/{cityName}")
    public ResponseEntity<WeatherResponse> getWeatherByCity(@PathVariable String cityName,
                                                            @RequestParam(defaultValue = "metric") String unit)  {

        try {
            wService.setUnit(unit);
            WeatherResponse object = wService.getWeather(cityName);
            return new ResponseEntity<>(object, HttpStatus.OK);
        }catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

//    @GetMapping("/{city}/weather")
//    public ResponseEntity<List<Weather>> getWeatherArray(@PathVariable String city) {
//        List<Weather> array = wService.getWeatherArray(city);
//        return new ResponseEntity<>(array, HttpStatus.OK);
//    }
//
//    @GetMapping("/{unit}/{cityName}/coord")
//    public ResponseEntity<Coord> getCoordinates(@PathVariable String unit,
//                                                @PathVariable String cityName) {
//        wService.setUnit(unit);
//        Coord coord = wService.getCoord(cityName);
//        return new ResponseEntity<>(coord, HttpStatus.OK);
//    }
//
//    @GetMapping("/{city}/currentTime")
//    public ResponseEntity<Date> getDateTime(@PathVariable String city) {
//        Long dateTime = wService.getDateTime(city);
//        Long milliseconds = dateTime * 1000L;
//        Date date = new Date(milliseconds);
//        logger.info("date : {}",date);
//        return new ResponseEntity<>(date, HttpStatus.OK);
//    }
//
//    @GetMapping("/{city}/temperature")
//    public ResponseEntity<Float> getTemperature(@PathVariable String city,
//                                                @RequestParam(defaultValue = "metric") String unit) {
//        wService.setUnit(unit);
//        Float temperature = wService.getTemperature(city);
//        return new ResponseEntity<>(temperature, HttpStatus.OK);
//    }
//
//    @GetMapping("/{city}/feels_like")
//    public ResponseEntity<Integer> getFeelsLike(@PathVariable String city,
//                                                @RequestParam(defaultValue = "metric") String unit) {
//        wService.setUnit(unit);
//        Integer feels_like = wService.getFeelsLike(city);
//        return new ResponseEntity<>(feels_like, HttpStatus.OK);
//    }
//
//    @GetMapping("/{city}/wind")
//    public ResponseEntity<Float> getWindSpeed(@PathVariable String city) {
//        Float windSpeed = wService.getWindSpeed(city);
//        return new ResponseEntity<>(windSpeed, HttpStatus.OK);
//    }
//
//    @GetMapping("/{city}/humidity")
//    public ResponseEntity<Float> getWeatherHumidity(@PathVariable String city) {
//        Float humidity = wService.getHumidity(city);
//        return new ResponseEntity<>(humidity, HttpStatus.OK);
//    }
//
//    @GetMapping("/{city}/visibility")
//    public ResponseEntity<Integer> getWeatherVisibility(@PathVariable String city) {
//        int visibility = wService.getVisibility(city);
//        return new ResponseEntity<>(visibility, HttpStatus.OK);
//    }
//
//    @GetMapping("/{city}/pressure")
//    public ResponseEntity<Float> getWeatherPressure(@PathVariable String city) {
//        Float pressure = wService.gerPressure(city);
//        return new ResponseEntity<>(pressure, HttpStatus.OK);
//    }
//
//    @GetMapping("/{city}/grnd")
//    public ResponseEntity<Integer> getWeatherGrndlvl(@PathVariable String city) {
//        int windSpeed = wService.getGrntlvl(city);
//        return new ResponseEntity<>(windSpeed, HttpStatus.OK);
//    }
//
//    @GetMapping("/{city}/sea")
//    public ResponseEntity<Integer> getWeatherSealvl(@PathVariable String city) {
//        int windSpeed = wService.getSealvl(city);
//        return new ResponseEntity<>(windSpeed, HttpStatus.OK);
//    }
}
