package main.java.timesc;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import pages.LandingPage;
import pages.MainPage;
import pages.SignInFormPage;
import pages.SignUpFormPage;
import lib.BaseTestClass;
import lib.User;

public class UserEditTest extends BaseTestClass {

	private static LandingPage landingPage;
	private static SignInFormPage signInFormPage;
	private static SignUpFormPage signUpFormPage;
	private static MainPage mainPage;
	final public static String mailDomain = "@freeletter.me";
	
	@BeforeClass
	public static void beforeClassMethod() {
		landingPage = new LandingPage(webDriver);
		signInFormPage = landingPage.openSignInPage();
		signUpFormPage = signInFormPage.openSignUpForm();
	}
	
	@Test
	public void editUserProfileTest() {
		User user1 = new User(generateName("firstName"),
				generateName("lastName"), "Kharkiv", generateName("tempmail")
						+ mailDomain, "12345678");
		signUpFormPage.sleep(5); // 5 milliseconds between generateName method calls, for different results
		User userUpdated = new User(generateName("firstName"),
				generateName("lastName"), "Moscow", user1.getEmail(), "12345678_2");
		mainPage = signUpFormPage.signUpByEmail(user1);
		mainPage.openSettings();
		//verify data for created user
		List<String> firstUserData = mainPage.getUserInfo();
		assertEquals(user1.getFirstName() + " " + user1.getLastName(), firstUserData.get(0));
		assertEquals(user1.getCity(), firstUserData.get(1));
		assertEquals(user1.getEmail(), firstUserData.get(2));
		mainPage.editUserProfile(userUpdated, user1.getPassword());
		//verify data after update
		List<String> updatedUserData = mainPage.getUserInfo();
		assertEquals(userUpdated.getFirstName() + " " + userUpdated.getLastName(), updatedUserData.get(0));
		assertEquals(userUpdated.getCity(), updatedUserData.get(1));
		//logout, sign in with new password
		landingPage = mainPage.logoutFromSettings();
		signInFormPage = landingPage.openSignInPage();
		signInFormPage.loginByEmail(user1.getEmail(), userUpdated.getPassword());
		mainPage.openSettings();
		//verify updated data after logout
		List<String> UpdatedUserDataAfterRelog = mainPage.getUserInfo();
		assertEquals(userUpdated.getFirstName() + " " + userUpdated.getLastName(), UpdatedUserDataAfterRelog.get(0));
		assertEquals(userUpdated.getCity(), UpdatedUserDataAfterRelog.get(1));
	}
	
}
