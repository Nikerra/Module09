package org.example.Module09;

/**
 * Weather provider
 */

import org.springframework.web.client.RestTemplate;

/**
 * Weather provider
 */
public class WeatherProvider {

    private RestTemplate restTemplate = new RestTemplate();
    private String appKey;
    private final String QUERY = "https://api.openweathermap.org/data/2.5/weather?q=Pyatigorsk&units=metric&appid=80bd6ce6122c1cb811b741b993e8a17b";
    /**
     * Download ACTUAL weather info from internet.
     * You should call GET http://api.openweathermap.org/data/2.5/weather?q={city name}&appid={API key}
     * You should use Spring Rest Template for calling requests
     *
     * @param city - city
     * @return weather info or null
     */
    public WeatherInfo get(String city) {

        WeatherInfoJson weatherInfoJson = (restTemplate.getForObject(QUERY, WeatherInfoJson.class));
        WeatherInfo weatherInfo = restTemplate.getForObject(QUERY, WeatherInfo.class);
        String str = String.valueOf(weatherInfoJson);
//        weatherInfoJson.fromJson(weatherInfoJson);
        System.out.println(weatherInfo);
        System.out.println(weatherInfoJson.getMain().getTemp_max());
        System.out.println(weatherInfo.getTemperature());
        System.out.println(weatherInfo.getCity());
        return null;
    }
}