package com.hillel.selenide.automation;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import static com.codeborne.selenide.Selectors.byCssSelector;

public class MainPageTest {

    @Test
    public void signInButtonCheck(){
        open("https://react-redux.realworld.io/");
        $(byCssSelector("a[href='#login']")).shouldBe(Condition.visible);
    }

    @Test
    public void signUpButtonCheck(){
        open("https://react-redux.realworld.io/");
        $(byCssSelector("a[href='#register']")).shouldBe(Condition.visible);
    }


}
