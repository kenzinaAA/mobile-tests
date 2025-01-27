package drivers;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import static config.ConfigCreator.config;
import static helpers.BrowserstackVideoHelper.getBrowserstackUrl;


public class BrowserstackDriver implements WebDriverProvider {
    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        if (config.os().equals("android")) {
            return getAndroidDriver();
        } else {
            return getIosDriver();
        }
    }

    private DesiredCapabilities commonCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("project", config.project());

        return capabilities;
    }

    private AndroidDriver getAndroidDriver() {
        DesiredCapabilities capabilities = commonCapabilities();
        capabilities.setCapability("deviceName", config.deviceModel());
        capabilities.setCapability("os_version", config.osVersion());
        capabilities.setCapability("app", config.appUrl());

        return new AndroidDriver(getBrowserstackUrl(), capabilities);
    }

    private IOSDriver getIosDriver() {
        DesiredCapabilities capabilities = commonCapabilities();
        capabilities.setCapability("deviceName", config.deviceModel());
        capabilities.setCapability("os_version", config.osVersion());
        capabilities.setCapability("autoAcceptAlerts", true);
        capabilities.setCapability("app", config.appUrl());

        return new IOSDriver(getBrowserstackUrl(), capabilities);
    }
}
