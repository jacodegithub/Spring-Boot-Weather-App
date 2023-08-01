package com.springboot.weather.app.service;

import com.google.gson.Gson;
import com.springboot.weather.app.dto.Coord;
import com.springboot.weather.app.dto.Weather;
import com.springboot.weather.app.dto.WeatherResponse;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class weatherService {
    private OkHttpClient client;
    private String unit;
    private String APIkey = "3b7a61b69fcba80c3efdeb434adb36d6";

    private Logger logger = LoggerFactory.getLogger(weatherService.class);

    public WeatherResponse getWeather(String cityName) {
//        weatherResponse wResponse = new weatherResponse();

        logger.info("Fetching weather for the city: {}", cityName);

        String APIurl = "https://api.openweathermap.org/data/2.5/weather?q=";
        String url = APIurl+cityName+"&units="+getUnit()+"&appid="+APIkey;

        logger.info("url : {}", url);
        client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();

        try(Response response = client.newCall(request).execute()) {
            String jsonResponse = response.body().string();
            Gson gson = new Gson();
            WeatherResponse wResponse = gson.fromJson(jsonResponse, WeatherResponse.class);
            logger.info("converted file : {}", wResponse);
            logger.info("jsonResponse: {}", jsonResponse);
            return wResponse;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

//    public List<Weather> getWeatherArray(String city) {
//        List<Weather> list = getWeather(city).getWeather();
//        return list;
//    }
//
//    public Coord getCoord(String city) {
//        Coord response = getWeather(city).getCoord();
//        logger.info("response: {}", response);
//        return response;
//    }
//
//    public Long getDateTime(String city) {
//        Long dateTime = getWeather(city).getDt();
//        return dateTime;
//    }
//
//    public float getTemperature(String city) {
//        float temp = getWeather(city).getMain().getTemp();
//        return temp;
//    }
//
//    public Integer getFeelsLike(String city) {
//        int feels_like = (int) getWeather(city).getMain().getFeels_like();
//        return feels_like;
//    }
//
//    public Float getWindSpeed(String city) {
//        Float windSpeed = getWeather(city).getWind().getSpeed();
//        return windSpeed;
//    }
//
//    public Float getHumidity(String city) {
//        Float humidity = getWeather(city).getMain().getHumidity();
//        return humidity;
//    }
//
//    public Integer getVisibility(String city) {
//        int visibility = getWeather(city).getVisibility();
//        return visibility;
//    }
//
//    public Float gerPressure(String city) {
//        Float pressure = getWeather(city).getMain().getPressure();
//        return pressure;
//    }
//
//    public Integer getGrntlvl(String city) {
//        int grnd = getWeather(city).getMain().getGrnd_level();
//        return grnd;
//    }
//
//    public Integer getSealvl(String city) {
//        int sea = getWeather(city).getMain().getSea_level();
//        return sea;
//    }


    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
