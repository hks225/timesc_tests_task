package lib;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import pages.BasePage;

public class BaseTestClass {

	 public static WebDriver webDriver;
	
	 @BeforeClass
	    public static void openUrl() {
	        webDriver = startNewDriver();
	        webDriver.manage().timeouts().implicitlyWait(200, TimeUnit.MILLISECONDS);
	        webDriver.get("https://time.sc");
	        BasePage page = new BasePage(webDriver);
	        page.setDriver(webDriver);
	        webDriver.manage().window().maximize();
	    }
	 
	 @AfterClass
	    public static void afterClass() {
		 	webDriver.quit();
	    }
	 
	  public static WebDriver startNewDriver() {
	        FirefoxProfile fxProfile = new FirefoxProfile();
	        fxProfile.setPreference("geo.prompt.testing", true);
	        fxProfile.setPreference("geo.prompt.testing.allow", true);
	        return new FirefoxDriver(fxProfile);
	    }
	  
	    public static synchronized String generateName(String prefix) {
	        return prefix + System.currentTimeMillis();
	    }
}
