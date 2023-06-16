package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPage {
    private WebDriver driver;

    private By orderButtonHeader = By.xpath(".//button[@class = 'Button_Button__ra12g' and .='Заказать']");
    private By orderButtonMiddle = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    private By firstName = By.xpath(".//input[@placeholder='* Имя']");
    private By lastName = By.xpath(".//input[@placeholder='* Фамилия']");
    private By address = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private By metroStation = By.xpath(".//input[@placeholder='* Станция метро']");
    private By buttonConfirmedMetroStation = By.xpath(".//div[@class='select-search__select']");
    private By Phone = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private By nextButton = By.xpath("//*[@class='Button_Button__ra12g Button_Middle__1CSJM' and .='Далее']");
    private By dataField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private By dataDay = By.xpath(".//div[@class='react-datepicker__day react-datepicker__day--015']");
    private By rentField = By.xpath("//*[.='* Срок аренды']");
    private By rentTime = By.xpath("//*[.='сутки']");
    private By colorCheckbox = By.xpath(".//input[@class='Checkbox_Input__14A2w']");
    private By commentField = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    private By orderButton = By.xpath(".//*[@class='Button_Button__ra12g Button_Middle__1CSJM' and .='Заказать']");
    private By buttonOrderConfirmation = By.xpath("//*[.='Да']");
    private By orderMessage = By.xpath("//div[@class='Order_ModalHeader__3FDaJ']");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickOrderButtonHeader() {
        driver.findElement(orderButtonHeader).click();
    }
    public void scrollToButtonMiddle() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script = "window.scrollBy(0, 2000);";
        js.executeScript(script);
    }
    public void clickOrderButtonMiddle() {
        driver.findElement(orderButtonMiddle).click();
    }
   public void inputFirstName(String userFirstname) {
        driver.findElement(firstName).sendKeys(userFirstname);
    }
    public void inputLastName(String userLastName) {
        driver.findElement(lastName).sendKeys(userLastName);
    }
    public void inputAddress(String userAddress) {
        driver.findElement(address).sendKeys(userAddress);
    }
    public void inputMetroStation(String userMetroStation) {
        driver.findElement(metroStation).sendKeys(userMetroStation);
    }
    public void clickMetroStation() {
        driver.findElement(buttonConfirmedMetroStation).click();
    }
    public void inputPhone(String userPhone) {
        driver.findElement(Phone).sendKeys(userPhone);
    }
    public void enterDate (String userFirstname, String userLastName,String userAddress, String userMetroStation, String userPhone) {
        inputFirstName(userFirstname);
        inputLastName(userLastName);
        inputAddress(userAddress);
        inputMetroStation(userMetroStation);
        clickMetroStation();
        inputPhone(userPhone);
    }
    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }
    public void clickDataField() {
        driver.findElement(dataField).click();
    }
    public void clickDataDay() {
        driver.findElement(dataDay).click();
    }
    public void clickRentField() {
        driver.findElement(rentField).click();
    }
    public void clickRentTime() {
        driver.findElement(rentTime).click();
    }
    public void clickColorCheckbox() {
        driver.findElement(colorCheckbox).click();
    }
    public void writeCommentField(String userComment) {
        driver.findElement(commentField).sendKeys(userComment);
    }
    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }
    public void enterDateRent(String userComment) {
        clickDataField();
        clickDataDay();
        clickRentField();
        clickRentTime();
        clickColorCheckbox();
        writeCommentField(userComment);
        clickOrderButton();

    }
    public void clickButtonOrderConfirmation() {
        driver.findElement(buttonOrderConfirmation).click();
    }
        public  String getOrderMessage() {
            String fullText = driver.findElement(orderMessage).getText();
            String firstFourteenChars = fullText.substring(0, Math.min(fullText.length(), 14));
            return firstFourteenChars;
        }


}
