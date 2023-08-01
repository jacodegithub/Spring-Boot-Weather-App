package com.springboot.weather.app.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Coord {
    private float lon;
    private float lat;
}
