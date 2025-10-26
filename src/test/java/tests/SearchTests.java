package tests;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.*;
import static io.qameta.allure.Allure.step;

public class SearchTests extends TestBase {

    @Test
    void successfulSearchTest() {
        step("Type search", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Appium");
        });
        step("Verify content found", () ->
                $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(sizeGreaterThan(0)));
    }

    @Test
    void openArticleAndroidTest() {
        step("Type search", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Moon");
        });
        step("Open article 'Moon' from search results", () -> {
            $$(byClassName("android.widget.TextView"))
                    .find(text("Moon")).click();
        });
        sleep(10000);
        step("Verify article subtitle is visible", () -> {
            $(id("org.wikipedia.alpha:id/view_page_subtitle_text"))
                    .shouldHave(text("Earth's natural satellite"));
        });

        /*
        step("Open First Article", () -> {
            SelenideElement firstResultGroup = $(
                    "//android.view.ViewGroup[./android.widget.TextView[@index='0' and @text='Christina Aguilera']]"
            );
            firstResultGroup.click();
        });
        step("Verify article is Opened", () -> {
            $(id("org.wikipedia.alpha:id/pcs"))
                    .$$("android.widget.TextView")  // берём вложенный LinearLayout
                    .first()                            // он у тебя один
                    .$$("android.widget.TextView")      // находим TextView внутри него
                    .get(0)                             // первый (и нужный)
                    .shouldHave(text("Christina Aguilera"));
        });

         */
    }
}