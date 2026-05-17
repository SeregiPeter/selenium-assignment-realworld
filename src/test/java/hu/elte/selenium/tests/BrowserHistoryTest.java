package hu.elte.selenium.tests;

import hu.elte.selenium.pages.HomePage;
import hu.elte.selenium.pages.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Tests browser history navigation with back and forward actions.
 */
public class BrowserHistoryTest extends BaseTest {

    @Test
    public void browserBackAndForwardShouldNavigateBetweenHomeAndRegistrationPage() {
        HomePage homePage = new HomePage(driver).open();

        RegisterPage registerPage = new RegisterPage(driver).openFromHomePage();

        Assert.assertTrue(registerPage.isRegistrationFormVisible());

        driver.navigate().back();

        Assert.assertTrue(homePage.isHomeLinkVisible());
        Assert.assertTrue(homePage.isGlobalFeedVisible());

        driver.navigate().forward();

        Assert.assertTrue(registerPage.isRegistrationFormVisible());
    }
}