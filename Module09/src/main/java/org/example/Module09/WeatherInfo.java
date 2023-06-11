package org.example.Module09;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import lombok.Data;
import org.example.Module09.WeatherApiModel.WeatherInfoReponse;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

@Data
@RestController
@JsonIgnoreProperties(ignoreUnknown = true)
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

    public WeatherInfo(WeatherInfoReponse wir) {
        this.city = wir.name;
        this.shortDescription = String.valueOf(wir.weather.get(0).getMain());
        this.description = String.valueOf(wir.weather.get(0).getDescription());
        this.temperature = wir.main.temp;
        this.feelsLikeTemperature = wir.main.feels_like;
        this.windSpeed = wir.wind.speed;
        this.pressure = wir.main.pressure;
        this.expiryTime = LocalDateTime.now();
    }

    public String getCity() {
        return city;
    }


    @Override
    public String toString() {
        return "WeatherInfo{" +
                "city='" + city + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", description='" + description + '\'' +
                ", temperature=" + temperature +
                ", feelsLikeTemperature=" + feelsLikeTemperature +
                ", windSpeed=" + windSpeed +
                ", pressure=" + pressure +
                ", expiryTime=" + expiryTime +
                '}';
    }
}
