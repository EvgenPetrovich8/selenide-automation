package com.hillel.selenide.automation;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.*;

import org.openqa.selenium.By;


public class NewPostPage {
    private By titleField = (By) $(".form-group:nth-child(1)>input");
    private By whatAboutField = (By) $(".form-group:nth-child(2)>input");
    private By articleBodyField = (By) $(".form-group:nth-child(3)>textarea");
    private By tagsField = (By) $(".form-group:nth-child(4)>input");
    private By publishArticleBtn = (By) $("[type='button']");


    public NewPostPage clickPublishArticleButton() {
        System.out.println("Click PublishArticle button");
        $("button[type='button']").click();
        return new NewPostPage();
    }

}
