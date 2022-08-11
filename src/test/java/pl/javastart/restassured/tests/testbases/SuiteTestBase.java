package pl.javastart.restassured.tests.testbases;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.BeforeSuite;
import pl.javastart.restassured.main.properties.EnvironmentConfig;

public class SuiteTestBase{
    //    https://javastart.pl/kurs/rest-assured/framework/lekcja/restassured-wlasciwosci
//    https://javastart.pl/kurs/rest-assured/framework/lekcja/restassured-test-base

//        Jak użyć teraz interfejsu EnvironmentConfig? Do tego celu musimy posłużyć się statyczną metodą Config.Factory.create().
//        I tak dla naszego interfejsu moglibyśmy zapisać:
//        Jak widzisz, w parametrze metody create(), podajemy wartość stworzonego interfejsu EnvironmentConfig.class.
//        Posiadając utworzony obiekt typu EnvironmentConfig, możemy korzystać z metod w nim zdefiniowanych.
    @BeforeSuite
    public void setupConfiguration() {
        EnvironmentConfig environmentConfig = ConfigFactory.create(EnvironmentConfig.class);

        RestAssured.baseURI = environmentConfig.baseUri();
        RestAssured.basePath = environmentConfig.basePath();
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }
}
