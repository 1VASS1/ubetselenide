package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import core.BaseSelenideTest;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import java.io.File;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static helpers.TestValues.*;
import static helpers.TestLinks.*;
import static helpers.TestXpath.*;


public class Profile extends BaseSelenideTest {

    //Проверка загрузки файлов и отправки на верификацию

    @Test
    public void verif() throws InterruptedException {
        baseauth();
        $("header").shouldBe(exist,visible);
        open(profile);
        $(By.xpath("//div[@class='confirmed_text1__2EPHx']")).shouldHave(text(" Аккаунт ID: 68960 успешно верифицирован. "));
        $(By.xpath("//*[contains(text(), 'Обновить данные')]")).click();
        $(By.xpath("//*[contains(text(), 'Удостоверение личности РК')]")).click();

        $x("//div[1]/input").uploadFile(new File("C:\\1.jpg"));
        $x("//div[2]/input").uploadFile(new File("C:\\1.jpg"));
        $x("//div[3]/input").uploadFile(new File("C:\\1.jpg"));

        $x("//*[contains(text(), 'Отправить')]").click();
        $(By.xpath("//div[@class='documents_back__2o0Fu']")).shouldHave(text("назад"));
        $(By.xpath("//*[text() = 'Данные успешно отправлены! ']")).shouldBe(exist,visible);;

    }

    @Test
    //Проверка иин
    // Проверка на черный список
    // Проверка на возраст
    // Проверка на дубликат
    // Проверка валидации ИИН

    public void inn() throws InterruptedException {
        open(reg);
        $(By.name("phone")).sendKeys(acciin);
        $(By.xpath(submit)).click();
        $(By.cssSelector("[data-id='0']")).sendKeys("1111");
        $("header").shouldBe(exist,visible);
        $(By.xpath("//input[@id='iin']")).shouldBe(visible).sendKeys("850505300686");
        $(By.xpath("//input[@id='birthdate']")).sendKeys("05.05.1985");
        $(By.xpath("//button[@class='button_input__2TvKU button_big__3J0-f button_yellow__2REE2 identification_next__2Uh_e']")).click();
        $(Selectors.byText("ИИН заблокирован")).shouldBe(visible);
        open(cashbox);
        refresh();
        $(By.xpath("//input[@id='iin']")).sendKeys("850505300686");
        $(By.xpath("//input[@id='birthdate']")).sendKeys("05.05.2010");
        $(By.xpath("//button[@class='button_input__2TvKU button_big__3J0-f button_yellow__2REE2 identification_next__2Uh_e']")).click();
        $(Selectors.byText("Возраст меньше 21 года")).shouldBe(visible);
        refresh();
        $(By.xpath("//input[@id='iin']")).sendKeys("990101565656");
        $(By.xpath("//input[@id='birthdate']")).sendKeys("01.01.1999");
        $(By.xpath("//button[@class='button_input__2TvKU button_big__3J0-f button_yellow__2REE2 identification_next__2Uh_e']")).click();
        $(Selectors.byText("ИИН уже зарегистрирован")).shouldBe(visible);
        refresh();
        $(By.xpath("//input[@id='iin']")).sendKeys("123131231231");
        $(By.xpath("//input[@id='birthdate']")).sendKeys("01.01.1999");
        $(By.xpath("//button[@class='button_input__2TvKU button_big__3J0-f button_yellow__2REE2 identification_next__2Uh_e']")).click();
        $(Selectors.byText("Неправильный ИИН")).shouldBe(visible);

    }



    //Промокод не может быть активирован по подозрению в нарушении пункта 1 подпункта 27
    @Test
    public void promorule() throws InterruptedException {
        open(reg);
        $(By.name("phone")).sendKeys(promoblockacc);
        $(By.xpath(submit)).click();
        $(By.cssSelector("[data-id='0']")).sendKeys(basecode);
        $("header").shouldBe(exist,visible);
        open(promocode);
        $(By.className("promocode_inputText__3kk0D")).click();
        $(By.className("promocode_inputText__3kk0D")).sendKeys("bet5000");
        $(By.xpath("//*[text() = 'Активировать']")).click();
        $(Selectors.byText("Промокод не может быть активирован по подозрению в нарушении пункта 1 подпункта 27 документа \"Правила приема ставок\"")).shouldBe(visible);

    }



