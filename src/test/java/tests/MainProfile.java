package tests;

import com.codeborne.selenide.Configuration;
import core.BaseSelenideTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.*;
import static core.BaseSelenideTest.*;
import static helpers.TestLinks.*;

public class MainProfile extends BaseSelenideTest {


    @BeforeEach
    public void init() {
        baseauth();
        Configuration.timeout = 70000;
    }

    //Проверка основных разделов в разделе "Профиль", В РАБОТЕ!!
    @Test
    public void checkprofile() throws InterruptedException {


        //Проверка наличия ссылок и полей в разделе Профиль
        $(By.linkText("Профиль")).click();
        $(By.xpath("//*[text() = 'Обновить данные']")).click();
        //Проверка раздела Удостоверение личности РК
        $(By.xpath("//*[text() = 'Удостоверение личности РК']")).click();
        $(By.xpath("//*[text() = 'Лицевая сторона документа']")).shouldBe(visible, exist);
        $(By.xpath("//*[text() = 'Оборотная сторона документа']")).shouldBe(visible, exist);
        $(By.xpath("//*[text() = 'Селфи с документом']")).shouldBe(visible, exist);
        $(By.xpath("//*[text() = 'Лицевая сторона документа']")).shouldBe(visible, exist);
        $(By.xpath("//button[@class='button_input__2TvKU button_big__3J0-f button_yellow__2REE2 documents_button__anN4p']")).shouldBe(visible, exist);
        $(By.xpath("//div[@class='documents_back__2o0Fu']")).click();
        //Проверка раздела Паспорт РК
        $(By.xpath("//*[text() = 'Паспорт РК']")).click();
        $(By.xpath("//*[text() = 'Разворот паспорта с фото']")).shouldBe(visible, exist);
        $(By.xpath("//*[text() = 'Селфи с документом']")).shouldBe(visible, exist);
        $(By.xpath("//button[@class='button_input__2TvKU button_big__3J0-f button_yellow__2REE2 documents_button__anN4p']")).shouldBe(visible, exist);
        $(By.xpath("//div[@class='documents_back__2o0Fu']")).click();
        //Проверка раздела Вид на жительство РК
        $(By.xpath("//*[text() = 'Вид на жительство РК']")).click();
        $(By.xpath("//*[text() = 'Лицевая сторона документа']")).shouldBe(visible, exist);
        $(By.xpath("//*[text() = 'Оборотная сторона документа']")).shouldBe(visible, exist);
        $(By.xpath("//*[text() = 'Селфи с документом']")).shouldBe(visible, exist);
        $(By.xpath("//button[@class='button_input__2TvKU button_big__3J0-f button_yellow__2REE2 documents_button__anN4p']")).shouldBe(visible, exist);
        $(By.xpath("//div[@class='documents_back__2o0Fu']")).click();
        //Проверка раздела Документ иностранного гражданина
        $(By.xpath("//*[text() = 'Документ иностранного гражданина']")).click();
        $(By.xpath("//*[text() = 'Разворот паспорта с фото']")).shouldBe(visible, exist);
        $(By.xpath("//*[text() = 'Селфи с документом']")).shouldBe(visible, exist);
        $(By.xpath("//button[@class='button_input__2TvKU button_big__3J0-f button_yellow__2REE2 documents_button__anN4p']")).shouldBe(visible, exist);
        $(By.xpath("//div[@class='documents_back__2o0Fu']")).click();

        //Проверка полей в Настройках профиля
        $(By.xpath("//*[text() = 'Настройки профиля']")).click();
        $(By.xpath("//input[@value='68960']")).shouldBe(visible, exist);
        $(By.xpath("//input[@value='+7 (723) 456-78-78']")).shouldBe(visible, exist);
        $(By.xpath("//input[@value='v.elyas@mail.ru']")).shouldBe(visible, exist);
        $(By.xpath("//button[@class='button_input__2TvKU button_big__3J0-f button_yellow__2REE2 profileSettings_button__sOUBV']")).shouldBe(visible, exist);
        $(By.xpath("//input[@name='email']")).shouldBe(exist);
        $(By.xpath("//input[@name='sms']")).shouldBe(exist);
        $(By.xpath("//button[@class='button_input__2TvKU button_big__3J0-f button_yellow__2REE2 ']")).shouldBe(visible, exist);
    }
        @Test
        public void checkpartners() throws InterruptedException {
            //Проверка наличия полей в разделе Партнерка
            $(By.linkText("Партнёрка")).click();
            $(By.xpath("//*[text() = '322BA259']")).shouldBe(visible, exist);

            $(By.xpath("//*[text() = 'Моя реферальная ссылка']")).shouldBe(visible, exist);
            $(By.xpath("//input[@type='tel']")).sendKeys("1234567878");
            $(By.xpath("//button[@class='button_input__2TvKU button_big__3J0-f button_yellow__2REE2 style_button__1ziBA']")).shouldBe(visible, exist);
            $(By.xpath("//*[text() = 'Активные']")).click();
            $(By.cssSelector("div:nth-child(2) > select")).selectOptionByValue("4");
            $(By.xpath("//*[text() = 'Статистика']")).shouldBe(visible, exist);

            //Проверка наличия полей фильтров и отображение статистики
            $(By.xpath("//div[@class='style_filters__3i29Y']")).shouldBe(visible, exist);
            $(By.xpath("//div[@class='style_row__1LS3_ style_body__1yGQs style_status3__UP4dM']")).shouldBe(visible, exist);

            $(By.xpath("//li[@id='react-tabs-4']")).click();
            $(By.xpath("//*[text() = 'Общая статистика']")).shouldBe(visible, exist);
            $(By.xpath("//*[text() = 'Общая премия']")).shouldBe(visible, exist);
            $(By.xpath("//*[text() = 'Начислено']")).shouldBe(visible, exist);
            $(By.xpath("//*[text() = 'Доступно к начислению']")).shouldBe(visible, exist);
            $(By.xpath("//div[@class='style_value__NtU0f']")).shouldBe(visible, exist);
            $(By.xpath("//*[text() = 'Приглашай друзей - получай деньги!']")).shouldBe(visible, exist);
            $(By.xpath("//button[@class='button_input__2TvKU button_big__3J0-f button_yellow__2REE2 style_button__2F-2k']")).click();
        }
        @Test
        public void checkstatus() throws InterruptedException {
            //Проверка наличия полей в разделе Мой статус
            // Ссылки кешбека, шкалу прогресса , шкалу статусов
            $(By.linkText("Мой статус")).click();
            $(By.xpath("//*[text() = 'Текущий']")).shouldBe(visible, exist);
            $(By.xpath("//*[text() = 'История']")).shouldBe(visible, exist);
            $(By.xpath("//div[@class='current_text1__37CDX']")).shouldBe(visible, exist);
            $(By.xpath("//a[@href='/ru/shares/cashback']")).shouldBe(visible, exist);
            $(By.xpath("//*[text() = 'Сумма ставок:']")).shouldBe(visible, exist);
            //Сколько до следующего статуса
            $(By.xpath("//div[@class='current_next__1XeHL']")).shouldBe(visible, exist);
            //Шкала прогресса
            $(By.xpath("//div[@class='current_scale__Oh3Z0']")).shouldBe(visible, exist);
            //Блок статусов
            $(By.xpath("//div[@class='current_statuses__mbf_l']")).shouldBe(visible, exist);
        }


