package pl.javastart.restassured.tests.user;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.javastart.restassured.main.pojo.ApiResponse;
import pl.javastart.restassured.main.pojo.user.User;
import pl.javastart.restassured.tests.testbases.SuiteTestBase;

import static io.restassured.RestAssured.given;

public class CreateUserTests extends SuiteTestBase {
//    https://javastart.pl/kurs/rest-assured/framework/lekcja/restassured-test-base

    @Test
    public void givenUserWhenPostUserThenUserIsCreatedTest() {
        User user = new User();
        user.setId(445);
        user.setUsername("firstuser");
        user.setFirstName("Krzysztof");
        user.setLastName("Kowalski");
        user.setEmail("krzysztof@test.com");
        user.setPassword("password");
        user.setPhone("+123456789");
        user.setUserStatus(123);

       ApiResponse apiResponse = given().contentType("application/json")
                .body(user)
                .when().post("user")
                .then().statusCode(200).extract().as(ApiResponse.class);

        Assert.assertEquals(apiResponse.getCode(), Integer.valueOf(200), "Code");
        Assert.assertEquals(apiResponse.getType(), "unknown", "Type");
        Assert.assertEquals(apiResponse.getMessage(), "445", "Message");
    }
}
