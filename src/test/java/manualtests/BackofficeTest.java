package tests;

import com.codeborne.selenide.ElementsCollection;
import core.BaseSelenideTest;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static com.google.common.util.concurrent.Futures.submit;
import static helpers.TestXpath.*;

public class BackofficeTest extends BaseSelenideTest {

    /**
     * Ручные тесты бэкофис
     **/

    //Провести верификацию пользователя c заполнением полных данных
    @Test
    public void verifuser() throws InterruptedException {
        //* Генерируем номер
        int inn = (int) (Math.random() * 300001);
        int docnum = (int) (Math.random() * 30001);

        authbackoffice();
        $(By.xpath("//a[@href='/players/unverifiedList']")).click();
        $(By.xpath("//a[@type='button']")).click();
        $(By.id("doc_type")).selectOptionContainingText("Паспорт РК");
        $(By.id("doc_number")).sendKeys("1" + docnum);
        $(By.id("doc_date")).sendKeys("28-03-1999");
        $(By.id("doc_validity_date")).sendKeys("28-03-2030");
        $(By.id("issuing_authority")).sendKeys("Тест округа");
        $(By.id("iin")).sendKeys("990430" + inn);
        $(By.id("firstname")).sendKeys("Генадий");
        $(By.id("surname")).sendKeys("Test");
        $(By.id("lastname")).sendKeys("Test");
        $(By.id("birthday")).sendKeys("30-04-1999");
        $(By.id("bpl")).sendKeys("test");
        $(By.id("sex")).selectOptionContainingText("male");
        $(By.id("city_id")).selectOptionContainingText("Есик");
        $(By.id("is_RK_resident")).selectOptionContainingText("Да");
        $(By.id("citizenship")).selectOptionByValue("398");
        $(By.id("check_duplicate_button")).click();
        $(By.id("verifivate_button")).click();

    }

    //Провести верификацию пользователя без ИИН и Даты рождения
    @Test
    public void verifusernoinnnobirthday() throws InterruptedException {
        //* Генерируем номер
        int docnum = (int) (Math.random() * 30001);

        authbackoffice();
        $(By.xpath("//a[@href='/players/unverifiedList']")).click();
        $(By.xpath("//a[@type='button']")).click();
        $(By.id("doc_type")).selectOptionContainingText("Паспорт РК");
        $(By.id("doc_number")).sendKeys("1" + docnum);
        $(By.id("doc_date")).sendKeys("28-03-1999");
        $(By.id("doc_validity_date")).sendKeys("28-03-2030");
        $(By.id("issuing_authority")).sendKeys("Тест округа");
        $(By.id("firstname")).sendKeys("Василий");
        $(By.id("surname")).sendKeys("Test");
        $(By.id("lastname")).sendKeys("Test");
        $(By.id("bpl")).sendKeys("test");
        $(By.id("sex")).selectOptionContainingText("male");
        $(By.id("city_id")).selectOptionContainingText("Есик");
        $(By.id("is_RK_resident")).selectOptionContainingText("Да");
        $(By.id("citizenship")).selectOptionByValue("398");
        $(By.id("check_duplicate_button")).click();
        $(By.id("verifivate_button")).click();

    }

    //Отказ верификаци пользователя
    @Test
    public void falseverif() throws InterruptedException {

        authbackoffice();
        $(By.xpath("//button[@type='submit']")).click();
        $(By.xpath("//a[@href='/players/unverifiedList']")).click();
        $(By.xpath("//a[@type='button']")).click();
        $(By.linkText("Отказать")).click();
        $(By.id("why_not_approved")).click();
        $(By.id("why_not_approved")).sendKeys("TEST");
        $(By.id("reject_button")).click();
    }

    @Test
    @DisplayName("Отказ вывода пользователю")
    //Выполнять тест если нужно несколько выводов подряд
    //@RepeatedTest(5)
    public void falsepay() throws InterruptedException {
        authbackoffice();
        $(By.xpath("//a[@href='/cashouts/list']")).click();
        $(By.xpath("//a[@class='btn btn-danger']")).click();
        $(By.xpath("//input[@value='5']")).click();
        $(By.xpath("//textarea[@name='why_rejected_message']")).sendKeys("test");
        $(By.xpath(submit)).click();


    }



    //Проверка всех ссылок в бэкофиссе
    @Test
    public void linksbackoffice() throws InterruptedException {

        authbackoffice();
        //Получаем основные разделы
        ElementsCollection links = $$("a[href]");

        for (int i = 0; i < links.size(); i++) {
            System.out.println(links.get(i).getAttribute("href"));
        }
        System.out.println("Количество ссылок на странице: " + links.size());
      }




    //Генерация промокода фрибет
    @Test
    public void createpromo()  {
        authbackoffice();
        open("https://backoffice-test.ubet.kz/promocodes/list");
        $(By.xpath("//a[@href='/promocodes/add']")).click();
        $(By.id("issueTools")).selectOptionContainingText("Free Bet");
        $(By.id("type")).selectOptionContainingText("Массовый");
        $(By.id("device")).selectOptionContainingText("web & app");

        $(By.name("min_odds")).sendKeys("1");

        $(By.id("limit_count_bet")).click();
        $(By.id("limit_count_bet")).clear();
        $(By.id("limit_count_bet")).sendKeys("1");

        $(By.id("name")).sendKeys("AUTOTEST PROMO");
        $(By.id("date_start")).sendKeys("01-04-2024");
        $(By.id("date_end")).sendKeys("01-04-2029");
        $(By.id("active_tm")).sendKeys("777");
        $(By.id("time_to_activation")).sendKeys("777");
        $(By.id("codeRow")).click();
        String randtext = RandomStringUtils.randomAlphabetic(3).toLowerCase();
        $(By.id("code")).sendKeys("promo" + randtext);
        $(By.id("activations")).sendKeys("777");
        $(By.id("bonus_summ")).sendKeys("5000");
        $(By.xpath(submit)).click();
    }
    }

