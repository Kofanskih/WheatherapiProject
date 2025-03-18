import com.wheatherapi.models.queryParameters.ForecastWeatherRequest.ForecastWeatherQueryParams;
import com.wheatherapi.models.queryParameters.ForecastWeatherResponse.ForecastWeatherResponse;
import com.wheatherapi.service.ForecastService;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.wheatherapi.conditions.Conditions.bodyField;
import static com.wheatherapi.conditions.Conditions.statusCode;
import static org.hamcrest.Matchers.notNullValue;

public class ForecastWeatherTest {

    @Test
    public void verifyForecastDateEpochIsNotNull() throws IOException {
        new ForecastService()
                .sendForecastRequest("forecast_path","Benidorm", 2)
                .then().statusCode(200)
                .body("forecast.forecastday.date_epoch", notNullValue());
    }

    @Test
    public void verifyForecastAgerageTempC() throws IOException {
        new ForecastService()
                .sendForecastRequest("forecast_path","Valencia", 3)
                .then().statusCode(200)
                .body("forecast.forecastday.day.avgtemp_c", notNullValue());
    }

    @Test
    public void verifyForecastAgerageTempC1() throws IOException {
        ForecastWeatherQueryParams forecastWeatherQueryParams = new ForecastWeatherQueryParams();
        forecastWeatherQueryParams.setQ("Malaga");
        forecastWeatherQueryParams.setDays(5);
        new ForecastService()
                .sendForecastRequest1(forecastWeatherQueryParams)
                .then().statusCode(200)
                .body("forecast.forecastday.day.avgtemp_c", notNullValue());
    }

    @Test
    public void verifyForecastAgerageTempC2() throws IOException {
        ForecastWeatherQueryParams forecastWeatherQueryParams = new ForecastWeatherQueryParams();
        forecastWeatherQueryParams.setQ("Benidorm");
        forecastWeatherQueryParams.setDays(10);
        new ForecastService()
                .sendForecastRequest2("forecast_path",forecastWeatherQueryParams)
                .then().statusCode(200)
                .body("forecast.forecastday.day.avgtemp_c", notNullValue());
    }

    @Test
    public void verifyForecastLocationNameNotNull() throws IOException {
        ForecastWeatherQueryParams forecastWeatherQueryParams = new ForecastWeatherQueryParams();
        forecastWeatherQueryParams.setQ("Benidorm");
        forecastWeatherQueryParams.setDays(7);
        new ForecastService()
                .sendForecastRequest3(forecastWeatherQueryParams)
                .shouldHave(statusCode(200), bodyField("location.name", notNullValue()));
    }

    @Test
    public void verifyForecastLocationNameNotNull1() throws IOException {
        ForecastWeatherQueryParams forecastWeatherQueryParams = new ForecastWeatherQueryParams();
        forecastWeatherQueryParams.setQ("Elche");
        forecastWeatherQueryParams.setDays(4);
        new ForecastService()
                .sendForecastRequest4(forecastWeatherQueryParams)
                .shouldHave(statusCode(200))
                .shouldHave(bodyField("location.name", notNullValue()));
    }

    @Test
    public void verifyForecastLocationNameNotNull2() throws IOException {
        ForecastWeatherQueryParams forecastWeatherQueryParams = new ForecastWeatherQueryParams();
        forecastWeatherQueryParams.setQ("Elche");
        forecastWeatherQueryParams.setDays(4);
        ForecastWeatherResponse forecastWeatherResponse = new ForecastService()
                .sendForecastRequest4(forecastWeatherQueryParams)
                .shouldHave(statusCode(200)).responseAs(ForecastWeatherResponse.class);

        Assert.assertNotNull(forecastWeatherResponse.getForecast().getForecastday(), "");
    }

}
