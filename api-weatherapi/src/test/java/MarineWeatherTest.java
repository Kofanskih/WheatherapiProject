import com.wheatherapi.models.queryParameters.MarineWeatherRequest.MarineWeatherQueryParams;
import com.wheatherapi.models.queryParameters.MarineWeatherResponse.MarineWeatherResponse;
import com.wheatherapi.service.MarineService;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.wheatherapi.conditions.Conditions.bodyField;
import static com.wheatherapi.conditions.Conditions.statusCode;

public class MarineWeatherTest {

    @Test
    public void verifyDayConditionIsNotNull() throws IOException {
        new MarineService()
                .sendMarineRequest("marine_path","Malaga", 3)
                .then()
                .statusCode(200)
                .body("forecast.forecastday.day.condition.text", Matchers.notNullValue());
    }



    @Test
    public void verifyLocationIsNull() throws IOException {
        MarineWeatherQueryParams marineWeatherQueryParams = new MarineWeatherQueryParams();
        marineWeatherQueryParams.setQ("Malaga");
        marineWeatherQueryParams.setDays(3);
        MarineWeatherResponse marineWeatherResponse = new MarineService()
                .sendMarineRequest2("marine_path", marineWeatherQueryParams)
                .then()
                .statusCode(200)
                .extract()
                .response()
                .as(MarineWeatherResponse.class);
        Assert.assertNotNull(marineWeatherResponse.getLocation().getName(), "Token is null");

    }

    @Test
    public void verifyLocationIsNull1() throws IOException {
        MarineWeatherQueryParams marineWeatherQueryParams = new MarineWeatherQueryParams();
        marineWeatherQueryParams.setQ("Malaga");
        marineWeatherQueryParams.setDays(6);
        new MarineService()
                .sendMarineRequest3(marineWeatherQueryParams)
                .shouldHave(statusCode(200))
                .shouldHave(bodyField("forecast.forecastday.day.condition.text", Matchers.notNullValue()));

    }

    @Test
    public void verifyLocationIsNull2() throws IOException {
        MarineWeatherQueryParams marineWeatherQueryParams = new MarineWeatherQueryParams();
        marineWeatherQueryParams.setQ("Malaga");
        marineWeatherQueryParams.setDays(7);
        new MarineService()
                .sendMarineRequest3(marineWeatherQueryParams)
                .shouldHave(statusCode(200),
                        bodyField("forecast.forecastday.day.condition.text", Matchers.notNullValue()));

    }

    @Test
    public void verifyLocationIsNull3() throws IOException {
        MarineWeatherQueryParams marineWeatherQueryParams = new MarineWeatherQueryParams();
        marineWeatherQueryParams.setQ("Malaga");
        marineWeatherQueryParams.setDays(4);
        MarineWeatherResponse marineWeatherResponse = new MarineService()
                .sendMarineRequest3(marineWeatherQueryParams)
                .shouldHave(statusCode(200)).responseAs(MarineWeatherResponse.class);

        Assert.assertNotNull(marineWeatherResponse.getLocation().getName(), "Token is null");
    }

    @Test
    public void verifyDayConditionIsNotNull2() throws IOException {
        new MarineService()
                .sendMarineRequest4("Malaga", 2)
                .then()
                .statusCode(200)
                .body("forecast.forecastday.day.condition.text", Matchers.notNullValue());
    }
}
