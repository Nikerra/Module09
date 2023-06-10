package org.example.Module09;

import org.example.Module09.MyConfig.MyConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        WeatherCache cache = context.getBean(WeatherCache.class);

        WeatherInfo weatherInfo = cache.getWeatherInfo("OMSK");
        WeatherProvider weatherProvider = new WeatherProvider();
        weatherProvider.get("Pyatigorsk");
        System.out.println("GOOD! weather=" + weatherInfo);
    }
}
