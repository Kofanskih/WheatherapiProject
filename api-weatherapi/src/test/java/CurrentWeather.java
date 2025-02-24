import com.wheatherapi.service.CurrentService;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class CurrentWeather {

    @Test
    public void verifyCurrentCountryV2(){
        new CurrentService().sendGetCurrentRequest("Madrid")
                .then().statusCode(200)
                .body("location.country",containsString("Spain"));
    }

    @Test
    public void verifyCurrentConditionTextIsNotNull(){
        new CurrentService().sendGetCurrentRequest("Benidorm")
                .then().statusCode(200)
                .body("current.condition.text", notNullValue());
    }
}