    @Test
    //* Тестирование уведомление промокода
    //* Промокод за регистрацию можно использовать один раз
    //* Промокод неверный
    //* Промокод уже использован
    //* Срок действия промокода истёк
    public void promonovalid() throws InterruptedException {
        //Инициализация базовой авторизации
        baseauth();
        $("header").shouldBe(exist,visible);
        open(promocode);
        $(By.xpath("//input[@value='']")).sendKeys("bet5000");
        $(By.xpath("//*[text() = 'Активировать']")).click();
        $(By.xpath("//*[text() = 'Промокод за регистрацию можно использовать один раз']")).shouldBe(exist,visible);
        $(By.className("promocode_inputText__3kk0D")).clear();

        $(By.className("promocode_inputText__3kk0D")).sendKeys("testnovalidpromo");
        $(By.xpath("//*[text() = 'Активировать']")).click();
        $(By.xpath("//*[text() = 'Промокод неверный']")).shouldBe(exist,visible);;
        $(By.className("promocode_inputText__3kk0D")).clear();

        $(By.className("promocode_inputText__3kk0D")).sendKeys("testwagdidg");
        $(By.xpath("//*[text() = 'Активировать']")).click();
        $(By.xpath("//*[text() = 'Промокод уже использован']")).shouldBe(exist,visible);;
        $(By.className("promocode_inputText__3kk0D")).clear();

        $(By.className("promocode_inputText__3kk0D")).sendKeys("ubet_82d0a7");
        $(By.xpath("//*[text() = 'Активировать']")).click();
        $(By.xpath("//*[text() = 'Срок действия промокода истёк']")).shouldBe(exist,visible);;
    }

    //* Тестирование отказа верификации
    @Test
    public void falseverif() throws InterruptedException {
        open(reg);
        $(By.name("phone")).sendKeys(falseverifacc);
        $(By.xpath(submit)).click();
        $(By.cssSelector("[data-id='0']")).sendKeys(basecode);
        $("header").shouldBe(exist,visible);
        open(profile);
        $(By.xpath("//*[text() = 'Верификация не пройдена по причине:']")).shouldBe(exist,visible);
        $(By.xpath("//*[text() = 'test']")).shouldBe(exist,visible);
        $(By.xpath("//button[@class='button_input__2TvKU button_big__3J0-f button_yellow__2REE2 ']")).shouldBe(exist,visible);
        $(By.xpath("//*[text() = 'Обновить данные']")).shouldBe(exist,visible);

    }

    //Пополнение кошелька WooPay старый
    @Ignore
    public void cashbox() throws InterruptedException {
        baseauth();
        $("header").shouldBe(exist,visible);
        open(cashbox);
        $(By.xpath("//div[@id='react-tabs-7']/div/div[12]/div[6]/button")).click();
        $(By.cssSelector("input[type=tel]")).sendKeys("10000");
        $(By.xpath("/html/body/div[1]/div/div[3]/div/div/main/div/div[2]/div[1]/div/div/div/div[2]/div/div/div/div[3]/div/div/div[2]/div/div/div[1]/div/div[2]/div/div[4]/input")).sendKeys("7773510508");
        $(By.xpath("//*[text() = 'Далее']")).click();
        //Переход на Iframe
        WebElement iframe = $(By.cssSelector("#react-tabs-13 > div > iframe"));
        switchTo().frame(iframe);
        $(By.xpath("//*[text() = 'Баланс мобильного']")).click();
        $(By.xpath("//input[@type='submit']")).click();
        $(By.xpath("//input[@name='PhoneConfirmationCodeForm[code]']")).sendKeys("111111");
        $(By.xpath("//input[@type='submit']")).click();
    }
    @Test
    //Пополнение Woopay Нативный
    public void depositwoopay() throws InterruptedException {
        baseauth();
        $(By.xpath("//div/div[10]/div[6]/button")).click();
        $(By.xpath("//div/div[2]/div/div[2]/input")).sendKeys("10000");
        $(By.xpath("//div/div[2]/div/div[4]/div/input")).sendKeys("7775688668");
        $(By.xpath("//*[text() = 'Продолжить']")).click();
        $(By.xpath("//input[@data-id='0']")).sendKeys("103000");
        $(By.xpath("//*[text() = 'Неверный код']")).shouldBe(exist,visible);;
        $(By.xpath("//input[@data-id='0']")).sendKeys("104000");
        $(By.xpath("//*[text() = 'Ваш платеж в обработке...']")).shouldBe(exist,visible);;
        $(By.xpath("//*[text() = 'Баланс пополнен на сумму']")).shouldBe(exist,visible);;
        $(By.xpath("//*[text() = 'Сделать ставку']")).shouldBe(exist,visible);;

    }
}

