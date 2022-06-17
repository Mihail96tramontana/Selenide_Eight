package selenide;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideAutotest {

    static void beforeAll() {
        Configuration.baseUrl = "https://github.com/";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

        @Test
        @DisplayName("Проверка наличия кода для JUnit5")
        void searhCode() {

        // Открыть страницу Selenide в Github
        open("https://github.com/selenide/selenide");

        //Перейти в раздел Wiki проекта
        $("#wiki-tab").click();

        // Убедиться, что в списке страниц (Pages) есть страница SoftAssertions
        $("#wiki-pages-filter").val("SoftAssertions").pressEnter();
        $(".wiki-pages-box").shouldHave(text("SoftAssertions"));

        //Открыть страницу SoftAssertions, проверить, что внутри есть пример кода для JUnit5
            $(byText("SoftAssertions")).click();
            $("#user-content-3-using-junit5-extend-test-class").ancestor("h4")
                    .shouldHave(text("3. Using JUnit5 extend test class:"));
    }
}