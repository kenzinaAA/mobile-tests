package config;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackDriver implements WebDriverProvider {
    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {

        BrowserStackConfig config = ConfigFactory.create(BrowserStackConfig.class, System.getProperties());

        MutableCapabilities caps = new MutableCapabilities();

        caps.setCapability("browserstack.user", config.user());
        caps.setCapability("browserstack.key", config.key());
        caps.setCapability("app", config.app());
        caps.setCapability("device", config.device());
        caps.setCapability("os_version", config.osVersion());
        /*
        caps.setCapability("project", "KenzinaAA_Diploma_Mobile");
        caps.setCapability("build", "Owner added");
        caps.setCapability("name", "Test Jenkins");
*/
        try {
            return new RemoteWebDriver(
                    new URL("https://hub.browserstack.com/wd/hub"), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
