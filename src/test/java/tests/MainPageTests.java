package tests;

import PageObject.MainPage;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class MainPageTests extends BaseTest {
        private String expectedText;
        private int number;
        public MainPageTests(String expectedText, int number) {
            this.expectedText = expectedText;
            this.number = number;
        }
    @Parameterized.Parameters(name = "Текст в выпадающем списке: {0} (Строка начинается с 0: {1})")
    public static Object[][] data2() {
        return new Object[][] {
                {"Сутки — 400 рублей. Оплата курьеру — наличными или картой.", 0},
                {"Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",1},
                {"Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.", 2},
                {"Только начиная с завтрашнего дня. Но скоро станем расторопнее.", 3},
                {"Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", 4},
                {"Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.", 5},
                {"Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", 6},
                {"Да, обязательно. Всем самокатов! И Москве, и Московской области.", 7},
        };
    }
        @Test
        public void testDropdownList() {
            driver.get("https://qa-scooter.praktikum-services.ru/");
            MainPage mainPage = new MainPage(driver);
            mainPage.scrollToDropdownArrow();
            mainPage.clickDropdownArrow(number);
            String textInDropdown = mainPage.getDropdownText(number).trim();
            Assert.assertEquals(expectedText, textInDropdown);
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