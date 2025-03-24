package com.weatherapi.ui.pageModels;

import lombok.Data;

@Data
public class LoginUserPageModel {
    private String USER_EMAIL;
    private String USER_PASSWORD;

    public LoginUserPageModel userLogin(){
        this.USER_EMAIL = "kofanskih08@gmail.com";
        this.USER_PASSWORD = "f2H*Jap*M6@7/d_";
        return this;
    }

    public LoginUserPageModel userLoginWithWrongEmail(){
        this.USER_EMAIL = "kofanski08@gmail.com";
        this.USER_PASSWORD = "f2H*Jap*M6@7/d_";
        return this;
    }

    public LoginUserPageModel userLoginWithWrongPassword(){
        this.USER_EMAIL = "kofanskih08@gmail.com";
        this.USER_PASSWORD = "f2H*Jap*M6@7/d_1";
        return this;
    }


}
