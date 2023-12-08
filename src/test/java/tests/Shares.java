package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import org.junit.Assert;
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
    //* Проверка наличия основных окон после авторизации
    @Test
    public void actionexpert() throws InterruptedException {
        baseauth();
        Configuration.timeout = 10000;
        $("header").shouldBe(exist,visible);

        open(actionexpert);
        //Проверка наличия таймера
        $(By.xpath("//div[@class='style_timer__1Gqp7']")).shouldBe(visible,exist);

        $(By.xpath("//div[1]/div[2]/button[1]")).click();
        $(By.xpath("//div[2]/div[2]/button[3]")).click();
        $(Selectors.byText("Подтверди свой прогноз ставкой или собери новый")).shouldBe(visible,exist);

        $(By.xpath("//button[@class='button_input__2TvKU button_big__3J0-f button_yellow__2REE2 style_button__njloT']")).shouldHave(text("Оставить прогноз")).click();

        $(By.xpath("//div[@class='style_value__3O0pt']")).shouldHave(text("500 000 ₸"));
        //Подтверди свой прогноз ставкой
        $(By.xpath("//div[@class='style_yellow__3QYlW']")).shouldHave(text("Подтверди ставкой"));

        $(Selectors.byText("Необходимо сделать ставку на сумму")).shouldBe(visible,exist);
        $(Selectors.byText("от 1000 тенге")).shouldBe(visible,exist);
        $(By.xpath("//button[@class='button_input__2TvKU button_big__3J0-f button_yellow__2REE2 style_button__njloT']")).shouldBe(visible,exist);
        $(Selectors.byText("корректировать прогноз")).shouldBe(visible,exist);


    }

    //Наличие кнопки регистрации без авторизации
    //Прогноз без верификации

    @Test
    public void actionexpertnoverif() throws InterruptedException {
        open(actionexpert);
        $(By.xpath("//a[@class='style_button__njloT']")).shouldHave(text("ЗАРЕГИСТРИРОВАТЬСЯ"));
        $(By.xpath("//a[@class='style_button__njloT']")).click();
        $(By.name("phone")).sendKeys(acciin);
        $(By.xpath(submit)).click();
        $(By.cssSelector("[data-id='0']")).sendKeys(basecode);
        Configuration.timeout = 10000;
        $("header").shouldBe(exist,visible);
        open(actionexpert);
        $(Selectors.byText("Выбери все события и оставь свой прогноз")).shouldBe(visible,exist);
        $(By.xpath("//div[1]/div[2]/button[1]")).click();
        $(By.xpath("//div[2]/div[2]/button[3]")).click();
        $(By.xpath("//button[@class='button_input__2TvKU button_big__3J0-f button_yellow__2REE2 style_button__njloT']")).shouldHave(text("Оставить прогноз")).click();
        $(By.xpath("//div[@class='noticeTooltip_text__36zDt']")).shouldHave(text("Пройдите верификацию"));

    }

}