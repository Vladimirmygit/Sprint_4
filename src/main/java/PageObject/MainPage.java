package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private WebDriver driver;
    //Найдем элемент стрелочки в выпадающем списке и кликним на него.
    private By arrow = By.xpath(".//div[@id='accordion__heading-0']");
    private By ScooterLogo = By.xpath(".//img[@alt='Scooter']");
    private By YandexLogo = By.xpath(".//img[@alt='Yandex']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    public void scrollToDropdownArrow() {
        WebElement element = driver.findElement(arrow);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }
    public void clickDropdownArrow(int number) {
        String arrowXpath = ".//div[@id='accordion__heading-" + number + "']";
        WebElement arrowElement = driver.findElement(By.xpath(arrowXpath));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.elementToBeClickable(arrowElement)).click();

    }
    public String getDropdownText(int number) {
        By dynamicLocator = By.xpath(".//div[@id='accordion__panel-"  + number + "']/p");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(dynamicLocator));
        return element.getText();
    }
    public void clickScooterLogo() {
        driver.findElement(ScooterLogo).click();
    }
    public void clickYandexLogo() {
        driver.findElement(YandexLogo).click();
    }
}