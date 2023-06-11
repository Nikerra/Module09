package org.example.Module09.MyConfig;

import org.example.Module09.WeatherCache;
import org.example.Module09.WeatherProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestTemplate;

@Configuration
@PropertySource("classpath:application.properties")
public class MyConfig {
    @Bean
    public WeatherProvider weatherProvider() {return new WeatherProvider(restTemplate());}

    @Bean
    public WeatherCache weatherCache() {
        return new WeatherCache();
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}