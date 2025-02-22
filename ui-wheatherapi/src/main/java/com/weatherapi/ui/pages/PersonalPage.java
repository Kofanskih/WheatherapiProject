package com.weatherapi.ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class PersonalPage {
    private final SelenideElement personalAccount = $x("//h2[@class=\"view-title\"]");
    private final SelenideElement logoutButton = $("[href=\"/logout.aspx\"]");


    public PersonalPage userShouldHaveExactTextOnTheAccountPage(String personalAccountText){
        personalAccount.shouldHave(Condition.exactTextCaseSensitive(personalAccountText));
        return new PersonalPage();
    }

    public MainPage logout(){
        logoutButton.click();
        return new MainPage();
    }


}
