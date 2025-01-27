package helpers;

import java.net.MalformedURLException;
import java.net.URL;

import static config.ConfigCreator.config;
import static io.restassured.RestAssured.given;


public class BrowserstackVideoHelper {

    public static URL getBrowserstackUrl() {
        try {
            return new URL("https://" + config.login() + ":" + config.password() + "@hub-cloud.browserstack.com/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public static String videoUrl(String sessionId) {
        String url = String.format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);

        return given()
                .auth().basic(config.login(), config.password())
                .get(url)
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().path("automation_session.video_url");
    }
}
