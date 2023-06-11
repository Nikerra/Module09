package org.example.Module09;

import lombok.Data;
import org.example.Module09.WeatherApiModel.WeatherInfoResponse;
import java.time.LocalDateTime;


@Data
public class WeatherInfo {

    private String city;

    /**
     * Short weather description
     * Like 'sunny', 'clouds', 'raining', etc
     */
    private String shortDescription;

    /**
     * Weather description.
     * Like 'broken clouds', 'heavy raining', etc
     */
    private String description;

    /**
     * Temperature.
     */
    private double temperature;

    /**
     * Temperature that fells like.
     */
    private double feelsLikeTemperature;

    /**
     * Wind speed.
     */
    private double windSpeed;

    /**
     * Pressure.
     */
    private final double pressure;

    /**
     * Expiry time of weather info.
     * If current time is above expiry time then current weather info is not actual!
     */
    private LocalDateTime expiryTime;

    public WeatherInfo(WeatherInfoResponse wir) {
        this.city = wir.name;
        this.shortDescription = wir.weather.get(0).getMain();
        this.description = wir.weather.get(0).getDescription();
        this.temperature = wir.main.temp;
        this.feelsLikeTemperature = wir.main.feels_like;
        this.windSpeed = wir.wind.speed;
        this.pressure = wir.main.pressure;
        this.expiryTime = LocalDateTime.now().plusMinutes(1);
    }
}
