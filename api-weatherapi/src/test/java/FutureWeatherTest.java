import com.wheatherapi.service.FutureService;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class FutureWeatherTest {

    @Test
    public void verifyDayConditionIsNotNull(){
        new FutureService()
                .sendFutureRequest("Malaga", "2025-04-01")
                .then()
                .statusCode(200)
                .body("forecast.forecastday.day.condition.text", Matchers.notNullValue());
    }
}
