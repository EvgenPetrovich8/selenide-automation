package com.hillel.selenide.automation;


import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.*;

public class LoginPage extends HomePage{


    public LoginPage openPage() {
        $(byAttribute("href","#login")).shouldBe(Condition.visible).click();
        return this;
    }

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
   public HomePage clickSingInButton() {
        System.out.println("Click Sing In button");
        $("button[type='submit']").click();
        return new HomePage();
    }

}
