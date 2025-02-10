package tests.android;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static com.codeborne.selenide.Selenide.back;

@Tag("remote")
public class WikiRemoteTests extends TestBase {
    String searchValue = "Appium";

    @Test
    @DisplayName("Check that query response is not empty")
    void successfulSearchAppiumTest() {
        mainScreen.openSearchPage();
        searchScreen.searchValue(searchValue)
                .checkResultsQuantity();
    }

    @Test
    @DisplayName("Open first result of query")
    void successfulSearchTest() {
        mainScreen.openSearchPage();
        searchScreen.searchValue(searchValue)
                .checkResultsQuantity();
        searchResultScreen.openFirstSearchResult()
                .checkErrorText();
    }

    @DisplayName("Save article")
    @Test
    void saveArticleTest(){
        String searchValue = "Appium";

        back();
        mainScreen.openSearchPage();
        searchScreen.searchValue(searchValue);
        searchResultScreen.openFirstSearchResult();
        articleScreen.saveArticle()
                .goBack();
        searchResultScreen.pressBack();
        mainScreen.goToSavedSection();
        savedScreen.openFirstGroup()
                .checkArticleByName(searchValue);
    }
}
