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

public class MapTests extends TestBase{
  @Test
  @Description("Проверка наличия карты")
  @DisplayName("Check map")
  @Tag("mobimed")
  void openMapTest() {
    $$(".MuiTab-wrapper").findBy(text("На карте")).click();
    $("[aria-label=\"Map\"]").shouldBe(visible, Duration.ofSeconds(10));
  }
}
