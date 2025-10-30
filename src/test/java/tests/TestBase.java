package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import drivers.BrowserstackDriver;
import drivers.EmulatorDriver;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class TestBase {

    static String launchPlatform = System.getProperty("launchPlatform");

    @BeforeAll
    static void beforeAll() {
        if (launchPlatform.equals("browserstack")) {
            Configuration.browser = BrowserstackDriver.class.getName();
        } else {
            Configuration.browser = EmulatorDriver.class.getName();
        }
        Configuration.browserSize = null;
    }

    @BeforeEach
    void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    void addAttachments() {
        if (launchPlatform.equals("browserstack")) {
            String sessionId = Selenide.sessionId().toString();
            Attach.pageSource();
            closeWebDriver();
            Attach.addVideo(sessionId);
        } else {
            Attach.pageSource();
            closeWebDriver();
        }
    }

}
