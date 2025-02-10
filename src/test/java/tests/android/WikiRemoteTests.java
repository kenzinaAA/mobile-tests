package tests.android;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.TestBase;

@DisplayName("Remote test for Wikipedia")
@Owner("Kseniia Kuznetsova")
@Feature("Testing Wikipedia app on remote service")
@Tag("remote")
public class WikiRemoteTests extends TestBase {
    String searchValue = "Appium";

    @Test
    @DisplayName("Check that query response is not empty")
    @Story("Testing of search")
    @Severity(SeverityLevel.BLOCKER)
    @Tag("Positive")
    void successfulSearchAppiumTest() {
        mainScreen.openSearchPage();
        searchScreen.searchValue(searchValue)
                .checkResultsQuantity();
    }

    @Test
    @DisplayName("Open first result of query")
    @Story("Testing of search")
    @Severity(SeverityLevel.BLOCKER)
    @Tag("Positive")
    void successfulSearchTest() {
        mainScreen.openSearchPage();
        searchScreen.searchValue(searchValue)
                .checkResultsQuantity();
        searchResultScreen.openFirstSearchResult()
                .checkErrorText();
    }

    @DisplayName("Check article short description")
    @Story("Testing of search")
    @Severity(SeverityLevel.MINOR)
    @Tag("Positive")
    @Test
    void checkDescriptionTest() {
        mainScreen.openSearchPage();
        searchScreen.searchValue(searchValue);
        searchResultScreen.checkArticleDescription(textsData.articleShortDescription);
    }
}
