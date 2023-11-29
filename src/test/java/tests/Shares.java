package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static core.BaseSelenideTest.*;
import static helpers.TestValues.*;
import static helpers.TestLinks.*;
import static helpers.TestXpath.*;

/** В работе **/
public class Shares {
    //* Проверка запрета на совершения прогноза без авторизации и регистрации
    //* Проверка запрета на совершения прогноза без авторизации и регистрации
    @Test
    public void actionexpert() throws InterruptedException {
        baseauth();
        $("#header").shouldBe(exist);
        open(actionexpert);
        $(By.xpath("//div[@class='style_text__25jE6']")).shouldHave(text("Выбери все события и оставь свой прогноз"));
        $(By.xpath("//button[@class='button_input__2TvKU button_big__3J0-f button_yellow__2REE2 style_button__njloT']")).shouldHave(text("Оставить прогноз"));

    }

    @Test
    public void actionexpert2() throws InterruptedException {
        open(actionexpert);
        $(By.xpath("//a[@class='style_button__njloT']")).shouldHave(text("ЗАРЕГИСТРИРОВАТЬСЯ"));

    }

}