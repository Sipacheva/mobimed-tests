package ru.mobimed.tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Wait;

import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.files.DownloadActions.click;
import static io.qameta.allure.Allure.step;

public class VisitTests extends TestBase {
  @Test
  @Description("Запись на прием")
  @DisplayName("Make a visit")
  void AddVisitTest() {
    step("Нажать 'Запись на приём', подождать, пока загрузится страница", () -> {
      $(byText("Запись на приём")).click();
      //$("[aria-label=\"onLine\"]").click();
      $("div.MuiAvatar-root").shouldBe(Condition.visible);
      sleep(3000);
    });

    step("Ввести фамилию в поле Специальность или ФИО", () -> {
      $("input[type=text]", 0).click();
      $("input[type=text]", 0).setValue("иванов").pressEnter();
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
      $("div.MuiAlert-message", 1).shouldHave(text("Вы записаны на приём"));
      $(byText("Закрыть"), 1).click();
    });

    step("Перейти в события и удалить запись", () -> {
      $(byText("Cобытия")).click();
      $$(".MuiGrid-root.MuiGrid-item.MuiGrid-grid-xs-12.MuiGrid-grid-sm-2")
              .findBy(text("30")).sibling(3).$(byText("Отменить")).click();
      $(".MuiDialogActions-root.MuiDialogActions-spacing", 1)
              .$(byText("Да")).click();
      $(byText("Закрыть"), 2).click();
    });

    step("Проверить, что есть текст Отменённый визит", () -> {
      $$("h6").shouldHave(itemWithText("Отмененный визит"));
    });
  }
}
