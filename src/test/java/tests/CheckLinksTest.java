package tests;

import core.BaseSelenideTest;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

import static helpers.TestLinks.*;
import static helpers.TestXpath.*;

public class CheckLinksTest extends BaseSelenideTest {



    /**
     * Проверка наличия ссылок
     * Проверка наличия кнопки пополнить
     * Проверка отображения баланса
     * Проверка отображения имени
     * Проверка основных ссылок
     * Проверка выхода из кабинета
     */


    @Test
    public void checklinksheadpage() throws InterruptedException {
        open(home);
        $(By.xpath("//a[@href='/registration']")).shouldHave(text("Войти")).shouldBe(visible);
        //Кнопка регистрации
        $(By.xpath("//button[@class='button_input__2TvKU button_big__3J0-f button_yellow__2REE2 header_button__2lcv-']")).shouldBe(visible,exist);
        //Инициализация базовой авторизации
        baseauth();
        //Проверка наличия ссылок в меню кабинета
        $(By.xpath("//*[text() = 'Профиль']"));
        $(By.xpath("//a[@href='/profile']"));
        $(By.xpath("//*[text() = 'Партнёрка']"));
        $(By.xpath("//a[@href='/partners']"));
        $(By.xpath("//*[text() = 'Мой статус']"));
        $(By.xpath("//a[@href='/status']"));
        $(By.xpath("//*[text() = 'Касса']"));
        $(By.xpath("//a[@href='/cashbox']"));
        $(By.xpath("//*[text() = 'Промокод']"));
        $(By.xpath("//a[@href='/promocode']"));
        $(By.xpath("//*[text() = 'Бонусы']"));
        $(By.xpath("//a[@href='/bonuses']"));
        $(By.xpath("//*[text() = 'Уведомления']"));
        $(By.xpath("//a[@href='/notifications']"));
        $(By.xpath("//*[text() = 'Выход']"));

        //Проверка ссылок в шапке и футере
        $(By.xpath("//*[text() = 'ЛИНИЯ']"));
        $(By.xpath("//a[@href='/#live']")).shouldHave(text("ЛАЙВ"));
        $(By.xpath("//a[@href='/esports']")).shouldHave(text("КИБЕРСПОРТ"));
        $(By.xpath("//a[@href='/shares']")).shouldHave(text("АКЦИИ"));


        //* Футер
        $(By.xpath("//a[@href='/rules/license']")).shouldHave(text("Лицензия"));
        $(By.xpath("//a[@href='/rules/rules-bets']")).shouldHave(text("Правила приема ставок"));
        $(By.xpath("//a[@href='/rules/pair-game']")).shouldHave(text("Ответственная игра"));
        $(By.xpath("//a[@href='/rules/personal']")).shouldHave(text("Персональные данные"));
        $(By.xpath("//a[@href='/rules/contacts']")).shouldHave(text("Контакты"));
        $(By.xpath("//a[@href='/news']")).shouldHave(text("Новости"));
        $(By.xpath("//a[@href='/rules/faq']")).shouldHave(text("Частые вопросы"));
        $(By.xpath("//a[@href='/prognoz']")).shouldHave(text("Прогнозы"));

        //* Школа ставок
        $(By.xpath("//a[@href='/rules/football']")).shouldHave(text("Футбол"));
        $(By.xpath("//a[@href='/rules/basketball']")).shouldHave(text("Баскетбол"));
        $(By.xpath("//a[@href='/rules/hockey']")).shouldHave(text("Хоккей"));
        $(By.xpath("//a[@href='/rules/tennis']")).shouldHave(text("Теннис"));
        $(By.xpath("//a[@href='/rules/volleyball']")).shouldHave(text("Волейбол"));


        //* Бонусная программа
        $(By.xpath("//a[@href='/rules/first-deposit']")).shouldHave(text("Бонус на первые три депозита"));
        $(By.xpath("//a[@href='/rules/cashback']")).shouldHave(text("СashBack"));
        $(By.xpath("//a[@href='/rules/express-bonus']")).shouldHave(text("Экспресс бонус"));
        $(By.xpath("//a[@href='/rules/express-cashback']")).shouldHave(text("Экспресс cashback"));
        $(By.xpath("//a[@href='/rules/express-day']")).shouldHave(text("Экспресс дня"));

        //* Соц сети
        $(By.xpath(vk)).shouldBe(exist, visible);
        $(By.xpath(inst)).shouldBe(exist, visible);
        $(By.xpath(fb)).shouldBe(exist, visible);
        $(By.xpath(tg)).shouldBe(exist, visible);
        $(By.xpath(yt)).shouldBe(exist, visible);
        $(By.xpath(tel)).shouldHave(text("8 (800) 005-00-21"));
        $(By.xpath(partners)).shouldBe(exist, visible);


        $(By.xpath("//button[@class='cabinet_link__3ML1g']")).click();
        $(By.xpath("//a[@href='/registration']")).shouldHave(text("Войти"));


    }


}