package ru.mobimed.tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

public class PrescribedDrugsTests extends TestBase{
  @Test
  @Description("Проверка наличия анальгина в прошедших назначениях")
  @DisplayName("Проверка наличия анальгина в прошедших назначениях")
  @Tag("mobimed")
  void checkPastPrescribedDrugs() {
    step("Перейти на страницу 'Назначения'",() -> {
      $$(".MuiTab-wrapper").findBy(text("Назначения")).click();
    });

    step("Перейти в раздел 'Прошедшие'",() -> {
      $("[aria-label=filterPrescribedDrug-tabs]").$("button", 1).click();
    });

    step("Проверить, что в назначениях есть анальгин",() -> {
      $$(".MuiGrid-grid-sm-6").findBy(text("АНАЛЬГИН")).shouldBe(visible, Duration.ofSeconds(10));
    });
  }
}
