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
            System.out.println("object -> "+object);
            return new ResponseEntity<>(object, HttpStatus.OK);
        }catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
