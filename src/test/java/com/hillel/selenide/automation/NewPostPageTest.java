package com.hillel.selenide.automation;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.hillel.selenide.automation.config.UserConfiguration;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hillel.selenide.automation.HomePage;
import com.hillel.selenide.automation.LoginPage;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;




public class NewPostPageTest extends TestBase{

   private LoginPage loginPage = new LoginPage();
    private NewPostPage newPostPage = new NewPostPage();
    private HomePage homePage = new HomePage();
    private ArticleDetailsPage articleDetailsPage = new ArticleDetailsPage();
    private UserConfiguration userConfiguration = ConfigFactory.create(UserConfiguration.class);

    @BeforeMethod
    public void setUp(){
        open(Configuration.baseUrl);
    }

//@Test
//    public void newPostPageOpen() {
//        open("https://react-redux.realworld.io/");
//
//
//        String userName= userConfiguration.name();
//        String userEmail= userConfiguration.email();
//        String userPassword= userConfiguration.password();
//
//        String articleTitle = "ArticleTitle";
//        String articleAbout ="article about test";
//        String article ="This is my article about the Selenide";
//
//        loginPage
//                .openPage()
//                .login(userEmail,userPassword)
//                .userShouldBeLoggedIn(userName);
//        homePage
//                .clickNewPost();
//
//              newPostPage
//               .fillAtricleFieldsAndSave(articleTitle,articleAbout,article);
//
//              assertThat(articleDetailsPage.articleShouldBeCreated()).isTrue();
//
//
//
//    }

    @Test
    public void articleIsCreated() {
        open("https://react-redux.realworld.io/");

        SelenideElement selenideElement = $(byCssSelector("a[href='#login']"));
        selenideElement.click();
        $(byText("Sign in")).shouldBe(Condition.visible);

        String userName= userConfiguration.name();
        String userEmail= userConfiguration.email();
        String userPassword= userConfiguration.password();

        String articleTitle = "ArticleTitle";
        String articleAbout ="article about test";
        String article ="This is my article about the Selenide";

        loginPage
                .openPage()
                .login(userEmail,userPassword)
                .userShouldBeLoggedIn(userName);
        homePage
                .clickNewPost();

        newPostPage
                .fillAtricleFieldsAndSave(articleTitle,articleAbout,article);

      $(byCssSelector(".banner h1")).shouldHave(exactText("ArticleTitle"));





    }


}
