package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import drivers.BrowserstackDriver;
import drivers.LocalDriver;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import screens.*;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static helpers.Environment.isBrowserstack;
import static helpers.Environment.isEmulator;

public class TestBase {
    public MainScreen mainScreen = new MainScreen();
    public SearchScreen searchScreen = new SearchScreen();
    public SearchResultScreen searchResultScreen = new SearchResultScreen();
    public IosElements iosElements = new IosElements();
    public OnboardingScreen onboardingScreen = new OnboardingScreen();

    @BeforeAll
    static void beforeAll() {
        if (isBrowserstack) {
            Configuration.browser = BrowserstackDriver.class.getName();
        } else if (isEmulator) {
            Configuration.browser = LocalDriver.class.getName();
        } else {
            throw new RuntimeException("Unknown deviceHost was provided.");
        }
        Configuration.browserSize = null;
        Configuration.timeout = 30000;
    }

    @BeforeEach
    void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    void addAttachments() {
        String sessionId = Selenide.sessionId().toString();
        System.out.println(sessionId);

//        Attach.screenshotAs("Last screenshot"); // todo fix
        Attach.pageSource();
        closeWebDriver();

        Attach.addVideo(sessionId);
    }
}
