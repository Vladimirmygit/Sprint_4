package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    private WebDriver driver;

    //Найдем элемент стрелочки в выпадающем списке и кликним на него.
    private By arrow = By.xpath(".//div[@id='accordion__heading-0']");
    //Поверим, что соответствующий текст отобразился.
    private By TextInArrow = By.xpath(".//div[@data-accordion-component='AccordionItemPanel' and p][1]");
    private By ScooterLogo = By.xpath(".//img[@alt='Scooter']");
    private By YandexLogo = By.xpath(".//img[@alt='Yandex']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    public void scrollToDropdownArrow() {
        WebElement element = driver.findElement(arrow);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }
    public void clickDropdownArrow() {
        driver.findElement(arrow).click();
    }
    public String getDropdownText() {
      return  driver.findElement(TextInArrow).getText();
    }
    public void clickScooterLogo() {
        driver.findElement(ScooterLogo).click();
    }
    public void clickYandexLogo() {
        driver.findElement(YandexLogo).click();
    }
}