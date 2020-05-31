package com.hillel.selenide.automation;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.*;

import org.openqa.selenium.By;


public class NewPostPage extends HomePage{
   private By titleField = byCssSelector(".form-group:nth-child(1)>input");
    private By whatAboutField = byCssSelector(".form-group:nth-child(2)>input");
   private By articleBodyField = byCssSelector(".form-group:nth-child(3)>textarea");
   private By tagsField = byCssSelector(".form-group:nth-child(4)>input");
   private By publishArticleBtn = byCssSelector("[type='button']");




    public ArticleDetailsPage clickPublishArticleButton() {
        System.out.println("Click PublishArticle button");
        $(publishArticleBtn).click();
        return new ArticleDetailsPage();
    }

    public void inputArticleTitle(String articleTitle) {
        System.out.println("Input articleTitle");
        $(".form-group:nth-child(1)>input").setValue(articleTitle);

    }

    public void inputArticle(String article) {
        System.out.println("Input article");
        $(whatAboutField).setValue(article);

    }

    public void inputArticleAbout(String articleAbout) {
        System.out.println("Input password");
        $(articleBodyField).setValue(articleAbout);

    }

    public ArticleDetailsPage fillAtricleFieldsAndSave (String articleTitle, String articleAbout, String article) {
        System.out.println("Fill article fields");
        inputArticleTitle(articleTitle);
        inputArticle(article);
        inputArticleAbout(articleAbout);
        return clickPublishArticleButton();
    }

}
