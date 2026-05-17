package hu.elte.selenium.pages;

import hu.elte.selenium.config.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page Object for the public home page of the Conduit application.
 */
public class HomePage extends BasePage {

    private static final String HOME_URL = ConfigReader.getBaseUrl();

    private final By brandLogo = By.cssSelector(".navbar-brand");
    private final By homeLink = By.xpath("//a[contains(@class, 'nav-link') and normalize-space()='Home']");
    private final By globalFeedTab = By.xpath("//a[contains(@class, 'nav-link') and normalize-space()='Global Feed']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage open() {
        driver.get(HOME_URL);
        waitUntilVisible(brandLogo);
        return this;
    }

    public boolean isBrandVisible() {
        return waitUntilVisible(brandLogo).isDisplayed();
    }

    public boolean isHomeLinkVisible() {
        return waitUntilVisible(homeLink).isDisplayed();
    }

    public boolean isGlobalFeedVisible() {
        return waitUntilVisible(globalFeedTab).isDisplayed();
    }
}