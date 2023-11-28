package core;


import com.codeborne.selenide.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
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

    public void baseauth (){
        open(reg);
        $(By.name("phone")).sendKeys(baseacc);
        $(By.xpath(submit)).click();
        $(By.cssSelector("[data-id='0']")).sendKeys(basecode);
    }

    public void partners(){
        $(By.xpath("//img[@src='/images/logoub.png']")).shouldHave(exist,visible);
        $(By.xpath("//a[@href='/app']")).shouldHave(exist);
        $(By.xpath("//a[@href='https://apps.apple.com/kz/app/ubet-kz-/id1608871578']")).shouldHave(exist);
        $(By.xpath("//div[@class='style_neon__ivD9P']")).shouldHave(text("Ubet-bet"));
        $(byText("Регистрируйся")).shouldHave(visible);
        $(byText("Авторизуйся")).shouldHave(visible);
        $(byText("Играй")).shouldHave(visible);


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

    public void setUp (){
        Configuration.browser = Browsers.CHROME;
        Configuration.browserSize = "1366x800";
        Configuration.headless = false;
        Configuration.timeout = 70000;


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
