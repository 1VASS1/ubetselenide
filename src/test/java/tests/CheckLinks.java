package tests;

import com.codeborne.selenide.*;
import core.BaseSelenideTest;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.net.MalformedURLException;
import java.net.URL;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

import static helpers.TestValues.*;
import static helpers.TestLinks.*;
import static helpers.TestXpath.*;

public class CheckLinks extends BaseSelenideTest {


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
        //Инициализация базовой авторизации
        baseauth();

        //Проверка основных ссылок
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
        $(By.xpath(vk)).shouldBe(exist,visible);
        $(By.xpath(inst)).shouldBe(exist,visible);
        $(By.xpath(fb)).shouldBe(exist,visible);
        $(By.xpath(tg)).shouldBe(exist,visible);
        $(By.xpath(yt)).shouldBe(exist,visible);
        $(By.xpath(tel)).shouldHave(text("8 (800) 005-00-21"));
        $(By.xpath(partners)).shouldBe(exist,visible);


        $(By.xpath("//button[@class='cabinet_link__3ML1g']")).click();
        $(By.xpath("//a[@href='/registration']")).shouldHave(text("Войти"));


    }
        @Test
        public void checklinksprofilepage2() throws InterruptedException {
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

            //Проверка наличия ссылок и полей в разделе Профиль
            $(By.linkText("Профиль")).click();
            //Проверка раздела Удостоверение личности РК
            $(By.xpath("//*[text() = 'Удостоверение личности РК']")).click();
            $(By.xpath("//*[text() = 'Лицевая сторона документа']"));
            $(By.xpath("//*[text() = 'Оборотная сторона документа']"));
            $(By.xpath("//*[text() = 'Селфи с документом']"));
            $(By.xpath("//*[text() = 'Лицевая сторона документа']"));
            $(By.xpath("//button[@class='button_input__2TvKU button_big__3J0-f button_yellow__2REE2 documents_button__anN4p']"));
            $(By.xpath("//div[@class='documents_back__2o0Fu']")).click();
            //Проверка раздела Паспорт РК
            $(By.xpath("//*[text() = 'Паспорт РК']")).click();
            $(By.xpath("//*[text() = 'Разворот паспорта с фото']"));
            $(By.xpath("//*[text() = 'Селфи с документом']"));
            $(By.xpath("//button[@class='button_input__2TvKU button_big__3J0-f button_yellow__2REE2 documents_button__anN4p']"));
            $(By.xpath("//div[@class='documents_back__2o0Fu']")).click();
            //Проверка раздела Вид на жительство РК
            $(By.xpath("//*[text() = 'Вид на жительство РК']")).click();
            $(By.xpath("//*[text() = 'Лицевая сторона документа']"));
            $(By.xpath("//*[text() = 'Оборотная сторона документа']"));
            $(By.xpath("//*[text() = 'Селфи с документом']"));
            $(By.xpath("//button[@class='button_input__2TvKU button_big__3J0-f button_yellow__2REE2 documents_button__anN4p']"));
            $(By.xpath("//div[@class='documents_back__2o0Fu']")).click();
            //Проверка раздела Документ иностранного гражданина
            $(By.xpath("//*[text() = 'Документ иностранного гражданина']")).click();
            $(By.xpath("//*[text() = 'Разворот паспорта с фото']"));
            $(By.xpath("//*[text() = 'Селфи с документом']"));
            $(By.xpath("//button[@class='button_input__2TvKU button_big__3J0-f button_yellow__2REE2 documents_button__anN4p']"));
            $(By.xpath("//div[@class='documents_back__2o0Fu']")).click();

            //Проверка полей в Настройках профиля
            $(By.xpath("//*[text() = 'Настройки профиля']")).click();
            $(By.xpath("//input[@value='68960']"));
            $(By.xpath("//input[@value='+7 (723) 456-78-78']"));
            $(By.xpath("//input[@value='v.elyas@mail.ru']"));
            $(By.xpath("//button[@class='button_input__2TvKU button_big__3J0-f button_yellow__2REE2 profileSettings_button__sOUBV']"));
            $(By.xpath("//input[@name='email']"));
            $(By.xpath("//input[@name='sms']"));
            $(By.xpath("//button[@class='button_input__2TvKU button_big__3J0-f button_yellow__2REE2 ']"));

            //Проверка наличия полей в разделе Партнерка
            $(By.linkText("Партнёрка")).click();
            $((By.xpath("//*[text() = '322BA259']")));

            $(By.xpath("//*[text() = 'Моя реферальная ссылка']"));
            $(By.xpath("//input[@type='tel']")).sendKeys("1234567878");
            $(By.xpath("//button[@class='button_input__2TvKU button_big__3J0-f button_yellow__2REE2 style_button__1ziBA']"));
            $(By.xpath("//*[text() = 'Активные']")).click();
            $(By.xpath("//*[text() = 'Статистика']"));

            //Проверка наличия полей фильтров и отображение статистики
            $(By.xpath("//div[@class='style_filters__3i29Y']"));
            $(By.xpath("//div[@class='style_row__1LS3_ style_body__1yGQs style_status3__UP4dM']"));

            $(By.xpath("//li[@id='react-tabs-4']")).click();
            $(By.xpath("//*[text() = 'Общая статистика']"));
            $(By.xpath("//*[text() = 'Общая премия']"));
            $(By.xpath("//*[text() = 'Начислено']"));
            $(By.xpath("//*[text() = 'Доступно к начислению']"));
            $(By.xpath("//div[@class='style_value__NtU0f']"));
            $(By.xpath("//*[text() = 'Приглашай друзей - получай деньги!']"));
            $(By.xpath("//button[@class='button_input__2TvKU button_big__3J0-f button_yellow__2REE2 style_button__2F-2k']")).click();

            //Проверка наличия полей в разделе Мой статус
            // Ссылки кешбека, шкалу прогресса , шкалу статусов
            $(By.linkText("Мой статус")).click();
            $(By.xpath("//*[text() = 'Текущий']"));
            $(By.xpath("//*[text() = 'История']"));
            $(By.xpath("//div[@class='current_text1__37CDX']"));
            $(By.xpath("//a[@href='/ru/shares/cashback']"));
            $(By.xpath("//*[text() = 'Сумма ставок']"));
            $(By.xpath("//div[@class='current_next__1XeHL']"));
            $(By.xpath("//div[@class='current_scale__Oh3Z0']"));
            $(By.xpath("//div[@class='current_statuses__mbf_l']"));

            //Проверка наличия полей в разделе Касса
            $(By.linkText("Касса")).click();
            $(By.xpath("//li[@id='react-tabs-0']"));
            $(By.xpath("//*[text() = 'Выплата выигрышей']"));
            $(By.xpath("//*[text() = 'История транзакций']"));
            $(By.xpath("//div[@class='systems_row__30xzB']"));

            $(By.xpath("//a[@href='/ru/shares/cashback']"));
            $(By.xpath("//*[text() = 'Сумма ставок']"));
            $(By.xpath("//div[@class='current_next__1XeHL']"));
            $(By.xpath("//div[@class='current_scale__Oh3Z0']"));
            $(By.xpath("//div[@class='current_statuses__mbf_l']"));

            $(By.xpath("//*[text() = 'Выплата выигрышей']")).click();
            $(By.xpath("//*[text() = 'Согласно законодательству Республики Казахстан, для осуществления выплаты необходимо быть идентифицированным на нашем сайте.']"));
            $(By.xpath("//button[@class='button_input__2TvKU button_big__3J0-f button_yellow__2REE2 notConfirmed_button__1LgHT']"));

            $(By.xpath("//*[text() = 'История транзакций']")).click();
            $(By.xpath("//div[@class='customDatePicker_customDatePicker__1BVcP']"));


            //Проверка наличия полей в разделе Бонусы
            $(By.xpath("//a[@class='cabinet_link__3ML1g']")).shouldHave(text("Бонусы")).shouldBe(visible).click();
            $(By.xpath("//div[@class='/html/body/div[1]/div/div[2]/div/div/nav/a[6]']")).click();
            $(By.xpath("//div[@class='cabinet_mark__2ZLrF']"));
            $(By.xpath("//*[text() = 'Доступные']")).click();
            $(By.xpath("//div[@class='style_cards__2iXLc']"));
            $(By.xpath("//div[@class='style_type__2Bz1X']")).shouldBe(visible,exist);
            $(By.xpath("//div[@class='style_name__3ZxWn']"));
            $(By.xpath("//div[@class='style_status__1AIW5']"));
            $(By.xpath("//div[@class='style_amount__3VJXL']"));
            $(By.xpath("//button[@class='style_infoBtn__2F7I2']")).click();
            $(By.xpath("//div[@class='style_info__pnXwy']"));
            $(By.xpath("//*[text() = 'Активные']")).click();
            $(By.xpath("//*[text() = 'История']")).click();


            $(By.linkText("Уведомления")).click();
            $(By.xpath("//div[@class='notifications_title__noMyS']")).shouldBe(visible);
            $(By.xpath("//div[@class='accordion_item__HOBfC notifications_accordion__1yK1m']")).click();
            $(By.xpath("//div[@class='notifications_html__2HjhN']")).shouldBe(visible);
            $(By.xpath("//div[@class='notifications_date__3gHjM']")).shouldBe(visible);


        }

}