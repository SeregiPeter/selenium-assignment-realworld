package hu.elte.selenium.tests;

import hu.elte.selenium.pages.LoginPage;
import hu.elte.selenium.pages.RegisterPage;
import hu.elte.selenium.pages.SettingsPage;
import hu.elte.selenium.utils.TestDataGenerator;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Tests login and logout with a freshly registered user.
 */
public class LoginLogoutTest extends BaseTest {

    @Test
    public void registeredUserShouldBeAbleToLogoutAndLoginAgain() {
        String username = TestDataGenerator.uniqueUsername();
        String email = TestDataGenerator.uniqueEmail();
        String password = TestDataGenerator.defaultPassword();

        RegisterPage registerPage = registerNewUser(username, email, password);

        Assert.assertTrue(registerPage.isLoggedInNavigationVisible());

        SettingsPage settingsPage = new SettingsPage(driver)
                .openFromNavigation();

        settingsPage.logout();

        Assert.assertTrue(settingsPage.isPublicNavigationVisible());

        LoginPage loginPage = new LoginPage(driver)
                .openFromHomePage()
                .fillLoginForm(email, password);

        loginPage.submitLoginForm();

        Assert.assertTrue(loginPage.isLoggedInNavigationVisible());
    }
}