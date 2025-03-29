package steps;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.asserts.Assertion;

import static com.codeborne.selenide.Selenide.$x;

public class KlavagonkiStep {
    private final SelenideElement CLOSE_BUTTON = $x("//input[@value=\"Закрыть\"][@onclick=\"$('howtoplay').hide();\"]");
    private final SelenideElement START_GAME_BUTTON = $x("//a[@id=\"host_start\"]");
    private final SelenideElement HIGHLIGHTED_WORD = $x("//span[@id=\"typefocus\"]");
    private final SelenideElement INPUT_FIELD = $x("//input[@id=\"inputtext\"]");
    private final SelenideElement AFTER_FOCUS = $x("//span[@id=\"afterfocus\"]");
    private final SelenideElement RESULT_TEXT = $x("//td[text()='Это вы']//ancestor-or-self::div//div[@class='stats']//div[2]/span/span");

    private String getCurrentWord(){
        return HIGHLIGHTED_WORD.getText().replaceAll("с", "c").replaceAll("о", "o");

    }


    @When("Start the game")
    public void startTheGame(){
        CLOSE_BUTTON.click();
        if(START_GAME_BUTTON.isDisplayed()){
            START_GAME_BUTTON.click();
        }

    }

    @And("Wait for the game start")
    public void waitForTheGameStart(){
        HIGHLIGHTED_WORD.click();

    }

    @And("Enter highlighted word in cicle")
    public void playGame(){
        while(true){
            String currentWord = getCurrentWord();
            String afterFocusSymbol = AFTER_FOCUS.getText();
            INPUT_FIELD.sendKeys(currentWord);
            if (afterFocusSymbol.equals(".")){
                INPUT_FIELD.sendKeys(".");
                break;
            }
            INPUT_FIELD.sendKeys(Keys.SPACE);

        }

    }

//    @Then("Track the game is over and characters per minute more than (\\d+)")
//    public void theGameIsOver(int minValue){
//        String result = RESULT_TEXT.getText();
//        int resultNumber = Integer.parseInt(result);
//        System.out.println("Characters per minute: " + resultNumber);
//        Assert.assertTrue(resultNumber > minValue, "Actual value is " + resultNumber);
//    }

    @Then("Track the game is over and characters per minute more than {int}")
    public void theGameIsOver(int minValue){
        String result = RESULT_TEXT.getText();
        int resultNumber = Integer.parseInt(result);
        System.out.println("Characters per minute: " + resultNumber);
        Assert.assertTrue(resultNumber > minValue, "Actual value is " + resultNumber);
    }
}
