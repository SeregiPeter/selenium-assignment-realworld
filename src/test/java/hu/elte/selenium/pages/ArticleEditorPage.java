package hu.elte.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page Object for the New Article editor page.
 */
public class ArticleEditorPage extends BasePage {

    private final By newArticleLink = By.xpath("//a[contains(@href, '/editor')]");
    private final By titleInput = By.xpath("//input[@placeholder='Article Title']");
    private final By descriptionInput = By.xpath("//input[@placeholder=\"What's this article about?\"]");
    private final By bodyTextarea = By.xpath("//textarea[@placeholder='Write your article (in markdown)']");
    private final By tagsInput = By.xpath("//input[@placeholder='Enter tags']");
    private final By publishArticleButton = By.xpath("//button[normalize-space()='Publish Article']");

    public ArticleEditorPage(WebDriver driver) {
        super(driver);
    }

    public ArticleEditorPage openFromNavigation() {
        click(newArticleLink);
        waitUntilVisible(titleInput);
        return this;
    }

    public ArticleEditorPage fillArticleForm(String title, String description, String body, String tag) {
        type(titleInput, title);
        type(descriptionInput, description);
        type(bodyTextarea, body);
        type(tagsInput, tag);
        return this;
    }

    public void publishArticle() {
        click(publishArticleButton);
    }

    public boolean isPublishedArticleTitleVisible(String title) {
        By publishedTitle = By.xpath("//h1[normalize-space()='" + title + "']");
        return waitUntilVisible(publishedTitle).isDisplayed();
    }

    public boolean isPublishedArticleBodyVisible(String body) {
        By publishedBody = By.xpath("//*[contains(normalize-space(), '" + body + "')]");
        return waitUntilVisible(publishedBody).isDisplayed();
    }
}