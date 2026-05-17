package hu.elte.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page Object for the login page.
 */
public class LoginPage extends BasePage {

    private final By signInLink = By.xpath("//a[contains(@href, '/login')]");
    private final By emailInput = By.xpath("//input[@placeholder='Email']");
    private final By passwordInput = By.xpath("//input[@placeholder='Password']");
    private final By signInButton = By.xpath("//button[normalize-space()='Sign in']");
    private final By newArticleLink = By.xpath("//a[contains(@class, 'nav-link') and contains(normalize-space(), 'New Article')]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage openFromHomePage() {
        click(signInLink);
        waitUntilVisible(emailInput);
        return this;
    }

    public LoginPage fillLoginForm(String email, String password) {
        type(emailInput, email);
        type(passwordInput, password);
        return this;
    }

    public void submitLoginForm() {
        click(signInButton);
    }

    public boolean isLoggedInNavigationVisible() {
        return waitUntilVisible(newArticleLink).isDisplayed();
    }
}