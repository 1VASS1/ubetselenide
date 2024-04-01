package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import core.BaseSelenideTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import static com.codeborne.selenide.Selenide.*;
import static helpers.TestValues.*;
import static helpers.TestLinks.*;
import static helpers.TestXpath.*;

public class backoffice extends BaseSelenideTest {

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

        open(back);
        $(By.name("login")).sendKeys(loginback);
        $(By.name("password")).sendKeys(passback);
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
        open(back);
        $(By.name("login")).sendKeys(loginback);
        $(By.name("password")).sendKeys(passback);
        $(By.xpath(submit)).click();
        $(By.xpath("//a[@href='/cashouts/list']")).click();
        $(By.xpath("//a[@class='btn btn-danger']")).click();
        $(By.xpath("//input[@value='5']")).click();
        $(By.xpath("//textarea[@name='why_rejected_message']")).sendKeys("test");
        $(By.xpath(submit)).click();


    }



    //Проверка всех ссылок в бэкофиссе
    @Test
    public void linksbackoffice() throws InterruptedException {

        open(back);
        $(By.name("login")).sendKeys(loginback);
        $(By.name("password")).sendKeys(passback);
        $(By.xpath(submit)).click();
        //Получаем основные разделы
        ElementsCollection links = $$("a[href]");

        for (int i = 0; i < links.size(); i++) {
            System.out.println(links.get(i).getAttribute("href"));
        }
        System.out.println("Количество ссылок на странице: " + links.size());
      }
    }

