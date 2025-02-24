import com.wheatherapi.service.ForecastService;

import org.testng.annotations.Test;

import static org.hamcrest.Matchers.notNullValue;

public class ForecastWeatherTest {

    @Test
    public void verifyForecastDateEpochIsNotNull(){
        new ForecastService()
                .sendForecastRequest("Benidorm", 2)
                .then().statusCode(200)
                .body("forecast.forecastday.date_epoch", notNullValue());
    }

    @Test
    public void verifyForecastAgerageTempC(){
        new ForecastService()
                .sendForecastRequest("Valencia", 3)
                .then().statusCode(200)
                .body("forecast.forecastday.day.avgtemp_c", notNullValue());
    }
}
