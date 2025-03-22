package com.weatherapi.ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.weatherapi.ui.pageModels.LoginUserPageModel;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {
    private final SelenideElement emailField = $("[id=\"ctl00_MainContentHolder_Login1_UserName\"]");
    private final SelenideElement passwordField = $("[id=\"ctl00_MainContentHolder_Login1_Password\"]");
    private final SelenideElement loginButton = $("[id=\"ctl00_MainContentHolder_Login1_LoginButton\"]");
    private final SelenideElement warningMessageElement = $("[id=\"ctl00_MainContentHolder_Login1_FailureText\"]");

    public PersonalPage fillLoginDataWithUserModel(LoginUserPageModel loginUserPageModel) {
        emailField.setValue(loginUserPageModel.getUSER_EMAIL());
        passwordField.setValue(loginUserPageModel.getUSER_PASSWORD());
        loginButton.click();
        return new PersonalPage();
    }

    public LoginPage fillLoginFormWithWrongPassword(LoginUserPageModel loginUserPageModel){
        emailField.setValue(loginUserPageModel.getUSER_EMAIL());
        passwordField.setValue(loginUserPageModel.getUSER_PASSWORD());
        loginButton.click();
        return new LoginPage();
    }

    public LoginPage fillLoginFormWithWrongEmail(LoginUserPageModel loginUserPageModel){
        emailField.setValue(loginUserPageModel.getUSER_EMAIL());
        passwordField.setValue(loginUserPageModel.getUSER_PASSWORD());
        loginButton.click();
        return new LoginPage();
    }

    public LoginPage checkWarningLoginMessage(String warningMessage){
        warningMessageElement.shouldHave(Condition.text(warningMessage));
        return this;
    }



}
