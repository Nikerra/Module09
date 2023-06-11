package org.example.Module09;

import org.example.Module09.MyConfig.MyConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {

            ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
            WeatherCache cache = context.getBean(WeatherCache.class);
        while (true) {
            WeatherInfo weatherInfo = cache.getWeatherInfo("Пятигорск");
            System.out.println("GOOD! weather=" + weatherInfo);
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
