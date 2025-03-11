import com.wheatherapi.models.queryParameters.CurrentWeatherRequest.CurrentWeatherQueryParams;
import com.wheatherapi.models.queryParameters.CurrentWeatherResponse.CurrentWeatherResponse;
import com.wheatherapi.service.CurrentService;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.GetApiKey;

import java.io.IOException;

import static com.wheatherapi.conditions.Conditions.statusCode;
import static com.wheatherapi.conditions.Conditions.bodyField;
import static org.hamcrest.Matchers.*;

public class CurrentWeather {

    @Test
    public void verifyCurrentCountryV2() throws IOException {
        new CurrentService().sendGetCurrentRequest("current_path","Madrid", "api_key")
                .then().statusCode(200)
                .body("location.country",containsString("Spain"));
    }

    @Test
    public void verifyCurrentConditionTextIsNotNull() throws IOException {
        new CurrentService().sendGetCurrentRequest("current_path","Benidorm", "api_key")
                .then().statusCode(200)
                .body("current.condition.text", notNullValue());
    }

    @Test
    public void verifyCurrentConditionTextIsNotNull1() throws IOException{
        CurrentWeatherQueryParams currentWeatherQueryParams = new CurrentWeatherQueryParams();
        currentWeatherQueryParams.setQ("Benidorm");
        new CurrentService()
                .sendCurrentRequest1("current_path", currentWeatherQueryParams, "api_key")
                .then().statusCode(200).body("current.condition.text", notNullValue());
    }

    @Test
    public void verifyCurrentLocationNameIsNotNull() throws IOException {
        CurrentWeatherQueryParams currentWeatherQueryParams = new CurrentWeatherQueryParams();
        currentWeatherQueryParams.setQ("Malaga");
        new CurrentService()
                .sendCurrentRequest2("main_url", "current_path", currentWeatherQueryParams, "api_key")
                        .shouldHave(statusCode(200)).shouldHave(bodyField("location.name", notNullValue()));
    }

    @Test
    public void verifyCurrentLocationNameIsNotNull1() throws IOException {
        CurrentWeatherQueryParams currentWeatherQueryParams = new CurrentWeatherQueryParams();
        currentWeatherQueryParams.setQ("Malaga");
        currentWeatherQueryParams.setKey(new GetApiKey().takeApiKey("api_key"));
        new CurrentService()
                .sendCurrentRequest3("main_url", "current_path", currentWeatherQueryParams)
                .shouldHave(statusCode(200),bodyField("location.name", notNullValue()));
    }


    @Test
    public void verifyCurrentConditionCodeIsNotNyll() throws IOException {
        CurrentWeatherQueryParams currentWeatherQueryParams = new CurrentWeatherQueryParams();
        currentWeatherQueryParams.setQ("Madrid");
        currentWeatherQueryParams.setKey(new GetApiKey().takeApiKey("api_key"));
        CurrentWeatherResponse currentWeatherResponse = new CurrentService()
                .sendCurrentRequest3("main_url", "current_path", currentWeatherQueryParams)
                .shouldHave(statusCode(200)).responseAs(CurrentWeatherResponse.class);

        Assert.assertNotNull(currentWeatherResponse.getCurrent().getCondition().getCode(), "");
    }
}
