package hu.elte.selenium.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Generates unique test data for registration and article tests.
 */
public class TestDataGenerator {

    private TestDataGenerator() {
        // Utility class, instances are not needed.
    }

    public static String uniqueUsername() {
        return "testuser" + timestamp();
    }

    public static String uniqueEmail() {
        return "testuser" + timestamp() + "@example.com";
    }

    public static String defaultPassword() {
        return "Password123!";
    }

    public static String uniqueArticleTitle() {
        return "Selenium Test Article " + timestamp();
    }

    public static String uniqueArticleDescription() {
        return "Short description " + timestamp();
    }

    public static String uniqueArticleBody() {
        return "This article was created by an automated Selenium test.";
    }

    public static String articleTag() {
        return "selenium";
    }

    private static String timestamp() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS"));
    }
}