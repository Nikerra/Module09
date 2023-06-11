package org.example.Module09;

/**
 * Weather provider
 */

import org.example.Module09.WeatherApiModel.WeatherInfoReponse;
import org.springframework.web.client.RestTemplate;

/**
 * Weather provider
 */
public class WeatherProvider {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String appKey = "80bd6ce6122c1cb811b741b993e8a17b";
    private final String QUERY = "https://api.openweathermap.org/data/2.5/weather?q=";
//            "Pyatigorsk&units=metric&appid=" + appKey;
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

        WeatherInfoReponse root = restTemplate.getForObject(QUERY + city + "&units=metric&appid=" + appKey, WeatherInfoReponse.class);
        System.out.println(root);
        WeatherInfo weatherInfo = new WeatherInfo(root);
        System.out.println(weatherInfo.getCity());
        System.out.println(weatherInfo);

        return null;
    }
}