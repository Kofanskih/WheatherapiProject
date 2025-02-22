package com.weatherapi.ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {
    private final SelenideElement emailField = $("[id=\"ctl00_MainContentHolder_Login1_UserName\"]");
    private final SelenideElement passwordField = $("[id=\"ctl00_MainContentHolder_Login1_Password\"]");
    private final SelenideElement loginButton = $("[id=\"ctl00_MainContentHolder_Login1_LoginButton\"]");
    private final SelenideElement warningMessageElement = $x("//span[@id=\"ctl00_MainContentHolder_Login1_FailureText\"]");

    public LoginPage fillEmailField(String email) {
        emailField.setValue(email);
        return new LoginPage();
    }

    public LoginPage fillPasswordField(String password) {
        passwordField.setValue(password);
        return new LoginPage();
    }

    public PersonalPage clickLoginButton() {
        loginButton.click();
        return new PersonalPage();
    }
    public PersonalPage fillLoginData(String email, String password) {
        emailField.setValue(email);
        passwordField.setValue(password);
        loginButton.click();
        return new PersonalPage();
    }

    public LoginPage fillLoginFormWithWrongPassword(String email, String wrongPassword){
        emailField.setValue(email);
        passwordField.setValue(wrongPassword);
        loginButton.click();
        return new LoginPage();
    }

    public LoginPage fillLoginFormWithWrongEmail(String wrongEmail, String password){
        emailField.setValue(wrongEmail);
        passwordField.setValue(password);
        loginButton.click();
        return new LoginPage();
    }

    public LoginPage checkWarningLoginMessage(String warningMessage){
        warningMessageElement.shouldHave(Condition.exactText(warningMessage));
        return this;
    }



}
