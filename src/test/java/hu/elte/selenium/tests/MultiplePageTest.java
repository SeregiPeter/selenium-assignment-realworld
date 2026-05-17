package hu.elte.selenium.tests;

import hu.elte.selenium.config.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

/**
 * Tests multiple public pages using the same test logic.
 */
public class MultiplePageTest extends BaseTest {

    @Test
    public void publicPagesShouldLoadWithExpectedElements() {
        Object[][] pages = {
                {"", By.xpath("//a[contains(@class, 'navbar-brand')]")},
                {"login", By.xpath("//input[@placeholder='Email']")},
                {"register", By.xpath("//input[@placeholder='Username']")}
        };

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        for (Object[] page : pages) {
            String path = (String) page[0];
            By expectedElement = (By) page[1];

            driver.get(ConfigReader.getBaseUrl() + path);

            Assert.assertEquals(driver.getTitle(), "Conduit");

            WebElement visibleElement = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(expectedElement)
            );

            Assert.assertTrue(visibleElement.isDisplayed());
        }
    }
}