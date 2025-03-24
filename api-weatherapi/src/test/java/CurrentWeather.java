import com.wheatherapi.models.queryParameters.CurrentWeatherRequest.CurrentWeatherQueryParams;
import com.wheatherapi.models.queryParameters.CurrentWeatherResponse.CurrentWeatherResponse;
import com.wheatherapi.service.CurrentService;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.wheatherapi.conditions.Conditions.statusCode;
import static com.wheatherapi.conditions.Conditions.bodyField;
import static org.hamcrest.Matchers.*;

public class CurrentWeather {

    @Test
    public void verifyCurrentCountry() throws IOException {
        new CurrentService().sendGetCurrentRequest("Madrid")
                .then().statusCode(200)
                .body("location.country",containsString("Spain"));
    }

    @Test
    public void verifyCurrentCountry01() throws IOException {
        new CurrentService().sendGetCurrentRequest01("Madrid")
                .then().statusCode(200)
                .body("location.country",containsString("Spain"));
    }

    @Test
    public void verifyCurrentConditionTextIsNotNull() throws IOException {
        new CurrentService().sendGetCurrentRequest("Benidorm")
                .then().statusCode(200)
                .body("current.condition.text", notNullValue());
    }

    @Test
    public void verifyCurrentConditionTextIsNotNull1() throws IOException{
        CurrentWeatherQueryParams currentWeatherQueryParams = new CurrentWeatherQueryParams();
        currentWeatherQueryParams.setQ("Benidorm");
        new CurrentService()
                .sendCurrentRequest1("current_path", currentWeatherQueryParams)
                .then().statusCode(200).body("current.condition.text", notNullValue());
    }

    @Test
    public void verifyCurrentLocationNameIsNotNull() throws IOException {
        CurrentWeatherQueryParams currentWeatherQueryParams = new CurrentWeatherQueryParams();
        currentWeatherQueryParams.setQ("Malaga");
        new CurrentService()
                .sendCurrentRequest2(currentWeatherQueryParams)
                        .shouldHave(statusCode(200)).shouldHave(bodyField("location.name", notNullValue()));
    }


    @Test
    public void verifyCurrentLocationNameIsNotNull1() throws IOException {
        CurrentWeatherQueryParams currentWeatherQueryParams = new CurrentWeatherQueryParams();
        currentWeatherQueryParams.setQ("Malaga");
        new CurrentService()
                .sendCurrentRequest3(currentWeatherQueryParams)
                .shouldHave(statusCode(200),bodyField("location.name", notNullValue()));
    }


    @Test
    public void verifyCurrentConditionCodeIsNotNyll() throws IOException {
        CurrentWeatherQueryParams currentWeatherQueryParams = new CurrentWeatherQueryParams();
        currentWeatherQueryParams.setQ("Madrid");
        CurrentWeatherResponse currentWeatherResponse = new CurrentService()
                .sendCurrentRequest3(currentWeatherQueryParams)
                .shouldHave(statusCode(200)).responseAs(CurrentWeatherResponse.class);

        Assert.assertNotNull(currentWeatherResponse.getCurrent().getCondition().getCode(), "1009");
    }
}
