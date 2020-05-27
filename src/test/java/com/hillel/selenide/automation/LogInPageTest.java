package com.hillel.selenide.automation;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import static com.codeborne.selenide.Selectors.byCssSelector;


public class LogInPageTest extends TestBase{

    private LoginPage loginPage = new LoginPage();

    @BeforeMethod
    public void setUp(){
        open(Configuration.baseUrl);
    }

    @Test
    public void logInPageOpen() {
        open("https://react-redux.realworld.io/");

        SelenideElement selenideElement = $(byCssSelector("a[href='#login']"));
        selenideElement.click();
        $(byText("Sign in")).shouldBe(Condition.visible);

    }

//        @Test
//        public void emailFieldCheck() {
//            open("https://react-redux.realworld.io/");
//
//            SelenideElement selenideElement = $(byCssSelector("a[href='#login']"));
//            selenideElement.click();
//
//            $(byCssSelector("input[type='email']\"")).shouldBe(Condition.visible);
//
//        }
//
//    @Test
//    public void passwordFieldCheck() {
//        open("https://react-redux.realworld.io/");
//
//        SelenideElement selenideElement = $(byCssSelector("a[href='#login']"));
//        selenideElement.click();
//
//        $(byCssSelector("input[type='password']\"")).shouldBe(Condition.visible);
//
//    }

    @Test
    public void clickSingInButtonEmailAnaPasswordEmpty() {
        open("https://react-redux.realworld.io/");

        SelenideElement selenideElement = $(byCssSelector("a[href='#login']"));
        selenideElement.click();

        loginPage.clickSingInButton();

        $((".error-messages>li")).shouldHave(exactText("email or password is invalid"));


    }
    @Test
    public void incorrectEmail() {
        String userName="evgenpetrovich2123";
        String email ="1@1";
        String password ="test123321123";

        loginPage
                .openPage()
                .login(email,password);


        $((".error-messages>li")).shouldHave(exactText("email or password is invalid"));
    }

    @Test
    public void incorrectPassword() {
        String email ="evgenpetrovich2123@mail.com";
        String password ="111";

        loginPage
                .openPage()
                .login(email,password);


        $((".error-messages>li")).shouldHave(exactText("email or password is invalid"));
    }

    @Test
    public void loginTest() {
       String userName="evgenpetrovich2123";
       String email ="evgenpetrovich2123@mail.com";
       String password ="test123321123";

       loginPage
               .openPage()
               .login(email,password)
               .userShouldBeLoggedIn(userName);

    }

    }

