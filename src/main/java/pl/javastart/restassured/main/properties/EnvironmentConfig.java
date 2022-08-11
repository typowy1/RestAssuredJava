package pl.javastart.restassured.main.properties;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:EnvironmentConfig.properties")
public interface EnvironmentConfig extends Config {
//    https://javastart.pl/kurs/rest-assured/framework/lekcja/restassured-wlasciwosci

    @Config.Key("BASE_URI")
    String baseUri(); // zwraca baseUri z pliku propertis

    @Config.Key("BASE_PATH")
    String basePath();
}
