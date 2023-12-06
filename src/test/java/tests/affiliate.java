package tests;

import core.BaseSelenideTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static helpers.TestLinks.*;

public class affiliate extends BaseSelenideTest
{
    @Test
    public void affiliate()  {
        open(affiliate);
        $(By.xpath("//img[@src='../images/logo-desktop.svg']")).shouldBe(visible,exist);

        $(By.xpath("//a[@href='/main/faq']")).shouldHave(text("FAQ"));
        $(By.xpath("//a[@href='/main/rules']")).shouldHave(text("Правила"));
        $(By.xpath("//a[@href='/main/registration']")).shouldHave(text("Регистрация"));

        $(By.xpath("//a[@href='https://instagram.com/ubet__partners']")).shouldBe(visible,exist);
        $(By.xpath("//a[@href='https://t.me/Ubet_Partners']")).shouldBe(visible,exist);
        $(By.xpath("//a[@href='mailto:partner@ubet.kz']")).shouldHave(text("✉ partner@ubet.kz"));
        //Страница регистрации
        $(By.xpath("//a[@href='/main/registration']")).click();
        $(By.xpath("//input[@name='name']")).shouldBe(visible,exist);
        $(By.xpath("//input[@name='mail']")).shouldBe(visible,exist);
        $(By.xpath("//input[@name='phone']")).shouldBe(visible,exist);
        $(By.xpath("//input[@name='name']")).shouldBe(visible,exist);
        $(By.xpath("//textarea[@name='textarea']")).shouldBe(visible,exist);
        $(By.xpath("//button[@class='button button__big button__yellow']")).shouldBe(visible,exist);

    }
 /* $(By.xpath("//div[@class='modal-item__title']/h4[contains(text(),'" + field + "')]" +
              //  "//ancestor::li[@class='layout modal-item']//input")).sendKeys(Keys.CONTROL + "a");
        @Test
        public void canFillComplexForm() {
            open("/client/registration");
            $(By.name("user.name")).val("johny");
            $(By.name("user.gender")).selectRadio("male");
            $("#user.preferredLayout").selectOption("plain");
            $("#user.securityQuestion").selectOptionByText("What is my first car?");
        } */
}
