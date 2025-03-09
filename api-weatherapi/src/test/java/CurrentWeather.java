import com.wheatherapi.service.CurrentService;
import org.testng.annotations.Test;

import java.io.IOException;

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
}
