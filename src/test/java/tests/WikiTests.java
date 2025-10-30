package tests;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.*;
import static io.qameta.allure.Allure.step;

@Owner("kenzinaAA")
@DisplayName("Тестирование мобильного-приложения Wikipedia")
public class WikiTests extends TestBase {

    @DisplayName("Успешный поиск легальной статьи")
    @Tag("BLOKER")
    @Feature("Поиск")
    @Test
    void successfulSearchTest() {
        step("Набрать в поисковой строке 'Appium'", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Appium");
        });
        step("Убедиться, что нашлась хотя бы одна статья", () ->
                $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(sizeGreaterThan(0)));
    }

    @DisplayName("Неуспешный поиск нелегальной статьи")
    @Tag("BLOKER")
    @Feature("Поиск")
    @Test
    void unsuccessfulSearchTest() {
        step("Набрать в поисковой строке 'abaracadabarada'", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("abaracadabarada");
        });
        step("Убедиться, что не нашлась ни одна статья", () ->
                $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(size(0)));
    }

    @DisplayName("Проверка актуальности даты статей на главной странице")
    @Tag("MINOR")
    @Feature("Главная страница")
    @Test
    void verifyFullDateHeaderText() {

        // Формируем строку вида "Oct 30, 2025" с текущей датой
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM d, yyyy", Locale.ENGLISH);
        String expectedDate = today.format(formatter);

        step("Проверить, что на главной странице у статей дня отображается текущая дата: " + expectedDate, () -> {
            $x("//android.widget.TextView[@text='" + expectedDate + "']").shouldBe(visible);
        });
    }

    @DisplayName("Переход на статью из поиска")
    @Tag("CRITICAL")
    @Feature("Поиск")
    @Test
    void openArticleAndroidTest() {
        step("Набрать 'Selenium' в поисковой строке", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Selenium");
        });
        step("Убедиться, что в результатах поиска нашлась статья 'Selenium (software)'", () -> {
            $$(byClassName("android.widget.TextView"))
                    .find(text("Selenium (software)")).click();
        });
        step("Проверить переход на страницу со статьей", () ->
                $(id("org.wikipedia.alpha:id/view_wiki_error_text")).isDisplayed());
    }

    @DisplayName("Проверка новостного блока на главной странице")
    @Tag("MINOR")
    @Feature("Главная страница")
    @Test
    void Tester() {
        String newsTitle = step("Сохранить заголовок первого новостного блока и перейти на него", () -> {
            SelenideElement newsFirst = $$(id("org.wikipedia.alpha:id/horizontal_scroll_list_item_text"))
                    .first();
            newsFirst.shouldBe(visible).click();
            return newsFirst.text();
        });
        step("Убедиться, что заголовок '" + newsTitle + "' открывшейся страницы совпадает с заголовком новостного блока", () ->
                $(id("org.wikipedia.alpha:id/view_news_fullscreen_story_text")).shouldHave(text(newsTitle))
        );
    }
}