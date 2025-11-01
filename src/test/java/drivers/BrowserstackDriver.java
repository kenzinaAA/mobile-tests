package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.BrowserStackConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackDriver implements WebDriverProvider {

    static BrowserStackConfig config = ConfigFactory.create(BrowserStackConfig.class, System.getProperties());

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {

        DesiredCapabilities  caps = new DesiredCapabilities ();

        caps.setCapability("browserstack.user",  config.user());
        caps.setCapability("browserstack.key", config.key());
        caps.setCapability("app", config.app());

        caps.setCapability("device", config.device().replace("_", " "));
        caps.setCapability("os_version", config.osVersion());

        caps.setCapability("project", config.project());
        caps.setCapability("build", config.build());
        caps.setCapability("name", config.name());

        try {
            return new RemoteWebDriver(
                    new URL(config.baseUrl()), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
