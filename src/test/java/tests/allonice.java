package tests;

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


public class allonice extends BaseSelenideTest {

    //* Проверка акции "Все на лёд" без авторизации
    @Test
    public void allonicenoauth() throws InterruptedException {
        open(allonice);
        $(Selectors.byText("Для участия в акции необходимо авторизоваться")).shouldBe(visible,exist);

    }
    //* Проверка акции "Все на лёд" без верификации
    @Test
    public void allonicenoirif()  {
        open(reg);
        $(By.name("phone")).sendKeys(acciin);
        $(By.xpath(submit)).click();
        $(By.cssSelector("[data-id='0']")).sendKeys("1111");
        $("header").shouldBe(exist,visible);
        open(allonice);
        $(Selectors.byText("Для участия в акции необходимо пройти верификацию")).shouldBe(visible,exist);

    }
    //* Проверка акции "Все на лёд" c верификацией
    @Test
    public void alloniceverif()  {
        baseauth();
        $("header").shouldBe(exist,visible);
        open(allonice);
        $(By.xpath("//button[@class='puckscounter_button__2aJjE']")).shouldHave(text("крутануть "));

    }
}
