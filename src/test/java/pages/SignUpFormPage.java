package pages;

import lib.User;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SignUpFormPage extends BasePage {

	private static final By buttonToEmailSignUp = By.xpath("//button[@ui-sref='^.register.form']");
	private static final By buttonSignUp = By.xpath("//button[@ng-click='ctrl.submit()']");
	//signUp form
	private static final By firstNameInput = By.name("firstname");
	private static final By lastNameInput = By.name("lastname");
	private static final By geoInput = By.xpath("//input[@ng-model='ctrl.geo']");
	private static final By emailInput = By.name("email");
	private static final By passwordInput = By.name("password");
	private static final By secondPasswordInput = By.name("passwordRepeat");
		
	public SignUpFormPage(WebDriver driver) {
		super(driver);
		shortWait.until(ExpectedConditions.visibilityOfElementLocated(buttonToEmailSignUp));
	}

	public MainPage signUpByEmail(User user) {
		getElement(buttonToEmailSignUp).click();
		shortWait.until(ExpectedConditions.visibilityOfElementLocated(firstNameInput));
		getElement(firstNameInput).clear();
		getElement(firstNameInput).sendKeys(user.getFirstName());
		getElement(lastNameInput).clear();
		getElement(lastNameInput).sendKeys(user.getLastName());
		getElement(emailInput).clear();
		getElement(emailInput).sendKeys(user.getEmail());
		getElement(passwordInput).clear();
		getElement(passwordInput).sendKeys(user.getPassword());
		getElement(secondPasswordInput).clear();
		getElement(secondPasswordInput).sendKeys(user.getRepeatPassword());
		getElement(geoInput).clear();
		getElement(geoInput).sendKeys(user.getCity());
		getElement(By.xpath("//div[@class='geo-autocomplete-dropdown__text'][normalize-space()='"+ user.getCity() + "']/../..")).click();
		getElement(firstNameInput).click(); //set focus to close list in geoInput
		sleep(300); //for same reason
		getElement(buttonSignUp).click();
		shortWait.until(ExpectedConditions.invisibilityOfElementLocated(firstNameInput));
		return new MainPage(driver);
	}
	
}
