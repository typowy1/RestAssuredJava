package pl.javastart.restassured.tests.pet;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.javastart.restassured.main.pojo.pet.Category;
import pl.javastart.restassured.main.pojo.pet.Pet;
import pl.javastart.restassured.main.pojo.pet.Tag;
import pl.javastart.restassured.main.properties.EnvironmentConfig;
import pl.javastart.restassured.tests.testbases.SuiteTestBase;

import java.util.Collections;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class CreatePetTests extends SuiteTestBase {

//    wartość zacomitowaną przeniosłem do SuiteTestBase

//    https://javastart.pl/kurs/rest-assured/framework/lekcja/pierwszy-test-we-frameworku
//    https://javastart.pl/kurs/rest-assured/framework/lekcja/restassured-wlasciwosci

//    @BeforeMethod
//    public void setupConfiguration() {
////        Jak użyć teraz interfejsu EnvironmentConfig? Do tego celu musimy posłużyć się statyczną metodą Config.Factory.create().
////        I tak dla naszego interfejsu moglibyśmy zapisać:
////        Jak widzisz, w parametrze metody create(), podajemy wartość stworzonego interfejsu EnvironmentConfig.class.
////        Posiadając utworzony obiekt typu EnvironmentConfig, możemy korzystać z metod w nim zdefiniowanych.
//
//        EnvironmentConfig environmentConfig = ConfigFactory.create(EnvironmentConfig.class);
//        RestAssured.baseURI = environmentConfig.baseUri();;
//        RestAssured.basePath = environmentConfig.basePath();
//        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
//    }

    @Test
    public void givenPetWhenPostPetThenPetIsCreatedTest() {

        Category category = new Category();
        category.setId(1);
        category.setName("dogs");

        Tag tag = new Tag();
        tag.setId(1);
        tag.setName("dogs-category");

        Pet pet = new Pet();
        pet.setId(123);
        pet.setCategory(category);
        pet.setPhotoUrls(Collections.singletonList("http://photos.com/dog1.jpg"));
        pet.setTags(Collections.singletonList(tag));
        pet.setStatus("available");

        Pet actualPet = given().body(pet).contentType("application/json")
                .when().post("pet")
                .then().statusCode(200).extract().as(Pet.class);

        assertEquals(actualPet.getId(), pet.getId(), "Pet id");
        assertEquals(actualPet.getName(), pet.getName(), "Pet name");
    }
}