        //Проверка наличия полей в разделе Касса
        @Test
        public void checkcashbox() throws InterruptedException {
            $(By.linkText("Касса")).click();
            $(By.xpath("//li[@id='react-tabs-0']")).shouldBe(exist);
            $(By.xpath("//*[text() = 'Выплата выигрышей']")).shouldBe(visible, exist);
            $(By.xpath("//*[text() = 'История транзакций']")).shouldBe(visible, exist);
            $(By.xpath("//div[@class='systems_row__30xzB']")).shouldBe(visible, exist);
            $(By.xpath("//*[text() = 'Выплата выигрышей']")).click();
            $(By.xpath("//*[text() = 'История транзакций']")).click();
            /* Для неверифицированного пользователя
            $(By.xpath("//*[text() = 'Согласно законодательству Республики Казахстан, для осуществления выплаты необходимо быть идентифицированным на нашем сайте.']")).shouldBe(visible, exist);
            $(By.xpath("//button[@class='button_input__2TvKU button_big__3J0-f button_yellow__2REE2 notConfirmed_button__1LgHT']")).shouldBe(visible, exist); */
        }

        //Проверка наличия полей в разделе Бонусы
        @Test
        public void checkbonuses() throws InterruptedException {
            open(bonuses);

            $(By.xpath("//div[@class='cabinet_mark__2ZLrF']")).shouldBe(visible, exist);
            $(By.xpath("//*[text() = 'Доступные']")).click();
            //Проверка отображения доступного бонуса
            $(By.xpath("//div[2]/div[1]/div[@class='style_cards__2iXLc']")).shouldBe(visible, exist);

            $(By.xpath("//div[@class='style_type__2Bz1X']")).shouldBe(visible, exist);
            $(By.xpath("//div[@class='style_name__3ZxWn']")).shouldBe(visible, exist);
            //Провека активировать до
            $(By.xpath("//div[@class='style_status__1AIW5']")).shouldBe(visible, exist);
            //Cумма промо
            $(By.xpath("//div[@class='style_amount__3VJXL']")).shouldBe(visible, exist);
            //Наличие кнопки подробнее
            $(By.xpath("//button[@class='style_infoBtn__2F7I2']")).click();
            //Отображение подробнее бонуса
            $(By.xpath("//div[@class='style_info__pnXwy']")).shouldBe(visible, exist);
            $(By.xpath("//*[text() = 'Активные']")).click();
            $(By.xpath("//*[text() = 'История']")).click();
        }

    @Test
    public void checknotify() throws InterruptedException {

        $(By.linkText("Уведомления")).click();
        $(By.xpath("//div[@class='notifications_title__noMyS']")).shouldBe(visible);
        $(By.xpath("//div[@class='accordion_item__HOBfC notifications_accordion__1yK1m']")).click();
        $(By.xpath("//div[@class='notifications_html__2HjhN']")).shouldBe(visible);
        $(By.xpath("//div[@class='notifications_date__3gHjM']")).shouldBe(visible);

    }
}