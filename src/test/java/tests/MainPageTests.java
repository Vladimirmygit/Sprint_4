package tests;

import PageObject.MainPage;
import org.junit.Assert;
import org.junit.Test;

    public class MainPageTests extends BaseTest {

        @Test
        public void testDropdownList() {
            driver.get("https://qa-scooter.praktikum-services.ru/");
            MainPage mainPage = new MainPage(driver);
            String text = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
            mainPage.scrollToDropdownArrow();
            mainPage.clickDropdownArrow();
            mainPage.getDropdownText();
            String textInDropdown = mainPage.getDropdownText();
            Assert.assertEquals("Текст в выпадающем списке не соответствует переменной text", textInDropdown, text);
        }

        @Test
        public void testClickScooterLogo() {
            driver.get("https://qa-scooter.praktikum-services.ru/");
            MainPage mainPage = new MainPage(driver);
            mainPage.clickScooterLogo();
            String expectedUrl = "https://qa-scooter.praktikum-services.ru/";
            String actualUrl = driver.getCurrentUrl();
            Assert.assertEquals("логотип сайта самоката редиректит не на свою главную страницу", expectedUrl, actualUrl);


        }
        @Test
        public void testClickYandexLogo() {
            driver.get("https://qa-scooter.praktikum-services.ru/");
            MainPage mainPage = new MainPage(driver);
            mainPage.clickYandexLogo();

        }
    }







