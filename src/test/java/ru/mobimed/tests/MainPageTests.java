package ru.mobimed.tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

public class MainPageTests extends TestBase{
  @Test
  @Description("Проверка работы поиска на главной странице")
  @DisplayName("Check search on the ")
  @Tag("mobimed")
  void searchOnTheMainPageTest() {
    step("На Главной в строке поиска ввести 'ЛО'",() -> {
      $("input[type=text]").click();
      $("input[type=text]").setValue("ло").pressEnter();
    });

    step("Проверить, что выдалось 4 результата и их значения",() -> {
      $$(".MuiCard-root").shouldHave(size(4));
      $$(".MuiCard-root").shouldHave(texts("ЛОР", "Гастроэнтеролог", "Гинеколог", "Кардиолог"));
    });
  }
}
