import com.wheatherapi.service.CurrentService;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

public class CurrentWeather {
    private final String MAIN_URL = "https://api.weatherapi.com/v1";
    private final String POST_PATH = "/current.json?";
    private final String REQUIRED_Q = "q=";
    private final String REQUIRED_Q_VALUE = "Benidorm";
    private final String REQUIRED_APIKEY = "key=";
    private final String REQUIRED_VALUE_APIKEY = "ae34ceb905814b6bb0f215858252102";
    public static RestAssured restAssured = new RestAssured();

    @BeforeMethod
    public void configureRestAssured() {
        restAssured.requestSpecification = given()
                .filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }

    @Test
    public void verifyCurrentCountry(){
        given()
                .when().get(MAIN_URL + POST_PATH + REQUIRED_Q + REQUIRED_Q_VALUE + "&" + REQUIRED_APIKEY + REQUIRED_VALUE_APIKEY)

                .then().statusCode(200)
                .body("location.country",containsString("Spain"));
    }

    @Test
    public void verifyCurrentCountryV2(){
        new CurrentService().sendGetCurrentRequest()
                .then().statusCode(200)
                .body("location.country",containsString("Spain"));
    }
}
