package org.example.Module09.WeatherApiModel;

import lombok.Data;

@Data
public class Weather{
    public int id;
    public String main;
    public String description;
    public String icon;
}