package hu.elte.selenium.tests;

import hu.elte.selenium.pages.ArticleEditorPage;
import hu.elte.selenium.pages.RegisterPage;
import hu.elte.selenium.utils.TestDataGenerator;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Tests article creation with a logged-in user.
 */
public class ArticleTest extends BaseTest {

    @Test
    public void loggedInUserShouldBeAbleToCreateArticle() {
        String username = TestDataGenerator.uniqueUsername();
        String email = TestDataGenerator.uniqueEmail();
        String password = TestDataGenerator.defaultPassword();

        String articleTitle = TestDataGenerator.uniqueArticleTitle();
        String articleDescription = TestDataGenerator.uniqueArticleDescription();
        String articleBody = TestDataGenerator.uniqueArticleBody();
        String articleTag = TestDataGenerator.articleTag();

        RegisterPage registerPage = registerNewUser(username, email, password);

        Assert.assertTrue(registerPage.isLoggedInNavigationVisible());

        ArticleEditorPage articleEditorPage = new ArticleEditorPage(driver)
                .openFromNavigation()
                .fillArticleForm(articleTitle, articleDescription, articleBody, articleTag);

        articleEditorPage.publishArticle();

        Assert.assertTrue(articleEditorPage.isPublishedArticleTitleVisible(articleTitle));
        Assert.assertTrue(articleEditorPage.isPublishedArticleBodyVisible(articleBody));
    }
}