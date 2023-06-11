package org.example.Module09;

/**
 * Weather provider
 */

import lombok.RequiredArgsConstructor;
import org.example.Module09.WeatherApiModel.WeatherInfoResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Weather provider
 */
@Component
@RequiredArgsConstructor
public class WeatherProvider {

    private final RestTemplate restTemplate;
    @Value("${default.appKey}")
    private String appKey;
    @Value("${default.url}")
    private String URL;
    @Value("${default.metric}")
    private String metric;

//    https://api.openweathermap.org/data/2.5/weather?q=Pyatigorsk&units=metric&appid=80bd6ce6122c1cb811b741b993e8a17b
    /**
     * Download ACTUAL weather info from internet.
     * You should call GET http://api.openweathermap.org/data/2.5/weather?q={city name}&appid={API key}
     * You should use Spring Rest Template for calling requests
     *
     * @param city - city
     * @return weather info or null
     */

    public WeatherInfo get(String city) {
        WeatherInfoResponse wir = restTemplate.getForObject(URL+ city + metric + appKey, WeatherInfoResponse.class);
        return new WeatherInfo(wir);
    }
}