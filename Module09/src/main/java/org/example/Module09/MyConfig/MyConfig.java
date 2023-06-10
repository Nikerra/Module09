package org.example.Module09.MyConfig;

import org.example.Module09.WeatherCache;
import org.example.Module09.WeatherProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

    @Bean
    public WeatherProvider weatherProvider() {
        return new WeatherProvider();
    }

    @Bean
    public WeatherCache weatherCache() {
        return new WeatherCache();
    }
}