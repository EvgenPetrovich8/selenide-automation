package com.hillel.selenide.automation;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
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

    @Test
    public void logInPageOpen() {
        open("https://react-redux.realworld.io/");

        SelenideElement selenideElement = $(byCssSelector("a[href='#login']"));
        selenideElement.click();
        $(byText("Sign in")).shouldBe(Condition.visible);

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setVersion("83");
        capabilities.setPlatform(Platform.LINUX);

//        ChromeOptions options = new ChromeOptions();
//        options.setCapability("browserName","chrome");
//        options.setCapability("version","83");
//        options.setCapability("platform","linux");


//        http://localhost:4444/wd/hub
//        WebDriver driver = new RemoteWebDriver(capabilities);

    }


}
