package tests.android;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static com.codeborne.selenide.Selenide.back;

@DisplayName("Emulation test for Wikipedia")
@Owner("Kseniia Kuznetsova")
@Feature("Testing Wikipedia app on emulated device")
@Tag("local")
public class WikiLocalTests extends TestBase {

    @Test
    @DisplayName("Check Onboarding screens")
    @Story("Onboarding screen testing")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("Positive")
    void onboardingScreensTest() {
        //first screen
        onboardingScreen
                .checkHeader(textsData.firstPageHeader)
                .checkText(textsData.firstPageText)
                .checkLanguageList(textsData.firstPageLanguages)
                .checkAddLanguageButton()
                .checkGetStartedButtonNotVisible()
                .checkSkipContinueVisible()
                .goNextScreen()

                //second screen
                .checkHeader(textsData.secondPageHeader)
                .checkText(textsData.secondPageText)
                .checkGetStartedButtonNotVisible()
                .checkSkipContinueVisible()
                .goNextScreen()

                //third screen
                .checkHeader(textsData.thirdPageHeader)
                .checkText(textsData.thirdPageText)
                .checkGetStartedButtonNotVisible()
                .checkSkipContinueVisible()
                .goNextScreen()

                //four screen
                .checkHeader(textsData.fourthPageHeader)
                .checkText(textsData.fourthPageText)
                .checkGetStartedButtonVisible()
                .checkSkipContinueNotVisible()
                .getStarted();
    }

    @DisplayName("Save article")
    @Story("Testing of saving feature")
    @Severity(SeverityLevel.NORMAL)
    @Tag("Positive")
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

    @Test
    @DisplayName("Check that query response is not empty")
    @Story("Testing of search")
    @Severity(SeverityLevel.BLOCKER)
    @Tag("Positive")
    void successfulSearchAppiumTest() {
        String searchValue = "QA";

        back();
        mainScreen.openSearchPage();
        searchScreen.searchValue(searchValue)
                .checkResultsQuantity();
    }
}
