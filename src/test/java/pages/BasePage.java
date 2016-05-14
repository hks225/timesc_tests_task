package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import lib.BaseTestClass;
import lib.Timeout;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait loadingWait;
    protected WebDriverWait shortWait;
    
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.shortWait = new WebDriverWait(driver, Timeout.shortTimeout);
        this.loadingWait = new WebDriverWait(driver, Timeout.loading);
    }
    
    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getElement(By locator) {
        return driver.findElement(locator);
    }
    
    public void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            //
        }
    }
    
}
