package core;


import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.FileDownloadMode;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

/**
 * Базовый класс для инициализации селенида
 */
abstract public class BaseSelenideTest {

    /**
     * Инициализация selenide с настройками
     */
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
