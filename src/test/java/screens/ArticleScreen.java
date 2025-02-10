package screens;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.back;
import static io.appium.java_client.AppiumBy.id;

public class ArticleScreen {
    private final SelenideElement saveArticleButton = $(id("org.wikipedia.alpha:id/page_save")),
    savedToolbar = $(id("org.wikipedia.alpha:id/snackbar_text"));

    @Step("Save article")
    public ArticleScreen saveArticle(){
        saveArticleButton.click();
        return this;
    }

    @Step("Get back from article")
    public ArticleScreen goBack(){
        back();
        return this;
    }
    
}
