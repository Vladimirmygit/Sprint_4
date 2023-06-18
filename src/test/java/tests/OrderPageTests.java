package tests;

import PageObject.OrderPage;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class OrderPageTests extends BaseTest {
    private String firstName;
    private String lastName;
    private String address;
    private String metroStation;
    private String phone;
    private String userComment;

    public OrderPageTests(String firstName, String lastName, String address, String metroStation, String phone, String userComment) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.metroStation = metroStation;
        this.phone = phone;
        this.userComment = userComment;
    }
    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][] {
                {"Иван", "Иванов", "Революции 17", "Коломенская", "+79992221121", "Тестовый коммент 1"},
                {"Инна", "Кузнецова", "Пушкина 7", "Сокольники", "+79911111111", "Тестовый коммент 2"},
                {"Владимир", "Иванов", "Мира 11", "Лубянка", "+79922222222", "Тестовый коммент 3"},
                {"Ольга", "Иванова", "площадь дружбы 17", "Арбатская", "+79933333333", "Тестовый коммент 4"},
        };
    }
    @Test
    public void testMakeAnOrderViaButtonInHeader() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        OrderPage orderPage = new OrderPage(driver);
        //Клик по кнопке "Заказать"
        orderPage.clickOrderButtonHeader();
        //Ввод данных для заказа
        orderPage.enterDate(firstName, lastName, address, metroStation, phone);
        //Клик по кнопке "Далее"
        orderPage.clickNextButton();
        //Ввод данных
        orderPage.enterDateRent(userComment);
        //Подтверждаем заказ
        orderPage.clickButtonOrderConfirmation();
        //Ожидаем уведомление "Заказ оформлен"
        final String expectedText = "Заказ оформлен";
        orderPage.getOrderMessage();
        String actualText = orderPage.getOrderMessage();
        Assert.assertEquals(expectedText, actualText);
    }
     @Test
    public void testMakeOrderViaButtonMiddle() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        OrderPage orderPage = new OrderPage(driver);
        orderPage.scrollToButtonMiddle();
        orderPage.clickOrderButtonMiddle();
        //Ввод данных для заказа
        orderPage.enterDate(firstName, lastName, address, metroStation, phone);
        //Клик по кнопке "Далее"
        orderPage.clickNextButton();
        //Ввод данных
        orderPage.enterDateRent(userComment);
        //Подтверждаем заказ
        orderPage.clickButtonOrderConfirmation();
        //Ожидаем уведомление о заказе
         final String expectedText = "Заказ оформлен";
         orderPage.getOrderMessage();
         String actualText = orderPage.getOrderMessage();
         Assert.assertEquals("Нет уведомления об оформлении заказа", expectedText, actualText);
    }
}