package ru.mobimed.tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class ChangeLanguageTests extends TestBase {
  @Test
  @Description("Изменить язык на английский")
  @DisplayName("Change language to English")
  @Tag("mobimed")
  void changeLanguageToEnglishTest() {
    step("Выбрать английский язык", () -> {
      $("span.MuiIconButton-label .MuiTypography-body1").click();
      $(".MuiMenu-list").$$("p.MuiTypography-body1").findBy(text("en")).click();
    });

    step("Проверить отображение заголовка на английском", () -> {
      $(".MuiTypography-h3", 0).shouldHave(text("Sign up to a specialist"));
    });
  }

  @Test
  @Description("Изменить язык на русский")
  @DisplayName("Change language to Russian")
  @Tag("mobimed")
  void changeLanguageToRussianTest() {
    step("Выбрать русский язык", () -> {
      $("span.MuiIconButton-label .MuiTypography-body1").click();
      $(".MuiMenu-list").$$("p.MuiTypography-body1").findBy(text("ru")).click();
    });

    step("Проверить отображение заголовка на русском", () -> {
      $(".MuiTypography-h3", 0).shouldHave(text("Записаться к специалисту"));
    });
  }

  @Test
  @Description("Изменить язык на французский")
  @DisplayName("Change language to French")
  @Tag("mobimed")
  void changeLanguageToFrenchTest() {
    step("Выбрать французский язык", () -> {
      $("span.MuiIconButton-label .MuiTypography-body1").click();
      $(".MuiMenu-list").$$("p.MuiTypography-body1").findBy(text("fr")).click();
    });

    step("Проверить отображение заголовка на французском", () -> {
      $(".MuiTypography-h3", 0).shouldHave(text("Inscrivez-vous chez un professionnel de santé"));
    });
  }
}
