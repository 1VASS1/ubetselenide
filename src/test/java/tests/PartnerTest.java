package tests;

import com.codeborne.selenide.Selectors;
import core.BaseSelenideTest;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static helpers.TestLinks.*;
import static helpers.TestValues.*;
import static helpers.TestXpath.*;

public class PartnerTest extends BaseSelenideTest{
    @Test
    public void partnerubet() throws InterruptedException {
        open(pub);
        partners();
    }
    @Test
    public void partnerubet7() throws InterruptedException {
        open(pub7);
        partners();
    }
    @Test
    public void partnerubet10() throws InterruptedException {
        open(pub10);
        partners();

    }

    @Test
    public void bigbonus225() throws InterruptedException {
        open(bigbonus);
        $(By.xpath("//h3[@class='newbigBonus_subslogan__2WDen']")).shouldHave(text("до 225 000"));
        bigbonus();

    }
    @Test
    public void bigbonus100() throws InterruptedException {
        open(bigbonus100);
        bigbonus();

    }

    @Test
    public void bigbonus100girl() throws InterruptedException {
        open(bigbonus100girl);
        //
        $(Selectors.byText("РЕАЛЬНО ВЫСОКИЕ КОЭФФИЦИЕНТЫ")).shouldBe(visible);
        $(Selectors.byText("ЕЖЕНЕДЕЛЬНЫЙ КЕШБЭК")).shouldBe(visible);
        $(Selectors.byText("БЫСТРЫЕ ВЫПЛАТЫ")).shouldBe(visible);
        $(Selectors.byText("ПРОСТАЯ РЕГИСТРАЦИЯ")).shouldBe(visible);
       //Кнопка получить бонус
        $(By.xpath("//button[@class='button_input__2TvKU button_big__3J0-f button_yellow__2REE2 style_button__1_2UQ ']")).shouldHave(text("Получить бонус")).click();
        $(Selectors.byText("Введите номер телефона")).shouldBe(visible);
        $(Selectors.byText("Чтобы войти или зарегистрироваться")).shouldBe(visible);
        $(By.name("phone")).sendKeys(baseacc);
        $(By.xpath(submit)).click();
        $(By.xpath("//div[@class='step3_block__2UV4M']")).shouldHave(exist,visible);
        //Проверка кнопки "Запросить код"
        $(By.xpath(repeatcode)).shouldHave(text("Запросить код")).shouldBe(visible);
        //Проверка кнопки закрыть
        $(By.xpath("//i[@class='icon-cross style_close__10bzM']")).shouldHave(exist,visible).click();
    }


}

