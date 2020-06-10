package com.hillel.selenide.automation;


import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.*;

public class LoginPage extends HomePage{

//   private static Logger LOG = LoggerFactory.getLogger(LoginPage.class);


    @Step("Open Login Page")
    public LoginPage openPage() {
        $(byAttribute("href","#login")).shouldBe(Condition.visible).click();
        return this;
    }

 @Step("Login as user")
   public HomePage login(String email, String password) {
        System.out.println("Login as user");
        inputEmail(email);
        inputPassword(password);
       return clickSingInButton();
    }

    public void inputEmail(String email) {
        System.out.println("Input email");
        $("input[type='email']").setValue(email);

    }

    public void inputPassword(String password) {
        System.out.println("Input password");
        $("input[type='password']").setValue(password);

    }

//    public String getPageTitle() {
//        return driver.findElement(By.cssSelector(".auth-page h1")).getText();
//    }
//
   @Step("Click Sign In button")
   public HomePage clickSingInButton() {
        System.out.println("Click Sing In button");
        $("button[type='submit']").click();
        return new HomePage();
    }

}
