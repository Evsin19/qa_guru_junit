package tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class JavaRushTests extends BaseTest {

    @CsvSource(value = {
            "Русский , Начать обучение",
            "Українська , Почати навчання"
    })
    @ParameterizedTest(name = "Проверить, что при языке интерфейса {0} на кнопке присутствует надпись {1}")
    void javaRushSiteShouldStartButtonsV1(String language, String button) {
        open("https://javarush.com/");
        $(".language-switcher-item").scrollIntoView(true).click();
        $(".language-switcher").$(byText(language)).click();
        $(".header__start").shouldHave(text(button));
    }


    @CsvFileSource(resources = "/data_test/javaRushSiteShouldStartButtonsV2.csv")
    @ParameterizedTest(name = "Проверить, что при языке интерфейса {0} на кнопке присутствует надпись {1}")
    void javaRushSiteShouldStartButtonsV2(String language, String button) {
        open("https://javarush.com/");
        $(".language-switcher-item").scrollIntoView(true).click();
        $(".language-switcher").$(byText(language)).click();
        $(".header__start").shouldHave(text(button));
    }


    static Stream<Arguments> javaRushSiteShouldStartButtonsV3() {
        return Stream.of(
                Arguments.of(
                        "Русский",
                        "Начать обучение"
                ),
                Arguments.of(
                        "Українська" ,
                        "Почати навчання"
                )
        );
    }

    @MethodSource
    @ParameterizedTest(name = "Проверить, что при языке интерфейса {0} на кнопке присутствует надпись {1}")
    void javaRushSiteShouldStartButtonsV3(String language, String button) {
        open("https://javarush.com/");
        $(".language-switcher-item").scrollIntoView(true).click();
        $(".language-switcher").$(byText(language)).click();
        $(".header__start").shouldHave(text(button));
    }


}
