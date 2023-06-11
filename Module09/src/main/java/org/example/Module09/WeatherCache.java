package org.example.Module09;

import org.example.Module09.WeatherInfo;
import org.example.Module09.WeatherProvider;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

public class WeatherCache {

    private final Map<String, WeatherInfo> cache = new HashMap<>();
    private WeatherProvider weatherProvider;

    /**
     * Default constructor.
     */
    public WeatherCache() {
    }
    @Autowired
    public void setWeatherProvider(WeatherProvider weatherProvider) {
        this.weatherProvider = weatherProvider;
    }
    /**
     * Get ACTUAL weather info for current city or null if current city not found.
     * If cache doesn't contain weather info OR contains NOT ACTUAL info then we should download info
     * If you download weather info then you should set expiry time now() plus 5 minutes.
     * If you can't download weather info then remove weather info for current city from cache.
     *
     * @param city - city
     * @return actual weather info
     */
    public WeatherInfo getWeatherInfo(String city) {
        return weatherProvider.get(city);
    }

    /**
     * Remove weather info from cache.
     **/
    public void removeWeatherInfo(String city) {
        // should be implemented
    }
}
