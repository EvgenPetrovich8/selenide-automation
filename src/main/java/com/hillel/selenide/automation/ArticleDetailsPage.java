package com.hillel.selenide.automation;

import org.openqa.selenium.By;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.*;


public class ArticleDetailsPage extends NewPostPage{

   private By articlePage = byCssSelector(".article-page");

    public boolean articleShouldBeCreated() {
        $(articlePage).shouldBe(Condition.visible);
        return true;


    }


}
