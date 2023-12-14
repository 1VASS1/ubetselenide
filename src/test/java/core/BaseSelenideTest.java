package core;


import com.codeborne.selenide.*;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static helpers.TestLinks.back;
import static helpers.TestLinks.reg;
import static helpers.TestValues.*;
import static helpers.TestXpath.submit;

/**
 * Базовый класс для инициализации селенида
 */
abstract public class BaseSelenideTest {


    /**
     * Инициализация selenide с настройками
     */

    //Авторизация
    public static void baseauth() {
        open(reg);
        $(By.name("phone")).sendKeys(baseacc);
        $(By.xpath(submit)).click();
        $(By.xpath("//input[@data-id='0']")).sendKeys(basecode);
        $("header").shouldBe(exist, visible);
    }


    //Авторизация в бэкофисе
    public static void authbackoffice() {
        open(back);
        $(By.name("login")).sendKeys(loginback);
        $(By.name("password")).sendKeys(passback);
        $(By.xpath("//button[@type='submit']")).click();
    }

    public void partners() {
        $(By.xpath("//img[@src='/images/logoub.png']")).shouldHave(exist, visible);
        $(By.xpath("//a[@href='/app']")).shouldHave(exist);
        $(By.xpath("//a[@href='https://apps.apple.com/kz/app/ubet-kz-/id1608871578']")).shouldHave(exist);
        $(By.xpath("//div[@class='style_neon__ivD9P']")).shouldHave(text("Ubet-bet"));
        $(byText("Регистрируйся")).shouldHave(visible);
        $(byText("Авторизуйся")).shouldHave(visible);
        $(byText("Играй")).shouldHave(visible);
        $(By.name("phone")).sendKeys("2345658444");
        $(By.xpath(submit)).shouldHave(visible);


    }

    public static void bigbonus() {
        $(By.xpath("//img[@src='/images/bigBonus/logo.svg']")).shouldHave(exist, visible);
        $(By.xpath("//a[@href='/app']")).shouldHave(exist);
        $(By.xpath("//a[@href='https://apps.apple.com/kz/app/ubet-kz-/id1608871578']")).shouldHave(exist);
        $(byText("за первое пополнение")).shouldHave(visible);
        $(By.xpath("//button[@class='newbigBonus_more__1NPX-']")).shouldHave(exist).click();
        ;
        $(By.xpath("//button[@class='conditionsmodal_close__s1U7X']")).shouldHave(exist).click();
        $(By.name("phone")).sendKeys("2345658444");
        $(By.xpath(submit)).shouldHave(visible);
    }


    public void setUp() {
        Configuration.browser = Browsers.CHROME;
        Configuration.browserSize = "1366x800";
        Configuration.headless = false;
        Configuration.timeout = 70000;
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    }


    /**
     * Выполнение метода перед каждым запуском тестов
     */
    @BeforeEach
    public void init(){
        setUp();
        System.out.println("Тест запущен");
    }

    /**
     * Выполнение метода после каждого закрытия тестов
     */
    @AfterEach
    public void tearDown() {
        Selenide.closeWebDriver();
        System.out.println("Тест завершен");
    }
}
