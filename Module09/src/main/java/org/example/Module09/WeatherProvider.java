package org.example.Module09;

/**
 * Weather provider
 */

import org.example.Module09.WeatherApiModel.WeatherInfoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestTemplate;

/**
 * Weather provider
 */
@PropertySource("classpath:application.properties")
public class WeatherProvider {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${default.appKey}")
    private String appKey;
    @Value("${default.url}")
    private String URL;

//    https://api.openweathermap.org/data/2.5/weather?q=Pyatigorsk&units=metric&appid=80bd6ce6122c1cb811b741b993e8a17b
    /**
     * Download ACTUAL weather info from internet.
     * You should call GET http://api.openweathermap.org/data/2.5/weather?q={city name}&appid={API key}
     * You should use Spring Rest Template for calling requests
     *
     * @param city - city
     * @return weather info or null
     */
    @Autowired
    public WeatherInfo get(String city) {
        WeatherInfoResponse wir = restTemplate.getForObject(URL+ city + "&units=metric&appid=" + appKey, WeatherInfoResponse.class);
        return new WeatherInfo(wir);
    }
}