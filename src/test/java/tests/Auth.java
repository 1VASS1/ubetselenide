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

        open(reg);
        $(By.name("phone")).sendKeys("72)" + d);
        $(By.xpath(submit)).click();
        $(By.xpath("//*[contains(text(), 'Для регистрации по номеру')]"));
        $(By.xpath("//form/div/div/label")).click();
        $(By.xpath(submit)).click();
        $(By.cssSelector("[data-id='0']")).sendKeys(basecode);

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