package hu.elte.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page Object for the registration page.
 */
public class RegisterPage extends BasePage {

    private final By signUpLink = By.xpath("//a[contains(@class, 'nav-link') and normalize-space()='Sign up']");
    private final By usernameInput = By.xpath("//input[@placeholder='Username']");
    private final By emailInput = By.xpath("//input[@placeholder='Email']");
    private final By passwordInput = By.xpath("//input[@placeholder='Password']");
    private final By signUpButton = By.xpath("//button[normalize-space()='Sign up']");
    private final By newArticleLink = By.xpath("//a[contains(@class, 'nav-link') and contains(normalize-space(), 'New Article')]");
    private final By settingsLink = By.xpath("//a[contains(@href, '/settings')]");
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public RegisterPage openFromHomePage() {
        click(signUpLink);
        waitUntilVisible(usernameInput);
        return this;
    }

    public RegisterPage fillRegistrationForm(String username, String email, String password) {
        type(usernameInput, username);
        type(emailInput, email);
        type(passwordInput, password);
        return this;
    }

    public void submitRegistrationForm() {
        click(signUpButton);
    }

    public boolean isLoggedInNavigationVisible() {
        waitUntilVisible(newArticleLink);
        return waitUntilVisible(settingsLink).isDisplayed();
    }

    public boolean isRegistrationFormVisible() {
        return waitUntilVisible(usernameInput).isDisplayed()
                && waitUntilVisible(emailInput).isDisplayed()
                && waitUntilVisible(passwordInput).isDisplayed();
    }
}