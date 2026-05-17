package hu.elte.selenium.tests;

import hu.elte.selenium.pages.HomePage;
import hu.elte.selenium.pages.RegisterPage;
import hu.elte.selenium.utils.TestDataGenerator;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Tests user registration with generated random test data.
 */
public class RegisterTest extends BaseTest {

    @Test
    public void userShouldBeAbleToRegisterWithRandomCredentials() {
        String username = TestDataGenerator.uniqueUsername();
        String email = TestDataGenerator.uniqueEmail();
        String password = TestDataGenerator.defaultPassword();

        new HomePage(driver).open();

        RegisterPage registerPage = new RegisterPage(driver)
                .openFromHomePage()
                .fillRegistrationForm(username, email, password);

        registerPage.submitRegistrationForm();

        Assert.assertTrue(registerPage.isLoggedInNavigationVisible());
    }
}