package com.hillel.selenide.automation;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by alpa on 5/10/20
 */
public class HomePage {


    public HomePage userShouldBeLoggedIn(String userName) {
        $("[href='#@" +userName+"']").shouldBe(Condition.visible);
        return this;
    }

//    public NewPostPage clickNewPost() {
//        $("[href='#editor']")).click();
//        return new NewPostPage();
//    }



}
