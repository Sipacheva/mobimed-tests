package ru.mobimed.tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

public class VisitTests extends TestBase {
  @Test
  @Description("Запись на прием и удаление записи")
  @DisplayName("Запись на прием и удаление записи")
  @Tag("mobimed")
  void AddAndDeleteVisitTest() {
    step("Нажать 'Запись на приём', подождать, пока загрузится страница", () -> {
      $(byText("Запись на приём")).click();
      $(".MuiCard-root").shouldBe(visible, Duration.ofSeconds(10));
    });

    step("Ввести фамилию в поле Специальность или ФИО", () -> {
      $("input[type=text]", 0).click();
      $("input[type=text]", 0).setValue("иванов").pressEnter();
      $(".MuiCard-root", 0).shouldHave(text("Иванов Петр Сидорович"), Duration.ofSeconds(10));
    });

    step("Выбрать дату приёма", () -> {
      $("[aria-label='выбирете дату']").click();
      $$("button.MuiPickersDay-day:not(.MuiPickersDay-hidden)").findBy(text("30")).click();
    });

    step("Выбрать время приёма", () -> {
      $(byText("14:20")).click();
    });

    step("Записаться на приём и закрыть сообщение", () -> {
      $(byText("Записаться на приём")).click();
      $("div.MuiAlert-message", 1).shouldHave(text("Вы записаны на приём"), Duration.ofSeconds(10));
      $(byText("Закрыть"), 1).click();
    });

    step("Перейти в события и удалить запись", () -> {
      $$(".MuiTab-wrapper").findBy(text("Cобытия")).click();
      $$(".MuiGrid-root.MuiGrid-item.MuiGrid-grid-xs-12.MuiGrid-grid-sm-2")
              .findBy(text("30")).sibling(3).$(byText("Отменить")).click();
      $(".MuiDialogActions-root.MuiDialogActions-spacing", 1).shouldBe(visible, Duration.ofSeconds(10));
      $(".MuiDialogActions-root.MuiDialogActions-spacing", 1)
              .$(byText("Да")).click();
      $(byText("Закрыть"), 2).click();
    });

    step("Проверить, что есть текст Отменённый визит", () -> {
      $$("h6").shouldHave(itemWithText("Отмененный визит"));
    });
  }
}
