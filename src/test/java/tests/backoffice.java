package tests;

import com.codeborne.selenide.Configuration;
import core.BaseSelenideTest;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import static com.codeborne.selenide.Selenide.*;
import static helpers.TestValues.*;
import static helpers.TestLinks.*;

public class backoffice extends BaseSelenideTest{
    /**Верификаци пользователя**/
    @Test
    public void verifuser() throws InterruptedException {
        //* Генерируем номер
        int inn = (int) ( Math.random() * 300001 );
        int docnum = (int) ( Math.random() * 30001 );

        open(back);
        $(By.name("login")).sendKeys(loginback);
        $(By.name("password")).sendKeys(passback);
        $(By.xpath("//button[@type='submit']")).click();
        $(By.xpath("//a[@href='/players/unverifiedList']")).click();
        $(By.xpath("//a[@type='button']")).click();
        $(By.id("doc_type")).selectOptionContainingText("Паспорт РК");
        $(By.id("doc_number")).sendKeys("1" + docnum);
        $(By.id("doc_validity_date")).sendKeys("28-03-2030");
        $(By.id("issuing_authority")).sendKeys("Тест округа");
        $(By.id("iin")).sendKeys("990430" + inn);
        $(By.id("firstname")).sendKeys("Василий");
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

    /**Отказ верификаци пользователя**/
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
}
