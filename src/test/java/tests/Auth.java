package tests;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import core.BaseSelenideTest;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static helpers.TestValues.*;
import static helpers.TestLinks.*;
import static helpers.TestXpath.*;

public class Auth extends BaseSelenideTest {



    /**
     * Тест авторизации
     */


    @Test
    public void newuser() throws InterruptedException {
        //* Генерируем номер
        int d = (int) (Math.random() * 300000001);

        //Ввод номера и проверка заголовков
        open(reg);
        $(By.name("phone")).sendKeys("72)" + d);
        $(Selectors.byText("Введите номер телефона")).shouldBe(visible);
        $(Selectors.byText("Чтобы войти или зарегистрироваться")).shouldBe(visible);

        $(By.xpath(submit)).click();
        //Проверка наличия лого
        $(By.xpath("//img[@src='/images/ubet_logo.svg']")).shouldHave(exist,visible);
        //Проверка заголовка и чекбокса
        $(Selectors.byText("Для регистрации по номеру")).shouldBe(visible);

        $(By.xpath("//h2[@class='step2_h2__1Xiqq']")).shouldHave(visible,exist);
        $(By.xpath("//form/div/div/label")).click();
        $(By.xpath(submit)).click();
        //Проверка стрелки возврата назад
        $(By.xpath("//button[@class='authsteps_arrow__AFf6S undefined']")).shouldHave(exist);;
        //Проверка кнопки "Запросить код"
        $(By.xpath("//button[@class='button_input__2TvKU button_big__3J0-f button_yellow__2REE2 step3_button__1Pjq8']")).shouldHave(text("Запросить код")).shouldBe(visible);
        //Ввод смс
        $(By.cssSelector("[data-id='0']")).sendKeys(basecode);
        $("header").shouldBe(exist,visible);
        // Проверка наличия кнопки пополнить
        $(By.xpath("//a[@class='header_button__2lcv- header_cashbox__1lK3t header_orange__2p0HD']")).shouldBe(exist,visible);
        // Проверка отображения баланса
        $(By.xpath("//span[@class='balance_value__1M_9w']")).shouldBe(exist,visible);
        // Проверка отображения имени
        $(Selectors.byClassName("header_value__2gCW0")).shouldBe(visible,exist);

    }


    @Test
    public void novalidcode() throws InterruptedException {
        open(reg);
        $(By.name("phone")).sendKeys(baseacc);
        $(By.xpath(submit)).click();
        $(By.cssSelector("[data-id='0']")).sendKeys(novalidcode);
        $(Selectors.byText("Неверный код")).shouldBe(visible);
    }

    @Test
    public void repeatcode() throws InterruptedException {

        open(reg);
        $(By.name("phone")).sendKeys(baseacc);
        $(By.xpath(submit)).click();
        $(By.xpath("//*[text() = 'Запросить код']")).click();
        $(Selectors.byText("СМС успешно отправлено")).shouldBe(visible);
    }

    @Test
    public void accblock() throws InterruptedException {
        open(reg);
        $(By.name("phone")).sendKeys(accblock);
        $(By.xpath(submit)).click();
        $(Selectors.byText("Пользователь заблокирован")).shouldBe(visible);
    }


}