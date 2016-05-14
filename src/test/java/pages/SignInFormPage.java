package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInFormPage extends BasePage {

	private static final By linkToSignUpForm = By.xpath("//a[@ng-click='ctrl.goToRegister()']");
	private static final By emailInput = By.name("email");
	private static final By passwordInput = By.name("password");
	private static final By signInButton = By.xpath("//button[@ng-click='ctrl.signIn()']");
	
	 public SignInFormPage(WebDriver driver) {
	        super(driver);
	    }
	
	 public MainPage loginByEmail(String email, String password) {
		 getElement(emailInput).clear();
		 getElement(emailInput).sendKeys(email);
		 getElement(passwordInput).clear();
		 getElement(passwordInput).sendKeys(password);
		 getElement(signInButton).click();
		 return new MainPage(driver);
	 }
	 
	 public SignUpFormPage openSignUpForm() {
		 getElement(linkToSignUpForm).click();		 
		 return new SignUpFormPage(driver);
	 }
	 
}
