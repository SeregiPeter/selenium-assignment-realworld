package hu.elte.selenium.config;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Creates and configures WebDriver instances for the test suite.
 */
public class DriverFactory {

    private DriverFactory() {}

    public static WebDriver createDriver() {
        ChromeOptions options = new ChromeOptions();

        if (Boolean.parseBoolean(System.getProperty("headless", "false"))) {
            options.addArguments("--headless=new");
        }

        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().setSize(new Dimension(1400, 1000));

        return driver;
    }
}