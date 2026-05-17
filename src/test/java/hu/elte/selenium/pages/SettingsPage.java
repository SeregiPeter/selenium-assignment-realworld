package hu.elte.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page Object for the settings page.
 * The logout button is available on this page.
 */
public class SettingsPage extends BasePage {

    private final By settingsLink = By.xpath("//a[contains(@href, '/settings')]");
    private final By logoutButton = By.xpath("//button[contains(@class, 'btn-outline-danger') and contains(normalize-space(), 'logout')]");
    private final By signInLink = By.xpath("//a[contains(@href, '/login')]");

    public SettingsPage(WebDriver driver) {
        super(driver);
    }

    public SettingsPage openFromNavigation() {
        click(settingsLink);
        waitUntilVisible(logoutButton);
        return this;
    }

    public void logout() {
        click(logoutButton);
    }

    public boolean isPublicNavigationVisible() {
        return waitUntilVisible(signInLink).isDisplayed();
    }
}