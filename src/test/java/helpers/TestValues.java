package helpers;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class TestValues {

    /** Данные на для входа affiliate*/
    public  static  String logaff="email@m.m";
    public  static  String passaff="qwe123";
    /** Данные на страницу бэкофиса*/
    public  static  String loginback="v.mikhailov@ubet.kz";
    public  static  String passback="X7Qw3bv3Gpo77N";

    /** Номер заблокированного акк **/
    public  static  String accblock="7234567800";

    /** Номер аккаунта с запросом ИИН **/
    public  static  String acciin="7854478599";
    /** Базовый акк и код для тестов **/
    public  static  String baseacc="7234567878";
    public  static  String basecode="1111";

    public  static  String novalidcode="2222";

    /** Нарушении пункта 1 подпункта 27 документа**/
    public  static  String promoblockacc="7342342340";

    /** Отказ верификации **/
    public  static  String falseverifacc="7342342340";


}
