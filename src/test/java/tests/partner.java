package tests;


import com.codeborne.selenide.Selectors;
import core.BaseSelenideTest;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static helpers.TestLinks.*;
import static helpers.TestValues.novalidcode;
import static helpers.TestXpath.*;

public class partner extends BaseSelenideTest{
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
    public void bigbonus() throws InterruptedException {
        open(bigbonus);
        $(By.xpath("//img[@src='/images/bigBonus/logo.svg']")).shouldHave(exist,visible);
        $(By.xpath("//a[@href='/app']")).shouldHave(exist);
        $(By.xpath("//a[@href='https://apps.apple.com/kz/app/ubet-kz-/id1608871578']")).shouldHave(exist);
        $(By.xpath("//h3[@class='newbigBonus_subslogan__2WDen']")).shouldHave(text("до 225 000"));

        $(By.name("phone")).sendKeys("2345658444");
        $(By.xpath(submit)).click();
        $(By.xpath("//h2[@class='step2_h2__1Xiqq']")).shouldHave(visible,exist);
        $(By.xpath("//form/div/div/label")).click();
        $(By.xpath(submit)).click();
        $(By.xpath("//button[@class='authsteps_arrow__AFf6S undefined']")).shouldHave(exist);
        $(By.cssSelector("[data-id='0']")).sendKeys(novalidcode);
        $(Selectors.byText("Неверный код")).shouldBe(visible);
        $(By.xpath("//button[@class='button_input__2TvKU button_big__3J0-f button_yellow__2REE2 step3_button__1Pjq8']")).shouldHave(text("Запросить код"));

    }



}

