package tests.android;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static com.codeborne.selenide.Selenide.back;

@Tag("Android")
public class WikipediaTests extends TestBase {
    String searchValue = "Appium";

    @Disabled
    @Test
    @DisplayName("Check that query response is not empty")
    void successfulSearchAppiumTest() {
        back();
        mainScreen.openSearchPage();
        searchScreen.searchValue(searchValue)
                .checkResultsQuantity();
    }

    @Disabled
    @Test
    @DisplayName("Open first result of query")
    void successfulSearchSelenideTest() {
        back();
        mainScreen.openSearchPage();
        searchScreen.searchValue(searchValue)
                .checkResultsQuantity();
        searchResultScreen.openFirstSearchResult()
                .checkErrorText();
    }

    @Test
    @DisplayName("Check Onboarding screens")
    void onboardingScreensTest() {
        //first screen
        onboardingScreen
                .checkHeader("The Free Encyclopedia\n" +
                        "…in over 300 languages")
                .checkText("We’ve found the following on your device:")
                .checkLanguageList("1.\t\tEnglish")
                .checkAddLanguageButton()
                .checkGetStartedButtonNotVisible()
                .checkSkipContinueVisible()
                .goNextScreen()

                //second screen
                .checkHeader("New ways to explore")
                .checkText("Dive down the Wikipedia rabbit hole with a constantly updating Explore feed. " +
                        "\nCustomize the feed to your interests – whether it’s learning about historical events " +
                        "On this day, or rolling the dice with Random.")
                .checkGetStartedButtonNotVisible()
                .checkSkipContinueVisible()
                .goNextScreen()

                //third screen
                .checkHeader("Reading lists with sync")
                .checkText("You can make reading lists from articles you want to read later, even when you’re offline. " +
                        "\nLogin to your Wikipedia account to sync your reading lists. Join Wikipedia")
                .checkGetStartedButtonNotVisible()
                .checkSkipContinueVisible()
                .goNextScreen()

                //four screen
                .checkHeader("Data & Privacy")
                .checkText("We believe that you should not have to provide personal information to " +
                        "participate in the free knowledge movement. Usage data collected for this app is anonymous. " +
                        "Learn more about our privacy policy and terms of use.")
                .checkGetStartedButtonVisible()
                .checkSkipContinueNotVisible()
                .getStarted();
    }
}
