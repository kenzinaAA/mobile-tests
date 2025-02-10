package tests.android;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static com.codeborne.selenide.Selenide.back;

@Tag("local")
public class WikiLocalTests extends TestBase {

    @Test
    @DisplayName("Check Onboarding screens")
    void onboardingScreensTest() {
        //first screen
        onboardingScreen
                .checkHeader(onboardingTextsData.firstPageHeader)
                .checkText(onboardingTextsData.firstPageText)
                .checkLanguageList(onboardingTextsData.firstPageLanguages)
                .checkAddLanguageButton()
                .checkGetStartedButtonNotVisible()
                .checkSkipContinueVisible()
                .goNextScreen()

                //second screen
                .checkHeader(onboardingTextsData.secondPageHeader)
                .checkText(onboardingTextsData.secondPageText)
                .checkGetStartedButtonNotVisible()
                .checkSkipContinueVisible()
                .goNextScreen()

                //third screen
                .checkHeader(onboardingTextsData.thirdPageHeader)
                .checkText(onboardingTextsData.thirdPageText)
                .checkGetStartedButtonNotVisible()
                .checkSkipContinueVisible()
                .goNextScreen()

                //four screen
                .checkHeader(onboardingTextsData.fourthPageHeader)
                .checkText(onboardingTextsData.fourthPageText)
                .checkGetStartedButtonVisible()
                .checkSkipContinueNotVisible()
                .getStarted();
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
