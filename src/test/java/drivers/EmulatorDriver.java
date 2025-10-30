package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.BrowserStackConfig;
import config.EmulatorConfig;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import javax.annotation.Nonnull;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import static io.appium.java_client.remote.AutomationName.ANDROID_UIAUTOMATOR2;
import static io.appium.java_client.remote.MobilePlatform.ANDROID;
import static org.apache.commons.io.FileUtils.copyInputStreamToFile;

public class EmulatorDriver implements WebDriverProvider {

    static EmulatorConfig config = ConfigFactory.create(EmulatorConfig.class, System.getProperties());

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {

        UiAutomator2Options automatorOptions = new UiAutomator2Options();

        automatorOptions.merge(capabilities);
        automatorOptions
                .setAutomationName(ANDROID_UIAUTOMATOR2)
                .setPlatformName(ANDROID)
                .setPlatformVersion(config.osVersion())
                .setDeviceName(config.device())
                .setApp(appPath())
                .setAppPackage("org.wikipedia.alpha")
                .setAppActivity("org.wikipedia.main.MainActivity");

        try {
            return new AndroidDriver(new URL(config.serverUrl()), automatorOptions);
        } catch (MalformedURLException e) {
            return null;
        }
    }

    private String appPath() {
        String appUrl = "https://github.com/wikimedia/apps-android-wikipedia/releases/download/latest/app-alpha-universal-release.apk";
        String appFolder = "src/test/resources/apps/app-alpha-universal-release.apk";
        File appFile = new File(appFolder);
        if (!appFile.exists()) {
            try (InputStream in = new URL(appUrl).openStream()) {
                copyInputStreamToFile(in, appFile);
            } catch (IOException e) {
                return null;
            }
        }
        return appFile.getAbsolutePath();
    }

}