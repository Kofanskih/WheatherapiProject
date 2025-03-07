import com.wheatherapi.models.queryParameters.FutureWeatherRequest.FutureWeatherQueryParams;
import com.wheatherapi.models.queryParameters.FutureWeatherResponse.FutureWeatherResponse;
import com.wheatherapi.models.queryParameters.FutureWeatherResponse.Location;
import com.wheatherapi.service.FutureService;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.wheatherapi.conditions.Conditions.bodyField;
import static com.wheatherapi.conditions.Conditions.statusCode;

public class FutureWeatherTest {

    @Test
    public void verifyDayConditionIsNotNull(){
        new FutureService()
                .sendFutureRequest("Malaga", "2025-04-01")
                .then()
                .statusCode(200)
                .body("forecast.forecastday.day.condition.text", Matchers.notNullValue());
    }

    @Test
    public void verifyDayConditionIsNotNull1(){
        new FutureService()
                .sendFutureRequest("Malaga", "2025-04-01")
                .then()
                .statusCode(200)
                .body("forecast.forecastday.day.condition.text", Matchers.notNullValue());
    }

    @Test
    public void verifyDayConditionIsNotNull2() throws IOException {
        new FutureService()
                .sendFutureRequest4("Malaga", "2025-04-01", "api_key")
                .then()
                .statusCode(200)
                .body("forecast.forecastday.day.condition.text", Matchers.notNullValue());
    }


    @Test
    public void verifyLocationIsNull(){
        FutureWeatherQueryParams futureWeatherQueryParams = new FutureWeatherQueryParams();
        futureWeatherQueryParams.setQ("Malaga");
        futureWeatherQueryParams.setDt("2025-04-01");
        futureWeatherQueryParams.setKey("ae34ceb905814b6bb0f215858252102");
        new FutureService()
                .sendFutureRequest2(futureWeatherQueryParams)
                .then()
                .statusCode(200)
                .extract()
                .response()
                .as(FutureWeatherQueryParams.class);

    }

    @Test
    public void verifyLocationIsNull1(){
        FutureWeatherQueryParams futureWeatherQueryParams = new FutureWeatherQueryParams();
        futureWeatherQueryParams.setQ("Malaga");
        futureWeatherQueryParams.setDt("2025-04-01");
        futureWeatherQueryParams.setKey("ae34ceb905814b6bb0f215858252102");
        new FutureService()
                .sendFutureRequest3(futureWeatherQueryParams)
                .shouldHave(statusCode(200))
                .shouldHave(bodyField("forecast.forecastday.day.condition.text", Matchers.notNullValue()));

    }

    @Test
    public void verifyLocationIsNull2(){
        FutureWeatherQueryParams futureWeatherQueryParams = new FutureWeatherQueryParams();
        futureWeatherQueryParams.setQ("Malaga");
        futureWeatherQueryParams.setDt("2025-04-01");
        futureWeatherQueryParams.setKey("ae34ceb905814b6bb0f215858252102");
        new FutureService()
                .sendFutureRequest3(futureWeatherQueryParams)
                .shouldHave(statusCode(200),
                        bodyField("forecast.forecastday.day.condition.text", Matchers.notNullValue()));

    }

    @Test
    public void verifyLocationIsNull3(){
        FutureWeatherQueryParams futureWeatherQueryParams = new FutureWeatherQueryParams();
        futureWeatherQueryParams.setQ("Malaga");
        futureWeatherQueryParams.setDt("2025-04-01");
        futureWeatherQueryParams.setKey("ae34ceb905814b6bb0f215858252102");
        FutureWeatherResponse futureWeatherResponse = new FutureService()
                .sendFutureRequest3(futureWeatherQueryParams)
                .shouldHave(statusCode(200)).responseAs(FutureWeatherResponse.class);

        Assert.assertNotNull(futureWeatherResponse.getLocation().getName(), "Token is null");
    }
}
