package pages;

import java.util.ArrayList;
import java.util.List;

import lib.User;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage {

	private static final By toolbarGroup = By.className("toolbar__group");
	private static final By settingsOnToolbar = By.xpath("//*[@di-xlink-href='#cogwheel']");
	private static final By userInfo = By.cssSelector(".profile-row__value");
	private static final By editProfileLink = By.xpath("//a[@ng-click='profile.toEdit()']");
	private static final By updateSaveProfileButton = By.xpath("//button[@ng-click='profile.updateProfile()']");
	private static final By logoutFromSettingsLink = By.xpath("//a[@ng-click='profile.logout()']");
	//profile 
	private static final By firstNameInput = By.name("firstname");
	private static final By lastNameInput = By.name("lastname");
	private static final By geoInput = By.xpath("//input[@ng-model='profile.user.geo']");
	private static final By emailInput = By.name("email");
	private static final By passwordInput = By.name("password_new");
	private static final By secondPasswordInput = By.name("passwordRepeat");	
	private static final By oldPasswordInput = By.name("currentPassword");
	
	public MainPage(WebDriver driver) {
		super(driver);
		shortWait.until(ExpectedConditions.visibilityOfElementLocated(toolbarGroup));
	}

	public MainPage openSettings() {
		shortWait.until(ExpectedConditions.elementToBeClickable(settingsOnToolbar));
		getElement(settingsOnToolbar).click();
		shortWait.until(ExpectedConditions.visibilityOfElementLocated(userInfo));
		return this;
	}
	
	public List<String> getUserInfo() {
		List<String> result = new ArrayList();
		List<WebElement> elems = driver.findElements(userInfo);
		for (int i = 0; i < elems.size(); i++) {
			result.add(elems.get(i).getText());
		}
		return result;
	}
	
	public MainPage editUserProfile(User user, String oldPassword) {
		getElement(editProfileLink).click();
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
		getElement(oldPasswordInput).clear();
		getElement(oldPasswordInput).sendKeys(oldPassword);
		getElement(geoInput).clear();
		getElement(geoInput).sendKeys(user.getCity());
		getElement(By.xpath("//div[@class='geo-autocomplete-dropdown__text'][normalize-space()='"+ user.getCity() + "']/../..")).click();
		getElement(firstNameInput).click(); //set focus to close list in geoInput
		sleep(300); //for same reason
		getElement(updateSaveProfileButton).click();
		shortWait.until(ExpectedConditions.invisibilityOfElementLocated(firstNameInput));
		return this;
	}
	
	public LandingPage logoutFromSettings() {
		getElement(logoutFromSettingsLink).click();
		return new LandingPage(driver);
	}
	
}
