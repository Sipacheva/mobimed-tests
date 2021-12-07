package ru.mobimed.tests;

import org.openqa.selenium.Keys;
import ru.mobimed.config.demowebshop.App;
import ru.mobimed.helpers.DriverUtils;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;


public class LoginTests extends TestBase {
    @Test
    @Description("Вход в систему")
    @DisplayName("Login test")
    void loginTest() {
        step("Открыть страницу 'https://dev.mobimed.ru/'", () -> {
            open("https://dev.mobimed.ru/");
        });

        step("Ввести логин и пароль, войти в систему", () -> {
            $("[name=\"login\"]").click();
            $("[name=\"login\"]").sendKeys((Keys.chord(Keys.CONTROL, "a")));
            $("[name=\"login\"]").sendKeys(App.config.userLogin());
            $("[name=\"password\"]").click();
            $("[name=\"password\"]").sendKeys((Keys.chord(Keys.CONTROL, "a")));
            $("[name=\"password\"]").sendKeys(App.config.userPassword());
            $(byText("Вход в систему"), 1).click();
        });

        step("Проверить успешный вход в систему", () -> {
            $("header").shouldHave(text("Ермаков Сергей Алексеевич"));
        });
    }

    @Test
    @Description("Autogenerated test")
    @DisplayName("Page console log should not have errors")
    void consoleShouldNotHaveErrorsTest() {
        step("Open url 'https://dev.mobimed.ru/'", () ->
            open("https://dev.mobimed.ru/"));

        step("Console logs should not contain text 'SEVERE'", () -> {
            String consoleLogs = DriverUtils.getConsoleLogs();
            String errorText = "SEVERE";

            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }
}