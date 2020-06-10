package com.hillel.selenide.automation;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.hillel.selenide.automation.config.UserConfiguration;
import io.qameta.allure.*;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import static com.codeborne.selenide.Selectors.byCssSelector;


@Feature("Authorization feature")
@Story("Login Story")
public class LogInPageTest extends TestBase{

    private LoginPage loginPage = new LoginPage();
    private UserConfiguration userConfiguration = ConfigFactory.create(UserConfiguration.class);

    @BeforeMethod
    public void setUp(){
        open(Configuration.baseUrl);
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    public void logInPageOpen() {
        open("https://react-redux.realworld.io/");

        SelenideElement selenideElement = $(byCssSelector("a[href='#login']"));
        selenideElement.click();
        $(byText("Sign in")).shouldBe(Condition.visible);

    }

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
        String email ="1@1";
        String userPassword= userConfiguration.password();

        loginPage
                .openPage()
                .login(email,userPassword);


        $((".error-messages>li")).shouldHave(exactText("email or password is invalid"));
    }

    @Test
    public void incorrectPassword() {
        String userEmail= userConfiguration.email();
        String password ="111";

        loginPage
                .openPage()
                .login(userEmail,password);


        $((".error-messages>li")).shouldHave(exactText("email or password is invalid"));
    }

    @Test
    public void loginTest() {
        String userName= userConfiguration.name();
        String userEmail= userConfiguration.email();
        String userPassword= userConfiguration.password();

       loginPage
               .openPage()
               .login(userEmail,userPassword)
               .userShouldBeLoggedIn(userName);

    }

    }

