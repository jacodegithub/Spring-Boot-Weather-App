package com.springboot.weather.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Weather {
    private Long id;
    private String main;
    private String description;
    private String icon;
}
