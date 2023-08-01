package com.springboot.weather.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Main {
     private float temp;
     private float feels_like;
     private float temp_min;
     private float temp_max;
     private float pressure;
     private float humidity;
     private int sea_level;
     private int grnd_level;
}
