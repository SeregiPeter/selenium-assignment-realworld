package hu.elte.selenium.listeners;

import hu.elte.selenium.tests.BaseTest;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

/**
 * TestNG listener that automatically saves a screenshot when a test fails.
 */
public class ScreenshotOnFailureListener implements ITestListener {

    private static final String SCREENSHOT_FOLDER = "screenshots";

    @Override
    public void onTestFailure(ITestResult result) {
        Object testInstance = result.getInstance();

        if (!(testInstance instanceof BaseTest)) {
            return;
        }

        WebDriver driver = ((BaseTest) testInstance).getDriver();

        if (driver == null) {
            return;
        }

        try {
            Files.createDirectories(Path.of(SCREENSHOT_FOLDER));

            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Path targetPath = Path.of(
                    SCREENSHOT_FOLDER,
                    result.getMethod().getMethodName() + ".png"
            );

            Files.copy(screenshot.toPath(), targetPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException exception) {
            System.err.println("Could not save screenshot: " + exception.getMessage());
        }
    }
}