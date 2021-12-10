package ru.mobimed.tests;

import org.openqa.selenium.Keys;
import ru.mobimed.config.App;
import ru.mobimed.config.Project;
import ru.mobimed.helpers.AllureAttachments;
import ru.mobimed.helpers.DriverSettings;
import ru.mobimed.helpers.DriverUtils;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.junit5.AllureJunit5;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;


@ExtendWith({AllureJunit5.class})
public class TestBase {
    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        DriverSettings.configure();
    }

    @BeforeAll
    static void loginTest() {
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

    @AfterEach
    public void addAttachments() {
        String sessionId = DriverUtils.getSessionId();

        AllureAttachments.addScreenshotAs("Last screenshot");
        AllureAttachments.addPageSource();
//        AllureAttachments.attachNetwork(); // todo
        AllureAttachments.addBrowserConsoleLogs();

        Selenide.closeWebDriver();

        if (Project.isVideoOn()) {
            AllureAttachments.addVideo(sessionId);
        }
    }
}
