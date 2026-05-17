package hu.elte.selenium.tests;

import hu.elte.selenium.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Basic smoke tests for the public home page.
 */
public class HomePageTest extends BaseTest {

    @Test
    public void homePageShouldOpenAndShowConduitBrand() {
        HomePage homePage = new HomePage(driver).open();

        Assert.assertEquals(homePage.getPageTitle(), "Conduit");
        Assert.assertTrue(homePage.isBrandVisible());
        Assert.assertTrue(homePage.isHomeLinkVisible());
        Assert.assertTrue(homePage.isGlobalFeedVisible());
    }
}