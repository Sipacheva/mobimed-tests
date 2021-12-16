package ru.mobimed.tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

public class MedicalRecordTests extends TestBase{
  @Test
  @Description("Проверка наличия записи в медкарте")
  @DisplayName("Check consultation")
  @Tag("mobimed")
  void checkConsultationTest() {
    step("Перейти на страницу 'Медкарта'",() -> {
      $$(".MuiTab-wrapper").findBy(text("Медкарта")).click();

    });

    step("Проверить наличие записи за 22 декабря",() -> {
      $(".MuiGrid-grid-xs-true").shouldBe(visible, Duration.ofSeconds(10));
      $$(".MuiGrid-grid-xs-true").shouldHave(itemWithText("22\n" +
              "декабря\n" +
              "12:51"));
    });
  }
}
