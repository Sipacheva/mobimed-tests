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

public class InvoicesTests extends TestBase{
  @Test
  @Description("Проверка наличия оплаченного счета")
  @DisplayName("Проверка наличия оплаченного счета")
  @Tag("mobimed")
  void CheckPaidInvoiceTest() {
    step("Перейти на вкладку Счета",() -> {
      $$(".MuiTab-wrapper").findBy(text("Счета")).click();
    });

    step("Перейти в раздел Оплаченные счета",() -> {
      $("[aria-label=filter-tabs]").$("button", 1).click();
    });

    step("Проверить наличие счета 979",() -> {
      $$(".MuiTypography-h6").findBy(text("979"))
              .shouldBe(visible, Duration.ofSeconds(10));
    });
  }
}
