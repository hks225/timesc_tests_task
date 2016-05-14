package pages;

import lib.Timeout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage extends BasePage {

	private static final By signInButton = By.cssSelector(".landing__enter-popup");
	private static final By signInPopupForm = By.cssSelector(".popup-form--signin");
	
    public LandingPage(WebDriver driver) {
    	super(driver);
        shortWait.until(ExpectedConditions.visibilityOfElementLocated(signInButton));
    }
	
    public SignInFormPage openSignInPage() {
    	getElement(signInButton).click();
    	loadingWait.until(ExpectedConditions.visibilityOfElementLocated(signInPopupForm));
    	return new SignInFormPage(driver);
    }
    
}
