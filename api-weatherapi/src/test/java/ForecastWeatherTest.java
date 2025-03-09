import com.wheatherapi.service.ForecastService;

import org.testng.annotations.Test;

import java.io.IOException;

import static org.hamcrest.Matchers.notNullValue;

public class ForecastWeatherTest {

    @Test
    public void verifyForecastDateEpochIsNotNull() throws IOException {
        new ForecastService()
                .sendForecastRequest("forecast_path","Benidorm", 2, "api_key")
                .then().statusCode(200)
                .body("forecast.forecastday.date_epoch", notNullValue());
    }

    @Test
    public void verifyForecastAgerageTempC() throws IOException {
        new ForecastService()
                .sendForecastRequest("forecast_path","Valencia", 3, "api_key")
                .then().statusCode(200)
                .body("forecast.forecastday.day.avgtemp_c", notNullValue());
    }

}
