package com.hillel.selenide.automation;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by alpa on 5/10/20
 */
public class HomePage {

    @Step("User with {email} should be logged in")
    public HomePage userShouldBeLoggedIn(String userName) {
        $("[href='#@" +userName+"']").shouldBe(Condition.visible);
        return this;
    }

    public HomePage clickNewPost() {
       $("[href='#editor']").click();
        return new HomePage();
    }



}
