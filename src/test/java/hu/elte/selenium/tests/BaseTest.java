package hu.elte.selenium.tests;

import hu.elte.selenium.config.DriverFactory;
import hu.elte.selenium.listeners.ScreenshotOnFailureListener;
import hu.elte.selenium.pages.HomePage;
import hu.elte.selenium.pages.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

/**
 * Common parent class for Selenium test classes.
 * It opens and closes the browser around each test method.
 */
@Listeners(ScreenshotOnFailureListener.class)
public abstract class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUpBrowser() {
        driver = DriverFactory.createDriver();
    }

    @AfterMethod
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    protected RegisterPage registerNewUser(String username, String email, String password) {
        new HomePage(driver).open();

        RegisterPage registerPage = new RegisterPage(driver)
                .openFromHomePage()
                .fillRegistrationForm(username, email, password);

        registerPage.submitRegistrationForm();

        return registerPage;
    }
}